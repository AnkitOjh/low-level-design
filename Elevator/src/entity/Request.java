package entity;

public class Request {
    private int floorNumber;

    public Request(int floorNumber){
        this.floorNumber = floorNumber;
    }
    public int getFloorNumber(){
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber){
        this.floorNumber = floorNumber;
    }
}
