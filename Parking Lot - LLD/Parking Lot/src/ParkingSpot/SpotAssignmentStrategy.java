package ParkingSpot;

import java.util.List;
import java.util.PriorityQueue;

// Default strategy - 1st empty found
public class SpotAssignmentStrategy {

    public SpotAssignmentStrategy() {
    }

    public Spot getEmptySpot(List<Spot> spots) {
        for (Spot spot : spots) {
            if (spot.getVehicle() == null) {
                return spot;
            }
        }
        return null;
    }
}
