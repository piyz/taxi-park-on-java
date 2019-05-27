package by.matrosov.taxipark;

import by.matrosov.taxipark.model.Trip;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TheMostFrequentTripDurationPeriodTest extends TaxiParkUtilImpl implements TaxiParkUtil{
    @After
    public void clearLists(){
        driverList.clear();
        passengerList.clear();
    }

    private Set<Integer> initRange(int n, int m){
        Set<Integer> set = new HashSet<>();
        for (int i = n; i < m + 1; i++) {
            set.add(i);
        }
        return set;
    }

    @Test
    public void test0() {
        initDrivers(2);
        initPassengers(11);

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, null);
        Set<Integer> expected = initRange(0, -1);

        Assert.assertEquals(expected, taxiPark.findTheMostFrequentTripDurationPeriod());
    }

    @Test
    public void test1() {
        initDrivers(3);
        initPassengers(5);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(0), setPassengers(0),10),
                new Trip(setDriver(2), setPassengers(3),30),
                new Trip(setDriver(0), setPassengers(1),25),
                new Trip(setDriver(1), setPassengers(2),35)
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Integer> expected = initRange(30,39);

        Assert.assertEquals(expected, taxiPark.findTheMostFrequentTripDurationPeriod());
    }

    @Test
    public void test2() {
        initDrivers(6);
        initPassengers(10);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(setDriver(0), setPassengers(2, 9),   14,   25.0),
                new Trip(setDriver(1), setPassengers(8),   39,   37.0,   0.2),
                new Trip(setDriver(5), setPassengers(0, 5),   27,   28.0,   0.3),
                new Trip(setDriver(4), setPassengers(0, 6),   33,   14.0),
                new Trip(setDriver(2), setPassengers(5, 1, 4, 3),   2,   15.0),
                new Trip(setDriver(4), setPassengers(7),   27,   2.0),
                new Trip(setDriver(4), setPassengers(4, 6),   31,   31.0),
                new Trip(setDriver(3), setPassengers(9, 0),   34,   7.0),
                new Trip(setDriver(5), setPassengers(3),   25,   33.0),
                new Trip(setDriver(1), setPassengers(0, 7, 2, 3),   13,   17.0)
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Integer> expected = initRange(30,39);

        Assert.assertEquals(expected, taxiPark.findTheMostFrequentTripDurationPeriod());
    }
}
