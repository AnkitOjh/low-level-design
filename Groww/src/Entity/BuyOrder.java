package Entity;

import OrderStatus.OrderStaus;

public class BuyOrder implements Order{
    private int quantity;
    private Stock stock;
    private User user;

    private OrderStaus orderStaus;
    public BuyOrder(int quantity, Stock stock,User user){
        this.quantity = quantity;
        this.stock = stock;
        this.user = user;
    }
    @Override
    public int executeOrder() {
        return stock.purchaseStock(quantity);
    }
}
