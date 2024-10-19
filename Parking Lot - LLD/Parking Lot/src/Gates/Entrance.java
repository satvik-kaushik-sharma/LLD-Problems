package Gates;

import Location.Location;
import ParkingSpot.ClosestToEntranceStrategy;
import ParkingSpot.Spot;
import SpotMangaer.SpotManger;
import SpotMangaer.SpotMangerFactory;
import Ticket.Ticket;
import Vehicle.Vehicle;

public class Entrance {
    SpotMangerFactory managerFactory;
    Location location;

    public Entrance(int x, int y) {
        this.managerFactory = new SpotMangerFactory();
        this.location = new Location(x, y);
    }

    public Ticket handleVehicleEntry(Vehicle vehicle) {
//        why not pass strategy object from here - DONE
        SpotManger manager = this.managerFactory
                .getSpotManagerByVehicleType(vehicle.getType(), new ClosestToEntranceStrategy(this.location));
        Spot assignedSpot = manager.assignSpot(vehicle);
        return new Ticket(vehicle, assignedSpot);
    }

}
