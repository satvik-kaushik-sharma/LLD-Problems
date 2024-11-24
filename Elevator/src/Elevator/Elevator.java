package Elevator;

public class Elevator {
    public Integer elevatorId;
    public Integer currentFloor;
    public Direction currentDirection;
    public InternalDispatcher internalDispatcher;


    public Elevator(Integer elevatorId, Integer currentFloor, InternalDispatcher internalDispatcher) {
        this.elevatorId = elevatorId;
        this.currentFloor = currentFloor;
        this.currentDirection = Direction.IDLE;
        this.internalDispatcher = internalDispatcher;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void updateDirection(Integer floor) {
//        remove this logic
        if (this.currentFloor > floor) {
            this.currentDirection = Direction.DOWN;
        } else {
            this.currentDirection = Direction.UP;
        }
//        moved to controller

//        Helper.setTimeout(() -> {
//            System.out.println("Elevator " + elevatorId + " moved to Floor " + floor + " Direction -> " + this.currentDirection);
//            this.currentFloor = floor;
////            can we implement an observer pattern instead?
//            this.internalDispatcher.requestCompleted(elevatorId, floor);
//        }, 500);
    }

    public void addNewInternalRequest(Integer floor) {
        System.out.println("Elevator " + elevatorId + " internal request for Floor " + floor);
        internalDispatcher.submitRequest(elevatorId, floor);
    }
}
