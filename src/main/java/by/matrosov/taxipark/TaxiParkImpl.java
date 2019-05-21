package by.matrosov.taxipark;

import by.matrosov.taxipark.model.Driver;
import by.matrosov.taxipark.model.Passenger;
import by.matrosov.taxipark.model.Trip;

import java.util.List;
import java.util.Set;

public class TaxiParkImpl implements TaxiPark{
    private final Set<Driver> allDrivers;
    private final Set<Passenger> allPassengers;
    private final List<Trip> trips;

    public TaxiParkImpl(Set<Driver> allDrivers, Set<Passenger> allPassengers, List<Trip> trips) {
        this.allDrivers = allDrivers;
        this.allPassengers = allPassengers;
        this.trips = trips;
    }

    public Set<Driver> getAllDrivers() {
        return allDrivers;
    }

    public Set<Passenger> getAllPassengers() {
        return allPassengers;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    @Override
    public Set<Driver> findFakeDrivers() {
        return null;
    }
}
