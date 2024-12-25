package vending.state;

import vending.Inventory;
import vending.Product;
import vending.VendingMachine;

public class DispatchState implements VendingMachineState{

    private String itemId;
    private VendingMachine machine;
    DispatchState(VendingMachine machine){
        this.machine = machine;
    }
    @Override
    public void addMoney(double amount) {
        System.out.println("Money is added");
    }

    @Override
    public void selectItem(Product product) {
        System.out.println("Item has been selected");
    }

    @Override
    public void dispatchProduct(Inventory inventory,Product selectedItem) {
        System.out.println("Quantity"+inventory.getQuantity(selectedItem));
        if(inventory.getQuantity(selectedItem)>0){
            System.out.println("Order dispatched");
            inventory.updateQuantity(selectedItem,inventory.getQuantity(selectedItem)-1);
        }
        else{
            System.out.println("Item cannot be dispatched as it is not present in inventory");
        }
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Order is dispatched can't cancel");
    }
}
