import Entity.*;
import Service.CreditCard;
import Service.NiftyStock;
import Service.OrderManagement;
import Service.PaymentContext;

public class Main {
    public static void main(String[] args) {

        //We can update the prices of stock through observer desimgn pattern.
        OrderManagement orderManagement = new OrderManagement();
        NiftyStock niftyStock = orderManagement.getNiftyStock();
        niftyStock.printAllStocks();
        IStockUpdate iStockUpdate = new IStockUpdateImpl(niftyStock);
        iStockUpdate.update("tata",101);
        niftyStock.printAllStocks();
        String companyName = "tata";
        int quantity = 4;
        int price = orderManagement.checkPrice("tata",4);
        System.out.println("Price ="+price);
        User user = new User("Ankit");
        Order order = orderManagement.buyOrder(user,price,quantity,companyName);
        orderManagement.payPrice(price,"DEBIT",user,companyName,quantity,order);
        orderManagement.printPortfolio(user);







    }
}
