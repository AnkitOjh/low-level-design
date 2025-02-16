package Entity;

import java.util.ArrayList;
import java.util.List;

public class PortFolia {
    private List<Stock> stockList;
    private String userName;

    private List<Order> orders;

    public PortFolia(String userName){
        this.stockList = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.userName = userName;

    }

    public void addStock(Stock stock){
        stockList.add(stock);
    }

    public void setUser(String userName){
        this.userName = userName;
    }

    public String getUser(){
        return this.userName;
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }
}

