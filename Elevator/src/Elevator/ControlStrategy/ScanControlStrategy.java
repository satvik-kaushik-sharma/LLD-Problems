//package Elevator.ControlStrategy;
//
//import Elevator.Direction;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.PriorityQueue;
//
//// without request direction
//public class ScanControlStrategy extends ElevatorControlStrategy {
//    List<Integer> pendingRequests;
//    PriorityQueue<Integer> minHeap;
//    PriorityQueue<Integer> maxHeap;
//
//    int currIdx = 0;
//
//    public ScanControlStrategy() {
//        this.pendingRequests = new ArrayList<>();
//        this.maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
//        this.minHeap = new PriorityQueue<Integer>();
//    }
//
//    public void addNewRequest(Integer reqFloor, Integer currFloor, Direction currDir) {
//        if (currDir.equals(Direction.IDLE)) {
//            pendingRequests.add(reqFloor);
//        } else if (currDir.equals(Direction.UP)) {
//            if (currFloor >= reqFloor) {
//                this.pendingRequests.add(reqFloor); // is it needed? can't just push in max heap - for it to pick when dir is changed
//            } else {
//                this.minHeap.add(reqFloor);
//            }
//        } else {
//            if (currFloor <= reqFloor) {
//                this.pendingRequests.add(reqFloor);
//            } else {
//                this.maxHeap.add(reqFloor);
//            }
//        }
//    }
//
//    @Override
//    public Integer getNextFloorAndDirection(Integer currFloor, Direction currDir) {
//        if (currDir.equals(Direction.IDLE)) {
//            includePending(currFloor);
//            return this.maxHeap.isEmpty() ? this.minHeap.poll() : this.maxHeap.poll();
//        } else if (currDir.equals(Direction.UP)) {
//            if (this.minHeap.isEmpty()) {  //now elevator will change its direction
//                includePending(currFloor);
//                return this.maxHeap.poll();
//            } else {
//                return this.minHeap.poll();
//            }
//        } else {
//            if (this.maxHeap.isEmpty()) {  //now elevator will change its direction
//                includePending(currFloor);
//                return this.minHeap.poll();
//            } else {
//                return this.maxHeap.poll();
//            }
//        }
//    }
//
//    private void includePending(Integer currFloor) {
//        for (Integer i : pendingRequests) {
//            if (i > currFloor) {
//                this.minHeap.add(i);
//            } else {
//                this.maxHeap.add(i);
//            }
//        }
//        pendingRequests.clear();
//    }
//
//}
