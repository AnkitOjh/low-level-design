package vending;

public class Product {
    private String itemId;
    private String itemName;

    private double price;

    public double getPrice(){
        return price;
    }
    public void setPrice(double amount){
        this.price = amount;
    }
    public void setItemName(String name){
        this.itemName = name;
    }
}
