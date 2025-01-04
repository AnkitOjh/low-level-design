package States;

import Enums.CoffeeType;
import Services.CoffeeMachine;

import java.math.BigDecimal;

public class IdealState implements CoffeeMachineState{
    private CoffeeMachine coffeeMachine;

    private ReadyState readyState;

    public IdealState(CoffeeMachine coffeeMachine){
        this.coffeeMachine = coffeeMachine;
    }
    @Override
    public void selectCoffeeType(CoffeeType coffeeType) {
        System.out.println("Pay money first");
    }

    @Override
    public void addMoney(int amount) {
        coffeeMachine.addAmount(amount);
        this.readyState = new ReadyState(amount,this.coffeeMachine);
        coffeeMachine.setState(readyState);
    }

    @Override
    public void despenseCoffee() {
        System.out.println("Item cannot be dispensed");
    }
}
