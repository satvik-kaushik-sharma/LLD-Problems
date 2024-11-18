import ParkingSpot.ParkingSpot;
import Vehicle.VehicleType;

import java.time.LocalDate;

public class Ticket {
    ParkingSpot spot;
    VehicleType vehicleType;

    public Ticket(ParkingSpot spot, VehicleType vehicleType) {
        this.spot = spot;
        this.issuesAt = LocalDate.now();
        this.vehicleType = vehicleType;
    }

    LocalDate issuesAt;
}
