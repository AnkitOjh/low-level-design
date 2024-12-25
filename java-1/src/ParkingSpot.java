public class ParkingSpot {
    private int id;
    private final int spotNumber;

    private final VechileType vechileType;
    private ParkingTicket parkingTicket;
    private Vechile parkedVechile;
    private boolean isAvailable;

    ParkingSpot(int spotNumber,VechileType vechileType){
        this.spotNumber = spotNumber;
        this.vechileType = vechileType;
        this.isAvailable = true;
    }

    public synchronized int getSpotNumber(){
        return this.spotNumber;
    }

    public synchronized boolean checkAvailablity() {
        return this.isAvailable;
    }
    public synchronized void makeUnavailable() {
        if(parkingTicket != null){
            this.isAvailable = false;
        }
    }

    public synchronized void unPark(){
        this.isAvailable=true;
        this.parkingTicket = null;
        this.parkedVechile = null;
    }

    public synchronized void parkVechileAndAssignTicket(Vechile vechile,ParkingTicket parkingTicket){
        this.parkedVechile = vechile;
        this.parkingTicket = parkingTicket;
        this.isAvailable = false;
    }

    public VechileType getVechileType(){
        return this.vechileType;
    }

}
