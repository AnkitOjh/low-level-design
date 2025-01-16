package Payment;

public class PaymentContext {
    private IPayment iPayment;
    PaymentContext(IPayment iPayment){
        this.iPayment = iPayment;
    }
    public void execute(){
        System.out.println("Payment done ");
        this.iPayment.pay();
    }
}
