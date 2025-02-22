package Entity;

import Service.InsufficientFundException;
import Service.InsufficientStockException;

public class Stock {
    private String company;

    private int id;
    private int quantity;
    private int price;
    private String status;

    public Stock(String company,int quantity,int price,int id){
        this.price = price;
        this.company = company;
        this.quantity = quantity;
        this.id = id;
    }
    public int purchaseStock(int quantity){
        if(this.quantity>= quantity){
            this.quantity = this.quantity - quantity;
            System.out.println("Stock purchased");
            status = "Status pending";
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

    public String getCompany(){
        return this.company;
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

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public int getId(){
    return this.id;
    }
}
