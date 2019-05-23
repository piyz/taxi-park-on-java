package by.matrosov.taxipark;

import by.matrosov.taxipark.model.Driver;
import by.matrosov.taxipark.model.Passenger;
import by.matrosov.taxipark.model.Trip;

import java.util.List;
import java.util.Set;
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

        if (trips == null){
            return allDrivers;
        }

        Set<Driver> notFakeDrivers = trips.stream()
                .map(Trip::getDriver)
                .collect(Collectors.toSet());

        return allDrivers.stream()
                .filter(driver -> !notFakeDrivers.contains(driver))
                .collect(Collectors.toSet());
    }
}
