package Elevator;

import Elevator.ControlStrategy.ElevatorControlStrategy;

public class ElevatorController {
    public Elevator elevator;
    public ElevatorControlStrategy controlStrategy;

    public ElevatorController(Elevator elevator, ElevatorControlStrategy controlStrategy) {
        this.elevator = elevator;
        this.controlStrategy = controlStrategy;
    }

    public void handleRequestCompleted() {
        fulfillNextRequest();
    }

    public void addNewRequest(Integer floor, Direction dir) {
        this.controlStrategy.addNewRequest(floor, dir, this.elevator.currentFloor, this.elevator.currentDirection);
        if (elevator.currentDirection.equals(Direction.IDLE)) {
            fulfillNextRequest();
        }
    }

    public void addNewRequest(Integer floor) {
        this.controlStrategy.addNewRequest(floor, this.elevator.currentFloor, this.elevator.currentDirection);
        if (elevator.currentDirection.equals(Direction.IDLE)) {
            fulfillNextRequest();
        }
    }

    private void fulfillNextRequest() {
//        ElevatorController (this) class will store currDirection of the elevator
//        but the Control Strategy may change the direction of the lift and that change decision should be made
//        by the strategy object only => should also send back
//        nextFloor should also send direction in which lift is proceeding now
//        why not just move currD into strategy too? - sounds good - double check
        ElevatorVector vector = this.controlStrategy.getNextFloorAndDirection(this.elevator.currentFloor, this.elevator.currentDirection);
        Integer nextFloor = vector.getFloor();
        Direction direction = vector.getDirection();
        this.elevator.setCurrentDirection(direction);
        if (nextFloor != null) {
            this.moveElevatorTo(nextFloor);
        } else {
            elevator.currentDirection = Direction.IDLE;
            System.out.println("No pending request for Elevator:" + elevator.elevatorId);
        }
    }

    private void moveElevatorTo(Integer floor) {
        Helper.setTimeout(() -> {
            System.out.println("Elevator " + this.getElevator().elevatorId + " moved to Floor " + floor + " Direction -> " + this.getElevator().currentDirection);
            this.getElevator().currentFloor = floor;
//            can we implement an observer pattern instead?
            this.handleRequestCompleted();
        }, 500);
    }

    public Elevator getElevator() {
        return elevator;
    }
}
