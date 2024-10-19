package Gates;

import Location.Location;
import SpotMangaer.SpotManger;
import SpotMangaer.SpotMangerFactory;
import Ticket.Ticket;

import java.time.Duration;
import java.time.LocalTime;

public class Exit {
    SpotMangerFactory managerFactory;
//     todo include billing strategy - pass in from client class (main) - use it to generate bills
    public Exit() {
        this.managerFactory = new SpotMangerFactory();
    }

    public void handleExit(Ticket ticket) {
        SpotManger manager = this.managerFactory.getSpotManagerByVehicleType(ticket.getVehicle().getType(), null);
        manager.freeSpot(ticket.getSpot());
        LocalTime now = LocalTime.now();
        long cost = Duration.between(ticket.getIssuedAt(), now).toSeconds();
        System.out.println("Charge Client: " + cost);
    }
}
