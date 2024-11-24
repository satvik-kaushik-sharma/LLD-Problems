package Elevator;

import java.util.List;

public class InternalDispatcher {
    //    do we even need this?
//    save controller ref in Elevator object and call it's add function
//    just call add request function from elevator
    List<ElevatorController> controllers;

    public InternalDispatcher(List<ElevatorController> controllers) {
        this.controllers = controllers;
    }

    public InternalDispatcher() {
    }

    public List<ElevatorController> getControllers() {
        return controllers;
    }

    public void setControllers(List<ElevatorController> controllers) {
        this.controllers = controllers;
    }

    public void submitRequest(Integer elevatorId, Integer floor) {
        for (ElevatorController controller : controllers) {
            if (controller.elevator.elevatorId.equals(elevatorId)) {
                controller.addNewRequest(floor);
            }
        }
    }

    public void requestCompleted(Integer elevatorId, Integer floor) {
        for (ElevatorController controller : controllers) {
            if (controller.elevator.elevatorId.equals(elevatorId)) {
                controller.handleRequestCompleted();
            }
        }
    }
}
