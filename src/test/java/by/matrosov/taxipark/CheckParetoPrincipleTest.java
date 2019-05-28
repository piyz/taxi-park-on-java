package by.matrosov.taxipark;

import by.matrosov.taxipark.model.Trip;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckParetoPrincipleTest extends TaxiParkUtilImpl implements TaxiParkUtil{
    @After
    public void clearLists(){
        driverList.clear();
        passengerList.clear();
    }

    @Test
    public void test0() {
        initDrivers(5);
        initPassengers(4);

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, null);

        Assert.assertFalse(taxiPark.checkParetoPrinciple());
    }

    @Test
    public void test1() {
        initDrivers(5);
        initPassengers(4);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(0), setPassengers(0), 20, 20.0),
                new Trip(setDriver(0), setPassengers(1), 20, 20.0),
                new Trip(setDriver(0), setPassengers(2), 20, 20.0),
                new Trip(setDriver(0), setPassengers(3), 20, 20.0),
                new Trip(setDriver(1), setPassengers(0), 20, 19.0)
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);

        Assert.assertTrue(taxiPark.checkParetoPrinciple());
    }

    @Test
    public void test2() {
        initDrivers(5);
        initPassengers(4);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(0), setPassengers(0), 20, 20.0),
                new Trip(setDriver(0), setPassengers(1), 20, 20.0),
                new Trip(setDriver(0), setPassengers(2), 20, 20.0),
                new Trip(setDriver(0), setPassengers(3), 20, 20.0),
                new Trip(setDriver(1), setPassengers(0), 20, 21.0)
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);

        Assert.assertFalse(taxiPark.checkParetoPrinciple());
    }

    @Test
    public void test3() {
        initDrivers(5);
        initPassengers(10);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(4), setPassengers(2),   3,   23.0,   0.3),
                new Trip(setDriver(4), setPassengers(4),   27,   8.0,   0.1),
                new Trip(setDriver(4), setPassengers(7),   25,   29.0,   0.2),
                new Trip(setDriver(3), setPassengers(7),   1,   8.0,   0.4),
                new Trip(setDriver(0), setPassengers(2),   18,   2.0,   0.3),
                new Trip(setDriver(4), setPassengers(7),   26,   27.0),
                new Trip(setDriver(4), setPassengers(9),   11,   23.0),
                new Trip(setDriver(4), setPassengers(4, 2, 0),   5,   20.0,   0.1),
                new Trip(setDriver(2), setPassengers(6, 7),   4,   13.0),
                new Trip(setDriver(4), setPassengers(2, 8, 1, 4),   19,   24.0,   0.3),
                new Trip(setDriver(4), setPassengers(6),17,19.0),
                new Trip(setDriver(0), setPassengers(9),15,7.0,0.2),
                new Trip(setDriver(0), setPassengers(7, 3),0,10.0,0.2),
                new Trip(setDriver(4), setPassengers(9, 3),15,13.0),
                new Trip(setDriver(3), setPassengers(0),11,3.0,0.2)
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);

        Assert.assertTrue(taxiPark.checkParetoPrinciple());
    }
}
