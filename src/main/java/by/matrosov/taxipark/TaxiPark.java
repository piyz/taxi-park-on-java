package by.matrosov.taxipark;

import by.matrosov.taxipark.model.Driver;
import by.matrosov.taxipark.model.Passenger;

import java.util.Set;

public interface TaxiPark {
    Set<Driver> findFakeDrivers();
    Set<Passenger> findFaithfulPassengers(int minTrips);
    Set<Passenger> findFrequentPassengers(Driver driver);
    Set<Passenger> findSmartPassengers();
    Set<Integer> findTheMostFrequentTripDurationPeriod();
    Boolean checkParetoPrinciple();
}
