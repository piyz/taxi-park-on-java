package by.matrosov.taxipark;

import by.matrosov.taxipark.model.Driver;
import by.matrosov.taxipark.model.Passenger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class TaxiParkUtilImpl implements TaxiParkUtil {

    static List<Driver> driverList = new ArrayList<>();
    static List<Passenger> passengerList = new ArrayList<>();
    static Set<Driver> driverSet;
    static Set<Passenger> passengerSet;

    @Override
    public void initDrivers(int size) {
        for (int i = 0; i < size; i++) {
            driverList.add(new Driver("d" + i));
        }
        driverSet = new HashSet<>(driverList);
    }

    @Override
    public void initPassengers(int size) {
        for (int i = 0; i < size; i++) {
            passengerList.add(new Passenger("p" + i));
        }
        passengerSet = new HashSet<>(passengerList);
    }

    @Override
    public Driver setDriver(int i) {
        return driverList.get(i);
    }

    @Override
    public Set<Driver> setDrivers(int... ints) {
        Set<Driver> drivers = new HashSet<>();
        for (int i : ints) {
            drivers.add(getDriver(i));
        }
        return drivers;
    }

    @Override
    public Set<Passenger> setPassengers(int... ints) {
        Set<Passenger> passengers = new HashSet<>();
        for (int i : ints) {
            passengers.add(getPassenger(i));
        }
        return passengers;
    }

    private Passenger getPassenger(int i) {
        return passengerList.get(i);
    }

    private Driver getDriver(int i) {
        return driverList.get(i);
    }
}
