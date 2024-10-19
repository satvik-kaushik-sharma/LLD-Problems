package SpotMangaer;

import ParkingSpot.SpotAssignmentStrategy;
import Vehicle.VehicleType;

public class SpotMangerFactory {

//    strategy can be null to use default one
    public SpotManger getSpotManagerByVehicleType(VehicleType type, SpotAssignmentStrategy strategy) {
        switch (type) {
            case TwoWheeler:
                return new TwoWheelerSpotManger(strategy);
            default:
                return null;
        }
    }

}
