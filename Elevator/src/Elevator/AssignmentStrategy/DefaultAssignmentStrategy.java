package Elevator.AssignmentStrategy;

import Elevator.*;

import java.util.List;

public class DefaultAssignmentStrategy implements AssignmentStrategy {
    // Build a common repo called ElevatorRepo which would act as a DB for elevators
//    it will have map<elevatorId, elevatorDetails>
//    details like - current floor, current direction can be read/updated centrally from there
//    what if I want to have some special DS for optimally creating responses to queries like nearest elevator etc.?
//    like in Cache
//    then we will need special data structures like heap and maps to be stored in the runtime memory
//    we can periodically back up these data structure in a DB to re-fetch the current state in case the service crashes/restarts etc.
//    but generally in LLD problems, do not chase efficiency, only make the functionality work
//    do NOT store states(curr floor/dir) in DS (PQ, Set etc.),
//    just pass all eligible entities (elevators) to strategy and run min dist(or any other) logic in O(n)
    List<ElevatorController> elevatorControllers;

    public DefaultAssignmentStrategy(List<ElevatorController> elevatorControllers) {

        this.elevatorControllers = elevatorControllers;
    }

    @Override
    public ElevatorController assignElevator(Integer floor, Direction direction) {
        ElevatorController e = elevatorControllers.get(0);
        System.out.println("Elevator " + e.getElevator().elevatorId + " assigned to request at Floor " + floor + " " + direction);
        return e;
    }
}
