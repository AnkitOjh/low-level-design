package Payment;

public class CreditCard implements IPayment{
    @Override
    public void pay() {
        System.out.println("Paid by credit card");
    }
}
