package Service;

public class CreditCard implements IPaymentService{
    @Override
    public void pay() {
        System.out.println("Payment by Credit Card");
    }
}
