package vending.payment;

public class Payment {
    private int id;
    private int amount;
    public Payment(int amount){
        this.amount = amount;
    }
    public double getAmount(){
        return this.amount;
    }
}
