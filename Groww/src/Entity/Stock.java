package Entity;

public class Stock {
    private String company;
    private int quantity;
    private int price;

    public Stock(String company,int quantity,int price){
        this.price = price;
        this.company = company;
        this.quantity = quantity;
    }
    public boolean purchaseStock(int quantity){
        if(this.quantity>= quantity){
            this.quantity = this.quantity - quantity;
            System.out.println("Stock purchased");
            return true;
        }
        return false;
    }

    public boolean sellStock(int quantity){
            this.quantity+=quantity;
            System.out.println("Stock sold");
            return true;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price){
        this.price = price;
    }
}
