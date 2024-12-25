import vending.Product;
import vending.VendingMachine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Sadad");
//        ParkingLot parkingLot = new ParkingLot();
//
//        ParkingLevel parkingLevel = new ParkingLevel(1,10);
//        parkingLot.addLevel(parkingLevel);
//        ParkingLevel parkingLevel1 = new ParkingLevel(2,10);
//        parkingLot.addLevel(parkingLevel1);
//        Vechile vechile = new Vechile();
//        vechile.setVechileType(VechileType.BIKE);
//        ParkingTicket parkingTicket = new ParkingTicket();
//        parkingLot.parkVechile(vechile,parkingTicket);
//        List<String> newAvailableSpots = parkingLot.listOfAvailableSpot();
//        for(String spot: newAvailableSpots){
//            System.out.println(spot);
//        }
//        System.out.println("Spot available after un parking");
//        parkingLot.unParkVechile(1,1);
//        List<String> newAvailableSpotsAfterUnparking = parkingLot.listOfAvailableSpot();
//        for(String spot: newAvailableSpotsAfterUnparking){
//            System.out.println(spot);
//        }

        //
        VendingMachine vendingMachine  =new VendingMachine();
        Product product  =new Product();
        product.setPrice(10);
        product.setItemName("Kurkure");
        Product product1  =new Product();
        product1.setPrice(20);
        product1.setItemName("Lays");
        vendingMachine.addProduct(product,9);
        vendingMachine.addProduct(product1,10);
        vendingMachine.selectItem(product);
        vendingMachine.addMoney(51);
        vendingMachine.dispatch();
        vendingMachine.selectItem(product);
        vendingMachine.dispatch();




    }
}