package by.matrosov.taxipark;

import by.matrosov.taxipark.model.Driver;
import by.matrosov.taxipark.model.Passenger;

import java.util.Set;

public interface TaxiParkTest {
    void initDrivers(int size);
    void initPassengers(int size);
    Driver setDriver(int i);
    Set<Passenger> setPassengers(int... ints);
}
