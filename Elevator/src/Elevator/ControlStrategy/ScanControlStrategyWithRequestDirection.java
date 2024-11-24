package Elevator.ControlStrategy;

import Elevator.Direction;
import Elevator.Request;

import java.util.*;

public class ScanControlStrategyWithRequestDirection extends ElevatorControlStrategy {
    List<Request> pendingRequests; // change to incl directions or do I?
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    // TODO may need new strategy for filling heaps
    int currIdx = 0;

    public ScanControlStrategyWithRequestDirection() {
        this.pendingRequests = new ArrayList<>();
        this.maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<Integer>();
    }

    public void addNewRequest(Integer reqFloor, Direction reqDir, Integer currFloor, Direction currDir) {
        if (currDir.equals(Direction.IDLE)) {
            pendingRequests.add(new Request(reqFloor, reqDir));
        } else if (currDir.equals(Direction.UP)) {
            if (currFloor >= reqFloor || reqDir.equals(Direction.DOWN)) {
                this.pendingRequests.add(new Request(reqFloor, reqDir));
            } else { // currF < f && reqD = UP
                this.minHeap.add(reqFloor);
            }
        } else {
            if (currFloor <= reqFloor || reqDir.equals(Direction.UP)) {
                this.pendingRequests.add(new Request(reqFloor, reqDir));
            } else { // currF > f && reqD = Down
                this.maxHeap.add(reqFloor);
            }
        }
    }

    @Override
    public Integer nextFloor(Integer currFloor, Direction currDir) {
//        System.out.println("Lift Dir: " + currDir);
//        System.out.println("Max Heap (Down Dir Req being executed now): " + maxHeap);
//        System.out.println("Min Heap (Up Dir Req being executed now): " + minHeap);
//        System.out.println("Pending: " + pendingRequests);
        if (currDir.equals(Direction.IDLE)) {
            includePending(currFloor, currDir);
            return this.maxHeap.isEmpty() ? this.minHeap.poll() : this.maxHeap.poll();
        } else if (currDir.equals(Direction.UP)) {
            if (this.minHeap.isEmpty()) {  //now elevator will change its direction
                includePending(currFloor, Direction.DOWN);
                return this.maxHeap.poll();
            } else {
                return this.minHeap.poll();
            }
        } else {
            if (this.maxHeap.isEmpty()) {  //now elevator will change its direction
                includePending(currFloor, Direction.UP);
                return this.minHeap.poll();
            } else {
                return this.maxHeap.poll();
            }
        }
    }

    private void includePending(Integer currFloor, Direction currDir) {
        Iterator<Request> it = pendingRequests.iterator();
        while (it.hasNext()) {
            Request req = it.next();
            if (currDir.equals(Direction.IDLE)) {
                if (req.getFloor() > currFloor) {
                    this.maxHeap.add(req.getFloor());
                } else {
                    this.minHeap.add(req.getFloor());
                }
                it.remove();
            } else if (req.getDirection().equals(currDir)) {
                if (req.getDirection().equals(Direction.UP) && req.getFloor() > currFloor) {
                    this.minHeap.add(req.getFloor());
                    it.remove();
                } else if (req.getDirection().equals(Direction.DOWN) && req.getFloor() < currFloor) {
                    this.maxHeap.add(req.getFloor());
                    it.remove();
                }
            }
        }
    }


}
