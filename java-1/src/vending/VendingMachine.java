package vending;

import vending.payment.PaymentProcessor;
import vending.state.IdleState;
import vending.state.VendingMachineState;

public class VendingMachine {
    private VendingMachineState currentState;
    private PaymentProcessor paymentProcessor;
    public Inventory inventory;

    public double totalAmount;

    public Product selectedProduct;
    public VendingMachine(){
        this.currentState = new IdleState(this);
        this.paymentProcessor = new PaymentProcessor();
        this.inventory = new Inventory();
        this.totalAmount = 0.0;
        this.selectedProduct = null;
    }
    public void changeState(VendingMachineState currentState){
        this.currentState = currentState;
    }
    public void addMoney(int amount){
        this.currentState.addMoney(amount);
    }

    public void addTotalAmount(double amount){
        totalAmount+=amount;
    }

    public void selectItem(Product product){
        this.currentState.selectItem(product);
    }

    public void setSelectedProduct(Product product){
        if(this.totalAmount >= product.getPrice() ){
            this.selectedProduct = product;
            System.out.println("Product is selected");
        }
        else{
            System.out.println("Not enough amount to select this product");
        }

    }

    public void dispatch(){
        System.out.println("Quantity"+inventory.getQuantity(this.selectedProduct));
        this.currentState.dispatchProduct(this.inventory,this.selectedProduct);
//        System.out.println("Here is ur change "+ (this.totalAmount - this.selectedProduct.getPrice()));
    }

    public void addProduct(Product product, int quantity){
        this.inventory.addProduct(product,quantity);
        System.out.println("Quantity = "+inventory.getQuantity(product));
    }
    public void removeProduct(Product product, int quantity){
        this.inventory.removeProduct(product);
    }

    public void checkProduct(Product product){
        this.inventory.isAvailable(product);
    }

    public int getQuantity(Product product){
        return this.inventory.getQuantity(product);
    }
}
