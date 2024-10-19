package SpotMangaer;

import Location.Location;
import ParkingSpot.Spot;
import ParkingSpot.TwoWheelerSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingData {
//    should be a repo with a map
//    VehicleType -> Spot List
    public static List<Spot> TwoWheelerData = new ArrayList<>(List.of(
            new TwoWheelerSpot(new Location(1, 0), null),
            new TwoWheelerSpot(new Location(0, 1), null),
            new TwoWheelerSpot(new Location(1, 1), null),
            new TwoWheelerSpot(new Location(2, 0), null),
            new TwoWheelerSpot(new Location(0, 2), null),
            new TwoWheelerSpot(new Location(2, 1), null)
    ));

}
