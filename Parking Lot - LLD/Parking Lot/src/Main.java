import Gates.Entrance;
import Gates.Exit;
import ParkingSpot.Spot;
import SpotMangaer.ParkingData;
import Ticket.Ticket;
import Vehicle.Vehicle;
import Vehicle.VehicleType;

public class Main {
    public static void main(String[] args) {
        Entrance entrance = new Entrance(0, 0);
        Entrance entrance2 = new Entrance(2, 2);
        Exit exit = new Exit();
        Vehicle v1 = new Vehicle("V1", "1", VehicleType.TwoWheeler);
        Vehicle v2 = new Vehicle("V2", "2", VehicleType.TwoWheeler);
        Vehicle v3 = new Vehicle("V3", "3", VehicleType.TwoWheeler);
        Vehicle v4 = new Vehicle("V4", "4", VehicleType.TwoWheeler);
        Vehicle v5 = new Vehicle("V5", "5", VehicleType.TwoWheeler);
        Vehicle v6 = new Vehicle("V6", "6", VehicleType.TwoWheeler);

        Ticket t1 = entrance.handleVehicleEntry(v1);
        Ticket t2 = entrance.handleVehicleEntry(v2);
        Ticket t4 = entrance2.handleVehicleEntry(v4);

        for (Spot spot : ParkingData.TwoWheelerData) {
            System.out.println(spot.toString());
        }
//        exit.handleExit(t1);

        Ticket t3 = entrance.handleVehicleEntry(v3);
        setTimeout(() -> {
            exit.handleExit(t1);
            for (Spot spot : ParkingData.TwoWheelerData) {
                System.out.println(spot.toString());
            }
        }, 1000);


    }

    public static void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (Exception e) {
                System.err.println(e);
            }
        }).start();
    }
}

