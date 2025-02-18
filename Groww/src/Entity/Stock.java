package Entity;

import Service.InsufficientFundException;
import Service.InsufficientStockException;

public class Stock {
    private String company;
    private int quantity;
    private int price;

    public Stock(String company,int quantity,int price){
        this.price = price;
        this.company = company;
        this.quantity = quantity;
    }
    public int purchaseStock(int quantity){
        if(this.quantity>= quantity){
            this.quantity = this.quantity - quantity;
            System.out.println("Stock purchased");
            return quantity*this.price;
        }
        else{
            throw new InsufficientStockException("Insufficient stock");
        }
    }

    public int sellStock(int quantity){
            this.quantity+=quantity;
            System.out.println("Stock sold");
            if(quantity > 5000){
                throw new InsufficientStockException("Insuffiecient stock");
            }
            System.out.println("Total amount to be paid = "+ quantity*price);
            return quantity*price;
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
