package service;

import entity.Elevator;
import entity.Floor;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem{
    List<Elevator> elevatorList;
    public ElevatorSystem(int number, int capacity){
        this.elevatorList = new ArrayList<>();
        for(int i=0;i<number;i++){
            Elevator elevator = new Elevator(i+1,10);
            elevatorList.add(elevator);
//            new Thread(elevator::run).start();
        }
    }

    public void move(Floor floor, int destination){
        Elevator elevator = getOptimalElevator(floor.getFloor());
        if(elevator != null){
            elevator.setCurrentFloor(destination);
        }
        else{
            throw new RuntimeException("No elevator present");
        }
    }
    private Elevator getOptimalElevator(int destination){
        int minDistance = 9999;
        for(Elevator elevator : elevatorList){
            if(Math.abs(elevator.getCurrentFloor() - destination) < minDistance){
                minDistance = Math.abs(elevator.getCurrentFloor() - destination);

                return elevator;
            }
        }
        return null;
    }

}
