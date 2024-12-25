import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private int id;
    private List<ParkingLevel> parkingLevelList;
    private int level;

    ParkingLot() {
        this.parkingLevelList = new ArrayList<>();
//        this.level = level;
    }

    public void addLevel(ParkingLevel parkingLevel) {
        parkingLevelList.add(parkingLevel);
    }

    public boolean parkVechile(Vechile vechile, ParkingTicket parkingTicket) {
        for (ParkingLevel parkingLevel : parkingLevelList) {
            if (parkingLevel.parkVechile(vechile, parkingTicket)) {
                System.out.println("Vechile parked");
                return true;
            }
        }
        System.out.println("No space empty");
        return false;
    }

    public List<String> listOfAvailableSpot(){
        List<String> listOfLevelWithParking = new ArrayList<>();
        for(ParkingLevel parkingLevel: parkingLevelList){
            for(ParkingSpot parkingSpot : parkingLevel.listOfAvailableSpot()){
                listOfLevelWithParking.add("level "+parkingLevel.getLevel()+" "+"parking spot "+parkingSpot.getSpotNumber());
            }
        }
        return listOfLevelWithParking;
    }

    public void unParkVechile(int level, int spotNumber){
        for(ParkingLevel parkingLevel: parkingLevelList){
            if(parkingLevel.getLevel() == level){
                parkingLevel.unParkVechile(spotNumber);
            }
        }
    }
}
