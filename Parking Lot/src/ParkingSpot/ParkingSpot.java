package ParkingSpot;

public abstract class ParkingSpot {
    SpotLocation location;
    Boolean isAvailable;
    public ParkingSpot(SpotLocation location) {
        this.location = location;
        this.isAvailable = true;
    }

    public SpotLocation getLocation() {
        return location;
    }

    public void setLocation(SpotLocation location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return !this.isAvailable;
    }

    public void reserve() {
        this.isAvailable = false;
    }

    public void release() {
        this.isAvailable = true;
    }
}
