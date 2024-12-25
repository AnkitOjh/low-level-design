package vending.state;

import vending.Inventory;
import vending.Product;
import vending.VendingMachine;
import vending.payment.PaymentProcessor;
import vending.state.VendingMachineState;

public class IdleState implements VendingMachineState {
    public VendingMachine machine;

    private PaymentProcessor paymentProcessor;
    public IdleState(VendingMachine machine){
        this.machine = machine;
        this.paymentProcessor = new PaymentProcessor();
    }
    @Override
    public void addMoney(double amount) {
        System.out.println("Money is added");
        machine.addTotalAmount(amount);
        machine.changeState(new ReadyState(machine));
    }

    @Override
    public void selectItem(Product product) {
        System.out.println("First do the payment");
    }

    @Override
    public void dispatchProduct(Inventory inventory,Product selectedItem ) {
        System.out.println("Money is not added do the payment first");
    }

    @Override
    public void cancelTransaction() {
    System.out.println("No payment to cancel");
    }
}
