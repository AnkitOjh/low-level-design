package States;

public class IdealState implements CoffeeMachineState{
    private CoffeeMachineState coffeeMachineState;


    @Override
    public void selectCoffeeType() {

    }

    @Override
    public void addMoney() {
        System.out.println("Please select the coffee from the menu first");
    }

    @Override
    public void despenseCoffee() {
        System.out.println("Item cannot be dispensed");
    }
}
