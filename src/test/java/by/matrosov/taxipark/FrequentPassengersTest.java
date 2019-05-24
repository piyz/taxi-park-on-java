package by.matrosov.taxipark;

import by.matrosov.taxipark.model.Passenger;
import by.matrosov.taxipark.model.Trip;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class FrequentPassengersTest extends TaxiParkUtilImpl {
    @After
    public void clearLists(){
        driverList.clear();
        passengerList.clear();
    }

    @Test
    public void test0() {
        initDrivers(2);
        initPassengers(4);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(0), setPassengers(0)),
                new Trip(setDriver(0), setPassengers(0)),
                new Trip(setDriver(0), setPassengers(0,2)),
                new Trip(setDriver(0), setPassengers(2)),
                new Trip(setDriver(0), setPassengers(1)),
                new Trip(setDriver(1), setPassengers(1))
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Passenger> expected = setPassengers(0,2);

        Assert.assertEquals(expected, taxiPark.findFrequentPassengers(setDriver(0)));
    }

    @Test
    public void test1() {
        initDrivers(3);
        initPassengers(8);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(1), setPassengers(3, 6, 4, 1), 26, 22.0),
                new Trip(setDriver(2), setPassengers(7), 18, 27.0),
                new Trip(setDriver(1), setPassengers(1), 11, 37.0),
                new Trip(setDriver(0), setPassengers(0,7), 1, 6.0),
                new Trip(setDriver(2), setPassengers(6,7,5), 1, 37.0, 0.4),
                new Trip(setDriver(2), setPassengers(5,0), 39, 39.0, 0.2),
                new Trip(setDriver(0), setPassengers(1), 6, 15.0, 0.3),
                new Trip(setDriver(2), setPassengers(7), 36, 26.0, 0.1),
                new Trip(setDriver(2), setPassengers(5), 5, 24.0),
                new Trip(setDriver(1), setPassengers(7, 5, 0, 1), 18, 22.0, 0.3)
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Passenger> expected = setPassengers(5,7);

        Assert.assertEquals(expected, taxiPark.findFrequentPassengers(setDriver(2)));
    }

    @Test
    public void test2() {
        initDrivers(3);
        initPassengers(8);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(1), setPassengers(3, 6, 4, 1), 26, 22.0),
                new Trip(setDriver(2), setPassengers(7), 18, 27.0),
                new Trip(setDriver(1), setPassengers(1), 11, 37.0),
                new Trip(setDriver(0), setPassengers(0,7), 1, 6.0),
                new Trip(setDriver(2), setPassengers(6,7,5), 1, 37.0, 0.4),
                new Trip(setDriver(2), setPassengers(5,0), 39, 39.0, 0.2),
                new Trip(setDriver(0), setPassengers(1), 6, 15.0, 0.3),
                new Trip(setDriver(2), setPassengers(7), 36, 26.0, 0.1),
                new Trip(setDriver(2), setPassengers(5), 5, 24.0),
                new Trip(setDriver(1), setPassengers(7, 5, 0, 1), 18, 22.0, 0.3)
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Passenger> expected = setPassengers(1);

        Assert.assertEquals(expected, taxiPark.findFrequentPassengers(setDriver(1)));
    }

    @Test
    public void test3() {
        initDrivers(5);
        initPassengers(8);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(2), setPassengers(6, 3, 4),35,   14.0,   0.4),
                new Trip(setDriver(0), setPassengers(2, 1, 5),  13,   2.0,   0.4),
                new Trip(setDriver(0), setPassengers(1, 0),   14,   21.0),
                new Trip(setDriver(1), setPassengers(7),  18,  19.0,  0.4),
                new Trip(setDriver(2), setPassengers(3),  18,  24.0,   0.2),
                new Trip(setDriver(2), setPassengers(6, 3), 8,  32.0),
                new Trip(setDriver(2), setPassengers(3, 6),  36,   0.0,   0.4),
                new Trip(setDriver(1), setPassengers(3, 0, 2, 7),   30,  23.0),
                new Trip(setDriver(1), setPassengers(0, 4, 3, 1),   5,  39.0),
                new Trip(setDriver(1), setPassengers(2, 7),   12,  38.0)
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Passenger> expected = setPassengers(0,2,3,7);

        Assert.assertEquals(expected, taxiPark.findFrequentPassengers(setDriver(1)));
    }
}
