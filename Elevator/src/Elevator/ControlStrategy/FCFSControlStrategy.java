//package Elevator.ControlStrategy;
//
//import Elevator.Direction;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class FCFSControlStrategy extends ElevatorControlStrategy {
//    List<Integer> pendingRequests; // change to queue
//    int currIdx = 0;
//
//    public FCFSControlStrategy() {
//        this.pendingRequests = new ArrayList<>();
//    }
//
//
//    public void addNewRequest(Integer floor, Integer currFloor, Direction currDir) {
//        pendingRequests.add(floor);
//    }
//
//    @Override
//    public Integer getNextFloorAndDirection(Integer currFloor, Direction currDir) {
//        return pendingRequests.get(currIdx++);
//    }
//
//}
