package Service;

public class PaymentContext {
    private IPaymentService iPaymentService;

    public void execute(IPaymentService iPaymentService){
        iPaymentService.pay();
    }
}
