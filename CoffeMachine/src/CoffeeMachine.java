import Entity.Ingredient;
import Enums.CoffeeType;
import States.CoffeeMachineState;
import States.IdealState;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class CoffeeMachine {
    private Inventory inventory;
    private static CoffeeMachine coffeeMachine;
    private CoffeeMachineState coffeeMachineState;
    private CoffeeMachine(){
        this.coffeeMachineState = new IdealState();
        this.inventory = new Inventory();
    }

    public void setState(CoffeeMachineState coffeeMachineState){
        this.coffeeMachineState = coffeeMachineState;
    }

    public static CoffeeMachine getInstance(){
        if(coffeeMachine == null){
            return new CoffeeMachine();
        }
        return coffeeMachine;
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    public void addCoffee(CoffeeType coffeeType, Map<Ingredient, Integer> receipe, BigDecimal price) {
        Coffee coffee = new Coffee(coffeeType,receipe,price);
        this.inventory.addCoffee(coffee);
    }

    public void addIngredient(String name, int quantity){
        Ingredient ingredient = new Ingredient(name, quantity);
        this.inventory.addIngredient(ingredient);
    }

    public Map<String, Integer> getMenu(){

    }

}
