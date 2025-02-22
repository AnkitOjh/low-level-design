package Entity;

public class Transaction {
    private int id;
    private String orderType;

    private int totalPrice;

    public Transaction(int id, String orderType, int totalPrice){
        this.id = id;
        this.orderType = orderType;
        this.totalPrice  = totalPrice;
    }

    public int getTotalPrice(){
        return this.totalPrice;
    }
}
