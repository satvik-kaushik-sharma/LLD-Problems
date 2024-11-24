package Elevator.ControlStrategy;

import Elevator.Direction;
import Elevator.ElevatorVector;
import Elevator.Request;

import java.util.*;

public class LookControlStrategyWithRequestDirection extends ElevatorControlStrategy {
    List<Request> pendingRequests; // change to incl directions or do I?
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    // TODO may need new strategy for filling heaps
    int currIdx = 0;

    public LookControlStrategyWithRequestDirection() {
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
    public ElevatorVector getNextFloorAndDirection(Integer currFloor, Direction currDir) {
//        System.out.println("Lift Dir: " + currDir);
//        System.out.println("Max Heap (Down Dir Req being executed now): " + maxHeap);
//        System.out.println("Min Heap (Up Dir Req being executed now): " + minHeap);
//        System.out.println("Pending: " + pendingRequests);
        if (currDir.equals(Direction.IDLE)) {
            includePending(currFloor, currDir);
            ElevatorVector vector =  this.maxHeap.isEmpty() ? new ElevatorVector(this.minHeap.poll(), Direction.UP) : new ElevatorVector(this.maxHeap.poll(), Direction.DOWN);
            return vector;
        } else if (currDir.equals(Direction.UP)) {
            if (this.minHeap.isEmpty()) {  //now elevator will change its direction to DOWN
                includePending(currFloor, Direction.DOWN);
                return new ElevatorVector(this.maxHeap.poll(), Direction.DOWN);
            } else {
                return new ElevatorVector(this.minHeap.poll(), Direction.UP);
            }
        } else {
            if (this.maxHeap.isEmpty()) {  //now elevator will change its direction to UP
                includePending(currFloor, Direction.UP);
                return new ElevatorVector(this.minHeap.poll(), Direction.UP);
            } else {
                return new ElevatorVector(this.maxHeap.poll(), Direction.DOWN);
            }
        }
    }

    private void includePending(Integer currFloor, Direction currDir) {
        Iterator<Request> it = pendingRequests.iterator();
        while (it.hasNext()) {
            Request req = it.next();
            if (currDir.equals(Direction.IDLE)) {
                if (req.getDirection().equals(Direction.DOWN)) {
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
