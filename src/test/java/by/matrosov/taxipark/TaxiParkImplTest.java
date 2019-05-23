package by.matrosov.taxipark;

import by.matrosov.taxipark.model.Driver;
import by.matrosov.taxipark.model.Passenger;
import by.matrosov.taxipark.model.Trip;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class TaxiParkImplTest implements TaxiParkTest{

    private static List<Driver> driverList = new ArrayList<>();
    private static List<Passenger> passengerList = new ArrayList<>();
    private static Set<Driver> driverSet;
    private static Set<Passenger> passengerSet;

    @After
    public void clearLists(){
        driverList.clear();
        passengerList.clear();
    }

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
    public Driver getDriver(int i) {
        return driverList.get(i);
    }

    @Override
    public Passenger getPassenger(int i) {
        return passengerList.get(i);
    }

    @Test
    public void test0() {
        initDrivers(3);
        initPassengers(5);

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, null);
        Set<Driver> expected = new HashSet<>(driverList);

        Assert.assertEquals(expected, taxiPark.findFakeDrivers());
    }

    @Test
    public void test1() {
        initDrivers(3);
        initPassengers(2);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(getDriver(0), new HashSet<>(Arrays.asList(getPassenger(0)))),
                new Trip(getDriver(0), new HashSet<>(Arrays.asList(getPassenger(1))))
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Driver> expected = new HashSet<>(Arrays.asList(getDriver(1), getDriver(2)));

        Assert.assertEquals(expected, taxiPark.findFakeDrivers());
    }

    @Test
    public void test2() {
        initDrivers(4);
        initPassengers(10);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(getDriver(2), new HashSet<>(Arrays.asList(getPassenger(9))), 9, 36.0),
                new Trip(getDriver(1), new HashSet<>(Arrays.asList(getPassenger(0))), 15, 28.0),
                new Trip(getDriver(2), new HashSet<>(Arrays.asList(getPassenger(1))), 37, 30.0),
                new Trip(getDriver(0), new HashSet<>(Arrays.asList(getPassenger(9))), 24, 10.0),
                new Trip(getDriver(1), new HashSet<>(Arrays.asList(getPassenger(2))), 1, 6.0),
                new Trip(getDriver(0), new HashSet<>(Arrays.asList(getPassenger(0), getPassenger(9))), 9, 7.0),
                new Trip(getDriver(2), new HashSet<>(Arrays.asList(getPassenger(3), getPassenger(2), getPassenger(8))), 18, 39.0, 0.1),
                new Trip(getDriver(1), new HashSet<>(Arrays.asList(getPassenger(9), getPassenger(4))), 19, 1.0, 0.2),
                new Trip(getDriver(1), new HashSet<>(Arrays.asList(getPassenger(3))), 16, 23.0),
                new Trip(getDriver(2), new HashSet<>(Arrays.asList(getPassenger(4))),10, 31.0, 0.2)
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Driver> expected = new HashSet<>(Arrays.asList(getDriver(3)));

        Assert.assertEquals(expected, taxiPark.findFakeDrivers());
    }

    @Test
    public void test3() {
        initDrivers(5);
        initPassengers(10);

        List<Trip> trips = new ArrayList<>(Arrays.asList(
                new Trip(getDriver(3), new HashSet<>(Arrays.asList(getPassenger(2))), 24, 7.0),
                new Trip(getDriver(3), new HashSet<>(Arrays.asList(getPassenger(8), getPassenger(5), getPassenger(9))), 30, 23.0, 0.4),
                new Trip(getDriver(3), new HashSet<>(Arrays.asList(getPassenger(4), getPassenger(9), getPassenger(3), getPassenger(7))), 24, 8.0),
                new Trip(getDriver(1), new HashSet<>(Arrays.asList(getPassenger(2))), 32, 27.0, 0.2),
                new Trip(getDriver(3), new HashSet<>(Arrays.asList(getPassenger(0), getPassenger(5), getPassenger(7), getPassenger(6))), 38, 3.0, 0.2),
                new Trip(getDriver(3), new HashSet<>(Arrays.asList(getPassenger(8), getPassenger(0))), 6, 39.0),
                new Trip(getDriver(1), new HashSet<>(Arrays.asList(getPassenger(3), getPassenger(1), getPassenger(8))), 18, 39.0, 0.2),
                new Trip(getDriver(3), new HashSet<>(Arrays.asList(getPassenger(6), getPassenger(5))), 19, 21),
                new Trip(getDriver(1), new HashSet<>(Arrays.asList(getPassenger(8), getPassenger(0))), 5, 5.0),
                new Trip(getDriver(3), new HashSet<>(Arrays.asList(getPassenger(3), getPassenger(7), getPassenger(9))),24, 20.0)
        ));

        TaxiParkImpl taxiPark = new TaxiParkImpl(driverSet, passengerSet, trips);
        Set<Driver> expected = new HashSet<>(Arrays.asList(getDriver(0), getDriver(2), getDriver(4)));

        Assert.assertEquals(expected, taxiPark.findFakeDrivers());
    }

    /*
    private Set<Passenger> getPassengers(int... ints){
        Set<Passenger> passengers = new HashSet<>();
        for (int i = 0; i < ints.length; i++) {
            passengers.add(getPassenger(i));
        }
        return passengers;
    }
     */
}