package States;

import Enums.CoffeeType;

import java.math.BigDecimal;

public class DespenseState implements CoffeeMachineState{

    private BigDecimal changeAmount;
    public DespenseState(BigDecimal amount){
        this.changeAmount = amount;
    }
    @Override
    public void selectCoffeeType(CoffeeType coffeeType) {
        System.out.println("Cofee can't be selected");
    }

    @Override
    public void addMoney(int amount) {
        System.out.println("Money has been added");
    }

    @Override
    public void despenseCoffee() {
        System.out.println("Collect your change"+this.changeAmount);
    }
}
