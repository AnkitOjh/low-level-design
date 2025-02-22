package Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderExecutor {

    private Order order;

    HashMap<User, List<Order>> hashMap;

    private OrderExecutor(Order order){
        this.order = order;
        this.hashMap = new HashMap<>();
    }

    public synchronized int executeOrder(Order order,User user){

        if(hashMap.containsKey(user)){
            hashMap.get(user).add(order);
        }
        else{
            hashMap.put(user, new ArrayList<>());
        }
        return order.executeOrder();
    }
}
