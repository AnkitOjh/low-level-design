package Entity;

import OrderStatus.OrderStaus;

public class SellOrder implements Order{

    private int quantity;
    private Stock stock;

    private OrderStaus orderStaus;

    public SellOrder(int quantity, Stock stock){
        this.quantity = quantity;
        this.stock = stock;
    }
    @Override
    public int executeOrder() {
        return stock.sellStock(quantity);
    }
}
