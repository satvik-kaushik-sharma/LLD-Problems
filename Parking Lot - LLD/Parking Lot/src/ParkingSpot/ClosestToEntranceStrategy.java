package ParkingSpot;

import Location.Location;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// having problem with PQ since this class gets init on every handleVehicleEntry
// => heap is filled again with all the spots
// => on every new vehicle we get the first closest spot only
// also, this does not look like it'll work in a real system
// maintaining a DS with data in runtime which may have been changed in DB(by some other DB call) doesn't make sense
// adding if(spot.getVehicle() == null) fixed the bug the problem is still there
// I think DS are built by fetching some data and are needed for processing that data and generating result efficiently
// we can store data in run time and respond from it,
// we will need to write logic to find the closest empty spot by processing data fetched from the DB
// or end data while calling a function


// Solution ----> Build a common HeapManager class - difficult to implement - stick to normal implementation -
// reading all data from a common central service having a map of spots and updating it with any change that occurs across app - will have common instance everywhere

// KEEP IT SIMPLE


//public class ClosestToEntranceStrategy extends SpotAssignmentStrategy {
//    PriorityQueue<Spot> spotsHeap;
//    Location entranceLocation;
//
//    public ClosestToEntranceStrategy(List<Spot> spots, Location entranceLocation) {
//        this.spotsHeap = new PriorityQueue<>(Comparator.comparingInt(spot -> manhattanDistance(spot.getLocation(), entranceLocation)));
//        for(Spot spot: spots) {
//            if(spot.getVehicle() == null) this.spotsHeap.add(spot);
//        }
//    }
//
//    private static int manhattanDistance(Location l, Location origin) {
//        return Math.abs(l.getX()-origin.getX()) + Math.abs(l.getY()-origin.getY());
//    }
//
//
//    public Spot getEmptySpot(List<Spot> spots) {
//        return spotsHeap.poll();
//    }
//}

//v2
public class ClosestToEntranceStrategy extends SpotAssignmentStrategy {
    Location entranceLocation;

    public ClosestToEntranceStrategy(Location entranceLocation) {
        this.entranceLocation = entranceLocation;

    }

    private static int manhattanDistance(Location l, Location origin) {
        return Math.abs(l.getX() - origin.getX()) + Math.abs(l.getY() - origin.getY());
    }

    public Spot getEmptySpot(List<Spot> spots) {
        Spot closestSpot = null;
        int mnDist = -1;
        for (Spot spot : spots) {
            if (spot.getVehicle() == null && (closestSpot == null || mnDist > manhattanDistance(spot.getLocation(), this.entranceLocation))) {
                closestSpot = spot;
                mnDist = manhattanDistance(spot.getLocation(), this.entranceLocation);
            }
        }
        return closestSpot;
    }
}

