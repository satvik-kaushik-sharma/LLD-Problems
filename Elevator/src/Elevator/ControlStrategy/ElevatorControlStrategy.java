package Elevator.ControlStrategy;

import Elevator.Direction;

public abstract class ElevatorControlStrategy {

    public void addNewRequest(Integer floor, Direction reqDir, Integer currFloor, Direction currDir) {
    }

    ;

    public void addNewRequest(Integer floor, Integer currFloor, Direction currDir) {
    }

    ;

    public abstract Integer nextFloor(Integer currFloor, Direction currDir);

}
