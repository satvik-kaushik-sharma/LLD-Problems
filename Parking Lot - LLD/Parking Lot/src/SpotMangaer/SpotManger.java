package SpotMangaer;

import ParkingSpot.Spot;
import ParkingSpot.SpotAssignmentStrategy;
import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public abstract class SpotManger {
    List<Spot> spots;
    SpotAssignmentStrategy assignmentStrategy;

    public SpotManger(SpotAssignmentStrategy assignmentStrategy) {
        this.assignmentStrategy = assignmentStrategy;
    }

    public Spot assignSpot(Vehicle vehicle) {
        Spot spot =  this.assignmentStrategy.getEmptySpot(this.spots);
        spot.setVehicle(vehicle);
        return spot;
    }

    public void freeSpot(Spot spot) {
        spot.setVehicle(null);
    }
}
