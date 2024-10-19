package ParkingSpot;

import Location.Location;
import Vehicle.Vehicle;

public abstract class Spot {
    private Location location;
    private Vehicle vehicle;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "vehicle=" + (vehicle != null ? vehicle.getName() : "Empty") +
                ", location=" + location.getX() + ","  +location.getY()+
                '}';
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Spot(Location location, Vehicle vehicle) {
        this.location = location;
        this.vehicle = vehicle;
    }
}
