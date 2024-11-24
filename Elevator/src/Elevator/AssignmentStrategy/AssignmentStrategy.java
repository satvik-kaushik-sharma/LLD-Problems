package Elevator.AssignmentStrategy;

import Elevator.*;

public interface AssignmentStrategy {
    public ElevatorController assignElevator(Integer floor, Direction d);
}
