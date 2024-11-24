package Elevator.ControlStrategy;

import Elevator.Direction;
import Elevator.ElevatorVector;

public abstract class ElevatorControlStrategy {

    public void addNewRequest(Integer floor, Direction reqDir, Integer currFloor, Direction currDir) {
    }

    ;

    public void addNewRequest(Integer floor, Integer currFloor, Direction currDir) {
    }

    ;

    public abstract ElevatorVector getNextFloorAndDirection(Integer currFloor, Direction currDir);

}
