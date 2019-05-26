package by.matrosov.taxipark;

import by.matrosov.taxipark.model.Passenger;
import by.matrosov.taxipark.model.Trip;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SmartPassengersTest extends TaxiParkUtilImpl {
    @After
    public void clearLists(){
        driverList.clear();
        passengerList.clear();
    }

    @Test
    public void test0() {
        initDrivers(2);
        initPassengers(11);

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, null);
        Set<Passenger> expected = new HashSet<>();

        Assert.assertEquals(expected, taxiPark.findSmartPassengers());
    }

    @Test
    public void test1() {
        initDrivers(2);
        initPassengers(2);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(0), setPassengers(0),0.1),
                new Trip(setDriver(1), setPassengers(1))
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Passenger> expected = setPassengers(0);

        Assert.assertEquals(expected, taxiPark.findSmartPassengers());
    }

    @Test
    public void test2() {
        initDrivers(6);
        initPassengers(10);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(5), setPassengers(2),   33,  18.0),
                new Trip(setDriver(3), setPassengers(5, 9),   29,   16.0,   0.3),
                new Trip(setDriver(2), setPassengers(5, 3, 8),   0,   3.0),
                new Trip(setDriver(1), setPassengers(4, 8),   32,  6.0),
                new Trip(setDriver(0), setPassengers(1),   37,   28.0),
                new Trip(setDriver(2), setPassengers(0, 8),   0,   7.0),
                new Trip(setDriver(2), setPassengers(9, 4),   25,   35.0),
                new Trip(setDriver(0), setPassengers(3, 7),   30,   35.0),
                new Trip(setDriver(2), setPassengers(2, 3),   17,   27.0,   0.4),
                new Trip(setDriver(1), setPassengers(9, 5, 4),   5,   7.0)
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Passenger> expected = new HashSet<>();

        Assert.assertEquals(expected, taxiPark.findSmartPassengers());
    }

    @Test
    public void test3() {
        initDrivers(3);
        initPassengers(3);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(2), setPassengers(2, 1),   14,   10.0,   0.4),
                new Trip(setDriver(1), setPassengers(1, 2, 0),   20,   26.0),
                new Trip(setDriver(0), setPassengers(2, 0),   15,   14.0,   0.4),
                new Trip(setDriver(0), setPassengers(2, 1),   4,   17.0,   0.2),
                new Trip(setDriver(1), setPassengers(0, 1, 2),   35,   23.0),
                new Trip(setDriver(2), setPassengers(1),   28,   5.0),
                new Trip(setDriver(0), setPassengers(0),   30,   25.0,   0.3),
                new Trip(setDriver(0), setPassengers(2, 0),   24,   13.0),
                new Trip(setDriver(0), setPassengers(0, 2),   5,   5.0,   0.2),
                new Trip(setDriver(0), setPassengers(2),   39,   29.0,   0.1),
                new Trip(setDriver(1), setPassengers(0, 2),   25,  9.0),
                new Trip(setDriver(2), setPassengers(2, 0),   36,   23.0,   0.2)
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Passenger> expected = setPassengers(2);

        Assert.assertEquals(expected, taxiPark.findSmartPassengers());
    }

    @Test
    public void test4() {
        initDrivers(3);
        initPassengers(3);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(2), setPassengers(0),   8,   2.0),
                new Trip(setDriver(1), setPassengers(2),   36,   8.0),
                new Trip(setDriver(1), setPassengers(1),   29,   8.0,   0.1),
                new Trip(setDriver(2), setPassengers(0),   22,   10.0,   0.4),
                new Trip(setDriver(1), setPassengers(1),   16,   27.0),
                new Trip(setDriver(1), setPassengers(0, 1),   20,  35.0,   0.3),
                new Trip(setDriver(0), setPassengers(2, 0),   12,   18.0),
                new Trip(setDriver(0), setPassengers(1),   25,   21.0),
                new Trip(setDriver(0), setPassengers(2, 1),   9,   23.0,   0.3),
                new Trip(setDriver(2), setPassengers(2),   12,   8.0),
                new Trip(setDriver(1), setPassengers(1, 2, 0),   24,   10.0,   0.3),
                new Trip(setDriver(2), setPassengers(1),   18,   14.0,   0.3)
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Passenger> expected = setPassengers(0,1);

        Assert.assertEquals(expected, taxiPark.findSmartPassengers());
    }
}
