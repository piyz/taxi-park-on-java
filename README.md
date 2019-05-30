## Taxi Park

*The TaxiPark class stores information about registered drivers, passengers, and their trips. Your task is to implement six functions which collect different statistics about the data.*

*Those six functions/methods you will find in TaxiParkImpl.class. After that how you implements those functions try to passed all tests.*

* 1. `Set<Driver> findFakeDrivers(): Find all the drivers who didn't perform any trips.`
---
* 2. `Set<Passenger> findFaithfulPassengers(int minTrips): Find all the clients who completed at least the given number of trips.`
---
* 3. `Set<Passenger> FrequentPassengers(Driver driver): Find all the passengers who were driven by a certain driver more than once.`
---
* 4. `Set<Passenger> findSmartPassengers(): If we consider "smart", a passenger who had a discount for the majority of the rips they made or took part in (including the trips with more than one passenger), find all the "smart" passengers. A "smart" passenger should have strictly more trips with discount than trips without discount, the equal amounts of trips with and without discount isn't enough.`
---
* 5. `Set<Passenger> findTheMostFrequentTripDurationPeriod(): Find the most frequent trip duration period among minute periods 0..9, 10..19, 20..29, and so on. Return any suitable period if many are the most frequent, return null if there're no trips.`
---
* 6. `Boolean checkParetoPrinciple(): Check whether no more than 20% of the drivers contribute 80% of the income. The function should return true if the top 20% drivers (meaning the top 20% best performers) represent 80% or more of all trips total income, or false if not. The drivers that have no trips should be considered as contributing zero income. If the taxi park contains no trips, the result should be false.For example, if there're 39 drivers in the taxi park, we need to check that no more than 20% of the most successful ones, which is seven drivers (39 * 0.2 = 7.8), contribute at least 80% of the total income. Note that eight drivers out of 39 is 20.51% which is more than 20%, so we check the income of seven the most successful drivers.`
