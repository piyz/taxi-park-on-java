package by.matrosov.taxipark.model;

import java.util.Set;

public class Trip {
    private final Driver driver;
    private final Set<Passenger> passengers;
    private final int duration;
    private final double distance;
    private final double discount;
    private final double cost;

    public Trip(Driver driver, Set<Passenger> passengers, int duration, double distance, double discount, double cost) {
        this.driver = driver;
        this.passengers = passengers;
        this.duration = duration;
        this.distance = distance;
        this.discount = discount;
        this.cost = (1 - discount) * (duration + distance);
    }

    public Driver getDriver() {
        return driver;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public int getDuration() {
        return duration;
    }

    public double getDistance() {
        return distance;
    }

    public double getDiscount() {
        return discount;
    }

    public double getCost() {
        return cost;
    }
}
