package vending.state;

import vending.Inventory;
import vending.Product;

public interface VendingMachineState {
    void addMoney(double amount);
    void selectItem(Product product);

    void dispatchProduct(Inventory inventory, Product selectedItem);
    void cancelTransaction();

}
