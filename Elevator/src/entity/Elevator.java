package entity;

public class Elevator {
    private final int elevatorNumber;
    private String direction;
    Elevator(int elevatorNumber){
        this.elevatorNumber = elevatorNumber;
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
}
