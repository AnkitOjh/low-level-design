package Service;

public class DebitCard implements IPaymentService{
    @Override
    public void pay() {
        System.out.println("Paid with debit card");
    }
}
