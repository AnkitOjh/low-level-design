package Service;

import Entity.*;
import OrderStatus.OrderStaus;

import java.util.HashMap;

public class OrderManagement {
    HashMap<String, Transaction> userTransactionHashMap;
    NiftyStock niftyStock;

    PaymentContext paymentContext;
    public OrderManagement(){
        this.userTransactionHashMap = new HashMap<>();
        niftyStock = new NiftyStock();
        paymentContext = new PaymentContext();
    }

    public synchronized int checkPrice(String companyName,int quantity){
        if(niftyStock.getHashMap().containsKey(companyName)){
            if(niftyStock.getHashMap().get(companyName).getQuantity() < quantity){
                throw new InsufficientStockException(companyName + "not enough stocks ");
            }
            else{
                return niftyStock.getHashMap().get(companyName).getPrice()*quantity;
            }
        }
        else{
            throw new RuntimeException("Compnay Not listed");
        }

    }

    public NiftyStock getNiftyStock(){
        return niftyStock;
    }
    public synchronized Order buyOrder(User user,int totalPrice,int quantity,String companyName){
        if(niftyStock.getHashMap().containsKey(companyName)){
            Stock stock = niftyStock.getHashMap().get(companyName);

            if(stock.getQuantity() < quantity){
                throw new InsufficientFundException("Not enpugh mobey to buy stock");
            }
            else{
                Order order = new BuyOrder(3,niftyStock.getHashMap().get(companyName),user);
                order.setOrderStaus(OrderStaus.PENDING);
                System.out.println("Order placed waiting for payment");
                return order;
            }


        }else{
            throw new RuntimeException("Compnay Not listed");
        }

    }

    public synchronized void payPrice(int price,String paymentType,User user,String companyName, int quantity,Order order){

        if(paymentType.equalsIgnoreCase("DEBIT")){
            System.out.println("Payment Successfull");
            paymentContext.execute(new DebitCard(),user,price);
            Stock stock = new Stock(companyName,quantity,niftyStock.getHashMap().get(companyName).getPrice(),1);
            executeOrder(quantity,user,stock,niftyStock.getHashMap().get(companyName),order);
        }
    }

    private synchronized void executeOrder(int quantity,User user,Stock stock,Stock parentStock,Order order){
        user.getPortFolia().addStock(stock);
        System.out.println("Order executed successfully");
        parentStock.setQuantity(parentStock.getQuantity()-stock.getQuantity());
        order.setOrderStaus(OrderStaus.PAID);
        userTransactionHashMap.put(user.getUserName(),new Transaction(1,"buy",quantity*stock.getPrice()));
    }

    public void printPortfolio(User user){
        user.getPortFolia().getStockList().stream().forEach(stock -> {
            System.out.println("Company = "+ stock.getCompany()+"toal share =  "+ stock.getQuantity());
        });
    }

    public synchronized void sellStock(int quantity,String company,User user){
        user.getPortFolia().getStockList().forEach(stock -> {
            if(stock.getCompany().equalsIgnoreCase(company)){
                if(stock.getQuantity()>quantity){
                    stock.setQuantity(stock.getQuantity()-quantity);
                    System.out.println("Refunded money "+ quantity*stock.getPrice());
                } else if(stock.getQuantity() == quantity){
                    user.getPortFolia().getStockList().remove(stock);
                    System.out.println("Sold stock "+ quantity*stock.getPrice());
                } else{
                    throw new InsufficientStockException("Not enough stock to sell");
                }
                niftyStock.getHashMap().get(company).setQuantity(niftyStock.getHashMap().get(company).getQuantity()+quantity);
            }
        });

    }

    public synchronized void addToPortfolio(User user, Stock stock,int quantity,Order order){
        if(stock.purchaseStock(quantity)>0){
            user.getPortFolia().addStock(stock);
            user.getTransactionList().add(new Transaction(1,"Buy",123));
        }
    }


}
