package SpotMangaer;

import Location.Location;
import ParkingSpot.*;

import java.util.ArrayList;
import java.util.List;

public class TwoWheelerSpotManger extends SpotManger {

    public TwoWheelerSpotManger(SpotAssignmentStrategy assignmentStrategy) {
        super(assignmentStrategy == null ? new SpotAssignmentStrategy() : assignmentStrategy);
        this.spots = ParkingData.TwoWheelerData;
    }

}
