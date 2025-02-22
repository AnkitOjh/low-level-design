package Entity;

import OrderStatus.OrderStaus;

public interface Order {
    public int executeOrder();

    public void setOrderStaus(OrderStaus orderStaus);
}
