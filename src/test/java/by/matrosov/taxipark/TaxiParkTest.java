package by.matrosov.taxipark;

import by.matrosov.taxipark.model.Driver;
import by.matrosov.taxipark.model.Passenger;

public interface TaxiParkTest {
    void initDrivers(int size);
    void initPassengers(int size);
    Driver getDriver(int i);
    Passenger getPassenger(int i);
}
