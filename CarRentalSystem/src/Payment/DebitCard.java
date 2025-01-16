package Payment;

public class DebitCard implements IPayment{
    @Override
    public void pay() {
        System.out.println("Paid by debit card");
    }
}
