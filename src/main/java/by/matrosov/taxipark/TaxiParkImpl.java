package by.matrosov.taxipark;

import by.matrosov.taxipark.model.Driver;
import by.matrosov.taxipark.model.Passenger;
import by.matrosov.taxipark.model.Trip;

import java.util.*;
import java.util.stream.Collectors;

public class TaxiParkImpl implements TaxiPark{
    private final Set<Driver> allDrivers;
    private final Set<Passenger> allPassengers;
    private final List<Trip> trips;

    public TaxiParkImpl(Set<Driver> allDrivers, Set<Passenger> allPassengers, List<Trip> trips) {
        this.allDrivers = allDrivers;
        this.allPassengers = allPassengers;
        this.trips = trips;
    }

    @Override
    public Set<Driver> findFakeDrivers() {

        if (trips == null) return allDrivers;

        Set<Driver> notFakeDrivers = trips.stream()
                .map(Trip::getDriver)
                .collect(Collectors.toSet());

        return allDrivers.stream()
                .filter(driver -> !notFakeDrivers.contains(driver))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Passenger> findFaithfulPassengers(int minTrips) {

        if (minTrips == 0) return allPassengers;

        if (trips == null) return new HashSet<>();

        return trips.stream()
                .flatMap(trip -> trip.getPassengers().stream())
                .collect(Collectors.groupingBy(passenger -> passenger, Collectors.counting()))
                .entrySet().stream()
                .filter(passengerLongEntry -> passengerLongEntry.getValue() >= minTrips)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Passenger> findFrequentPassengers(Driver driver) {

        if (trips == null) return new HashSet<>();

        return trips.stream()
                .filter(trip -> trip.getDriver() == driver)
                .flatMap(trip -> trip.getPassengers().stream())
                .collect(Collectors.groupingBy(passenger -> passenger, Collectors.counting()))
                .entrySet().stream()
                .filter(passengerLongEntry -> passengerLongEntry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Passenger> findSmartPassengers() {

        if (trips == null) return new HashSet<>();

        return allPassengers.stream()
                .filter(passenger -> {

                    long withDiscount = trips.stream()
                            .filter(trip -> trip.getPassengers().contains(passenger) && trip.getDiscount() != 0)
                            .count();

                    long withoutDiscount = trips.stream()
                            .filter(trip -> trip.getPassengers().contains(passenger) && trip.getDiscount() == 0)
                            .count();

                    return withDiscount > withoutDiscount;

                }).collect(Collectors.toSet());
    }

    @Override
    public Set<Integer> findTheMostFrequentTripDurationPeriod() {

        if (trips == null) return new HashSet<>();

        Integer range = trips.stream()
                .map(Trip::getDuration)
                .collect(Collectors.groupingBy(integer -> integer / 10))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().size()
                ))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getKey();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(range * 10 + i);
        }

        return set;
    }

    @Override
    public Boolean checkParetoPrinciple() {

        if (trips == null) return false;

        int twentyPercentOfDrivers = (int) (allDrivers.size() * 0.2);

        List<Double> incomesList = allDrivers.stream()
                .map(driver ->
                        trips.stream()
                                .filter(trip -> trip.getDriver() == driver)
                                .collect(Collectors.summarizingDouble(Trip::getCost))
                                .getSum())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        double totalIncome = incomesList.stream().mapToDouble(Double::doubleValue).sum();
        double incomeByTopDrivers = incomesList.stream().mapToDouble(Double::doubleValue).limit(twentyPercentOfDrivers).sum();

        return incomeByTopDrivers / totalIncome > 0.8;
    }
}
