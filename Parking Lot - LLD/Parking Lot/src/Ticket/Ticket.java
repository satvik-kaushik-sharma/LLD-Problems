package Ticket;

import ParkingSpot.Spot;
import Vehicle.Vehicle;

import java.time.LocalTime;

public class Ticket {
    private Vehicle vehicle;
    private Spot spot;
    private LocalTime issuedAt;

    public LocalTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalTime issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Ticket(Vehicle vehicle, Spot spot) {
        this.vehicle = vehicle;
        this.spot = spot;
        this.issuedAt = LocalTime.now();
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


}
