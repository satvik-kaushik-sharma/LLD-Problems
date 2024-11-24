package Elevator;

public class Request {
    Integer floor;
    Direction direction;

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Request(Integer floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Request{" +
                "floor=" + floor +
                ", direction=" + direction +
                '}';
    }
}
