package States;

import Enums.CoffeeType;

public interface CoffeeMachineState {
    public void selectCoffeeType(CoffeeType coffeeType);
    public void addMoney(int amount);
    public void despenseCoffee();
}
