package vending.payment;

public class PaymentProcessor {
    private Payment payment;

    public void addMoney(int amount){
        this.payment = new Payment(amount);
    }
    public double remainingAmount(double priceProduct){
        if(priceProduct>this.payment.getAmount()){
            return -1;
        }
        return this.payment.getAmount() - priceProduct;
    }
}
