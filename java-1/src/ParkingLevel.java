import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLevel {
    private int level;
    private List<ParkingSpot> parkingSpotList;

    ParkingLevel(int level, int spots) {
        this.level = level;
        parkingSpotList = new ArrayList<>();
        int bikeSpot = (int) spots/3;
        int carSpot = (int) spots/3;
        for(int i=1;i<=bikeSpot;i++){
            parkingSpotList.add(new ParkingSpot(i,VechileType.BIKE));
        }
        for(int i=bikeSpot+1;i<=carSpot;i++){
            parkingSpotList.add(new ParkingSpot(i,VechileType.CAR));
        }
        for(int i=carSpot+1;i<=spots-carSpot-bikeSpot;i++){
            parkingSpotList.add(new ParkingSpot(i,VechileType.TRUCK));
        }
    }

    public boolean parkVechile(Vechile vechile,ParkingTicket ticket){
        return parkingSpotList.stream().filter(spot -> spot.checkAvailablity() && spot.getVechileType().equals(vechile.getVechileType()))
                .findFirst()
                .map(spot -> {
                    System.out.println("Vechile has reached the spot");
                    spot.parkVechileAndAssignTicket(vechile,ticket);
                    return true;
                })
                .orElse(false);
    }

    public List<ParkingSpot> listOfAvailableSpot(){
        return parkingSpotList.stream().filter(ParkingSpot::checkAvailablity).collect(Collectors.toList());
    }

    public void unParkVechile(int spotNumber){
        for(ParkingSpot parkingSpot : parkingSpotList){
            if(parkingSpot.getSpotNumber() == spotNumber){
                parkingSpot.unPark();
                System.out.println("Vechile has been un parked");
            }
        }
    }

    public int getLevel(){
        return this.level;
    }

}
