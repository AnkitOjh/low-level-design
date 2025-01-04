package States;

import Enums.CoffeeType;
import Services.CoffeeMachine;
import Services.Inventory;

import java.math.BigDecimal;

public class ReadyState implements CoffeeMachineState{

    private int amount;
    private CoffeeMachine coffeeMachine;
    public ReadyState(int amount, CoffeeMachine coffeeMachine){
        this.amount =amount;
        this.coffeeMachine = coffeeMachine;
    }
    @Override
    public void selectCoffeeType(CoffeeType coffeeType) {

        Inventory inventory = coffeeMachine.getInventory();
        if(coffeeMachine.getMenu().get(coffeeType.toString()).compareTo(new BigDecimal(this.amount)) < 0){
            System.out.println("Coffee selected successfully");
            inventory.removeIngredient(coffeeType);
            coffeeMachine.setState(new DespenseState(new BigDecimal(this.amount).subtract(
                    coffeeMachine.getMenu().get(coffeeType.toString())
            )));
        }
        else{
            System.out.println("Low balance for coffee");
        }
    }

    @Override
    public void addMoney(int amount) {
        System.out.println("Money is already added");
    }

    @Override
    public void despenseCoffee() {
        System.out.println("Coffee cannot be dispensed as coffee is not selected");
    }
}
