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






    }
}
