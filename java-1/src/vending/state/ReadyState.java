package vending.state;

import vending.Inventory;
import vending.Product;
import vending.VendingMachine;

public class ReadyState implements VendingMachineState{
    private VendingMachine machine;
    private VendingMachineState dispatchState;
    private VendingMachineState idealState;

    public ReadyState(VendingMachine machine){
        this.machine = machine;
        this.dispatchState = new DispatchState(machine);
        this.idealState = new IdleState(machine);
    }
    @Override
    public void addMoney(double amount) {
        System.out.println("Money is added");
    }

    @Override
    public void selectItem(Product product) {
        if(this.machine.inventory.isAvailable(product)){
            this.machine.setSelectedProduct(product);
            machine.changeState(this.dispatchState);
        }
        else{
            System.out.println("Product not available");
        }

    }

    @Override
    public void dispatchProduct(Inventory inventory,Product selectedItem) {
        System.out.println("Order can't be dispatched");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Transaction is cancelled");
        machine.changeState(this.idealState);
    }
}
