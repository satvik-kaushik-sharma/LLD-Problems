package Elevator;

public class ElevatorVector {
    Integer floor;
    Direction direction;

    public ElevatorVector(Integer floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public Integer getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }
}
