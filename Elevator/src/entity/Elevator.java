package entity;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private final int elevatorNumber;
    private String direction;
    private List<Floor> floorList;
    private int currentFloor;

    private final int capacity;
    public Elevator(int elevatorNumber, int capacity){
        this.elevatorNumber = elevatorNumber;
        this.floorList = new ArrayList<>();
        this.capacity = capacity;
        this.currentFloor = 0;
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

    public void addRequest(Floor floor){
        this.floorList.add(floor);
    }
}
