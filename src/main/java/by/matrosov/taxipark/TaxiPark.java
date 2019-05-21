package by.matrosov.taxipark;

import by.matrosov.taxipark.model.Driver;

import java.util.Set;

public interface TaxiPark {
    Set<Driver> findFakeDrivers();
}
