package ParkingSpot;

public interface ParkingSpotManager<T extends ParkingSpot> {

    public T assignSpot();

    public void releaseSpot(T spot);

}
