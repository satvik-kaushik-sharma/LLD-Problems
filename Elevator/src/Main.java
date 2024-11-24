import Elevator.*;
import Elevator.AssignmentStrategy.DefaultAssignmentStrategy;
import Elevator.ControlStrategy.ScanControlStrategyWithRequestDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        InternalDispatcher internalDispatcher = new InternalDispatcher();
        Elevator e1 = new Elevator(1, 5, internalDispatcher);
        Elevator e2 = new Elevator(2, 3, internalDispatcher);
        ElevatorController elevatorController1 = new ElevatorController(e1, new ScanControlStrategyWithRequestDirection());
        ElevatorController elevatorController2 = new ElevatorController(e2, new ScanControlStrategyWithRequestDirection());
        List<ElevatorController> controllerList = new ArrayList<ElevatorController>();
        controllerList.add(elevatorController1);
        controllerList.add(elevatorController2);
        internalDispatcher.setControllers(controllerList);
        ExternalDispatcher externalDispatcher = new ExternalDispatcher(new DefaultAssignmentStrategy(controllerList));

        // externalDispatcher is missing the direction user wants to go in
//        externalDispatcher.handleNewRequest(4, null);
//        externalDispatcher.handleNewRequest(8, null);
//        e1.addNewInternalRequest(2);
//        externalDispatcher.handleNewRequest(3, null);
//        externalDispatcher.handleNewRequest(7, null);
//
//        externalDispatcher.handleNewRequest(9, null);
//        externalDispatcher.handleNewRequest(1, null);
//        externalDispatcher.handleNewRequest(6, null);
        externalDispatcher.submitRequest(4, Direction.UP);
        externalDispatcher.submitRequest(8, Direction.DOWN);
        externalDispatcher.submitRequest(3, Direction.UP);
//        externalDispatcher.handleNewRequest(5, Direction.DOWN); TODO ???
        externalDispatcher.submitRequest(7, Direction.UP);

        externalDispatcher.submitRequest(9, Direction.UP);
        externalDispatcher.submitRequest(1, Direction.DOWN);
        externalDispatcher.submitRequest(6, Direction.DOWN);
        Timer t = new Timer();
        t.schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        // your code here
                        externalDispatcher.submitRequest(5, Direction.UP);
                        t.cancel();
                    }
                },
                7000
        );

//        Helper.setTimeout(() -> {
//        }, 7000);
    }
}