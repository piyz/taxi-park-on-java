Taxi Park

The TaxiPark class stores information about registered drivers, passengers, and their trips. Your task is to implement six functions which collect different statistics about the data.

SubTask 1

Set<Driver> findFakeDrivers() Find all the drivers who didn't perform any trips.

SubTask 2

Set<Passenger> findFaithfulPassengers(int minTrips) Find all the clients who completed at least the given number of trips.

SubTask3

Set<Passenger> FrequentPassengers(driver: Driver) Find all the passengers who were driven by a certain driver more than once.

SubTask4

Set<Passenger> findSmartPassengers() If we consider "smart", a passenger who had a discount for the majority of the 
trips they made or took part in (including the trips with more than one passenger), find all the "smart" passengers. 
A "smart" passenger should have strictly more trips with discount than trips without discount, the equal amounts of 
trips with and without discount isn't enough.

SubTask5

Set<Passenger> findTheMostFrequentTripDurationPeriod(): Find the most frequent trip duration period among 
minute periods 0..9, 10..19, 20..29, and so on. Return any suitable period if many are the most frequent, return null 
if there're no trips.