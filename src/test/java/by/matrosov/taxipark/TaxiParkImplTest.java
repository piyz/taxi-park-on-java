package by.matrosov.taxipark;

import by.matrosov.taxipark.model.Driver;
import by.matrosov.taxipark.model.Passenger;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaxiParkImplTest {

    @Test
    public void findFakeDrivers1() {
        Set<Driver> drivers = new HashSet<>(Arrays.asList(
                new Driver("a"),
                new Driver("b"),
                new Driver("c")
        ));
        Set<Passenger> passengers = new HashSet<>(Arrays.asList(
                new Passenger("a"),
                new Passenger("b"),
                new Passenger("c"),
                new Passenger("d")
        ));
        TaxiParkImpl taxiPark = new TaxiParkImpl(drivers, passengers, null);

        Set<Driver> expected = new HashSet<>(Arrays.asList(
                new Driver("a"),
                new Driver("b"),
                new Driver("c")
        ));

        Assert.assertSame(expected, taxiPark.findFakeDrivers());
    }
}