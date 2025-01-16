package Payment;

public class UpiPayment implements IPayment{
    @Override
    public void pay() {
        System.out.println("Paid by upi card");
    }
}
