package entity;

import java.util.ArrayList;
import java.util.List;

public class Elevator extends Thread{
    private final int elevatorNumber;
    private String direction;
    private List<Floor> floorList;
    private int currentFloor;

    private List<Request> requestList;

    private final int capacity;
    public Elevator(int elevatorNumber, int capacity){
        this.elevatorNumber = elevatorNumber;
        this.floorList = new ArrayList<>();
        this.capacity = capacity;
        this.currentFloor = 1;
        this.requestList = new ArrayList<>();
    }

    public void setDirection(String direction){
        this.direction = direction;
    }

    public String getDirection(){
        return this.direction;
    }
    public int getElevatorNumber(){
        return this.elevatorNumber;
    }

    public int getCurrentFloor(){
        return this.currentFloor;
    }

    public void setCurrentFloor(int floor){
        this.currentFloor = floor;
    }

    public synchronized void addRequestList(Request request){
        requestList.add(request);
        System.out.println("Add request = "+request.getFloorNumber()+" "+Thread.currentThread());
        notifyAll();
    }

    public synchronized Request getNextRequest() throws InterruptedException {
        if(requestList.isEmpty()){
            try{
                System.out.println("Waiting for the request");
                wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        return requestList.remove(0);
    }

    public synchronized void processRequests() throws InterruptedException {
        while(true){
            if(!requestList.isEmpty()){
                Request request = getNextRequest();
                processRequest(request);
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void processRequest(Request request){
        currentFloor = request.getFloorNumber();
        int startFloor = currentFloor;
        int destinationFloor = request.getFloorNumber();
        if(startFloor > destinationFloor){
            direction = "UP";
            for(int i=destinationFloor;i<=startFloor;i++){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Elevator reached floor " + i);
                currentFloor = i;

            }
        } else{
            direction = "Down";
            for(int i=destinationFloor;i>=startFloor;i--){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Elevator reached floor " + currentFloor);
                currentFloor = i;
            }

        }

    }

    public void run(){
        System.out.println("adagdadgdy");
        try {
            processRequests();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
