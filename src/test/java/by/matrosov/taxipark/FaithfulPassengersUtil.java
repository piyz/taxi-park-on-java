package by.matrosov.taxipark;

import by.matrosov.taxipark.model.Passenger;
import by.matrosov.taxipark.model.Trip;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class FaithfulPassengersUtil extends TaxiParkUtilImpl {

    @After
    public void clearLists(){
        driverList.clear();
        passengerList.clear();
    }

    @Test
    public void test0() {
        initDrivers(3);
        initPassengers(5);

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, null);
        Set<Passenger> expected = new HashSet<>(); //null

        Assert.assertEquals(expected, taxiPark.findFaithfulPassengers(1));
    }

    @Test
    public void test1() {
        initDrivers(3);
        initPassengers(5);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(0), setPassengers(0)),
                new Trip(setDriver(1), setPassengers(0)),
                new Trip(setDriver(0), setPassengers(3)),
                new Trip(setDriver(2), setPassengers(3)),
                new Trip(setDriver(0), setPassengers(4)),
                new Trip(setDriver(1), setPassengers(4)),
                new Trip(setDriver(1), setPassengers(1))
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Passenger> expected = setPassengers(0,3,4);

        Assert.assertEquals(expected, taxiPark.findFaithfulPassengers(2));
    }

    @Test
    public void test2() {
        initDrivers(6);
        initPassengers(6);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(3), setPassengers(2), 9, 4.0, 0.3),
                new Trip(setDriver(3), setPassengers(5,2,0), 13, 1.0, 0.2),
                new Trip(setDriver(2), setPassengers(1,2,0), 33, 23.0),
                new Trip(setDriver(2), setPassengers(5,4), 16, 5.0),
                new Trip(setDriver(0), setPassengers(2,1), 37, 20.0),
                new Trip(setDriver(1), setPassengers(2,4), 18, 22.0),
                new Trip(setDriver(3), setPassengers(5), 20, 27.0, 0.1),
                new Trip(setDriver(1), setPassengers(0,4), 18, 13.0, 0.1),
                new Trip(setDriver(4), setPassengers(1,3), 19, 31.0, 0.2),
                new Trip(setDriver(3), setPassengers(4),29, 11.0, 0.1)
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Passenger> expected = setPassengers(0, 1, 2, 4, 5);

        Assert.assertEquals(expected, taxiPark.findFaithfulPassengers(3));
    }

    @Test
    public void test3() {
        initDrivers(6);
        initPassengers(6);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(3), setPassengers(2), 5, 4.0, 0.3),
                new Trip(setDriver(3), setPassengers(5, 2, 0), 13, 1.0, 0.2),
                new Trip(setDriver(2), setPassengers(1, 2, 0), 33, 23.0),
                new Trip(setDriver(2), setPassengers(5,4), 16, 5.0),
                new Trip(setDriver(0), setPassengers(2,1), 37, 20.0),
                new Trip(setDriver(1), setPassengers(2,4), 18, 22.0),
                new Trip(setDriver(3), setPassengers(5), 20, 27.0,0.1),
                new Trip(setDriver(1), setPassengers(0,4), 18, 13.0,0.1),
                new Trip(setDriver(4), setPassengers(1,3), 19, 31.0,0.2),
                new Trip(setDriver(3), setPassengers(4),29, 11.0,0.1)
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Passenger> expected = setPassengers(2,4);

        Assert.assertEquals(expected, taxiPark.findFaithfulPassengers(4));
    }

    /*
    @Test
    public void test4() {
        initDrivers(4);
        initPassengers(8);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(6), setPassengers(0), 36, 1.0, 0.3),
                new Trip(setDriver(7), setPassengers(3, 5), 34,11.0),
                new Trip(setDriver(9), setPassengers(15, 1), 13, 12.0),
                new Trip(setDriver(3), setPassengers(7), 15, 30, 0.2),
                new Trip(setDriver(9), setPassengers(8, 6, 7, 11), 36, 16.0),
                new Trip(setDriver(3), setPassengers(11, 8, 15, 6), 37, 32.0, 0.4),
                new Trip(setDriver(2), setPassengers(1, 6), 12, 15, 0.1),
                new Trip(setDriver(2), setPassengers(3, 2, 19), 2, 11.0, 0.2),
                new Trip(setDriver(3), setPassengers(7, 5), 26, 10.0, 0.3),
                new Trip(setDriver(3), setPassengers(6, 4),10, 35.0),
                new Trip(setDriver(7), setPassengers(7, 14),27, 2.0, 0.3),
                new Trip(setDriver(3), setPassengers(3, 11),1, 33.0),
                new Trip(setDriver(7), setPassengers(3),26, 4.0, 0.4),
                new Trip(setDriver(2), setPassengers(18, 7),15, 6.0, 0.4),
                new Trip(setDriver(2), setPassengers(0, 1, 2),30, 17.0),
                new Trip(setDriver(2), setPassengers(0, 11),32, 5.0, 0.4),
                new Trip(setDriver(9), setPassengers(0, 15),27, 3.0),
                new Trip(setDriver(9), setPassengers(11, 15),11, 15.0,0.2),
                new Trip(setDriver(2), setPassengers(12, 14, 8),31, 34.0),
                new Trip(setDriver(7), setPassengers(15, 11),1, 3.0)
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Passenger> expected = setPassengers(2,3,6,7);

        Assert.assertEquals(expected, taxiPark.findFaithfulPassengers(8));
    }
     */
}
