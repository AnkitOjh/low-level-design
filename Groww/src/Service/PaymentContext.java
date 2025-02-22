package Service;

import Entity.Stock;
import Entity.User;

import java.util.HashMap;

public class PaymentContext {
    private IPaymentService iPaymentService;
    private HashMap<User,Integer> hashMap;

    public PaymentContext(){
        this.hashMap = new HashMap<>();
    }

    public void execute(IPaymentService iPaymentService, User user,int price){
        iPaymentService.pay();
        hashMap.put(user,price);
    }
}
