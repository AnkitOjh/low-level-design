package Services;

import Entity.Ingredient;
import Enums.CoffeeType;
import States.CoffeeMachineState;
import States.IdealState;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeMachine {
    private Inventory inventory;
    private static CoffeeMachine coffeeMachine;
    private CoffeeMachineState coffeeMachineState;

    private int amount;
    private CoffeeMachine(){
        this.coffeeMachineState = new IdealState(this);
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

    public synchronized Map<String, BigDecimal> getMenu(){
        List<Coffee> coffeeList = this.inventory.giveAvailableCoffeeOptions();
        Map<String, BigDecimal> map = new HashMap<>();
        coffeeList.forEach(coffee -> {
            map.put(coffee.getCoffeeType().toString(),coffee.getPrice());
        });
        return map;
    }
    public void addAmount(int amount){
        this.amount = amount;
    }

    public void insertPayment(int amount){
        this.coffeeMachineState.addMoney(amount);
    }

    public void selectCoffee(CoffeeType coffeeType){
        this.coffeeMachineState.selectCoffeeType(coffeeType);
    }

    public void despenseCoffee(){
        this.coffeeMachineState.despenseCoffee();
    }
}
