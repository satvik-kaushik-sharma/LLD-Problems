package Elevator;

import Elevator.AssignmentStrategy.AssignmentStrategy;

import java.util.List;

public class ExternalDispatcher {
    AssignmentStrategy elevatorAssignmentStrategy;

    public ExternalDispatcher(AssignmentStrategy elevatorAssignmentStrategy) {
        this.elevatorAssignmentStrategy = elevatorAssignmentStrategy;
    }

    public void submitRequest(Integer floor, Direction d) {
        ElevatorController elevatorController = this.elevatorAssignmentStrategy.assignElevator(floor, d);
        elevatorController.addNewRequest(floor, d);

    }
}
