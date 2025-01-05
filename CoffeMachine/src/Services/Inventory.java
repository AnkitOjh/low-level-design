package Services;

import Entity.Ingredient;
import Enums.CoffeeType;
import Services.Coffee;

import java.util.*;

public class Inventory {
    private Map<String, Ingredient> ingredientIntegerMap;
    private Map<CoffeeType, Coffee> coffeeMap;

    public Inventory(){
        this.coffeeMap = new HashMap<>();
        this.ingredientIntegerMap = new HashMap<>();
    }

    public synchronized void addCoffee(Coffee coffee){
        if(coffeeMap.containsKey(coffeeMap.containsKey(coffee.getCoffeeType()))){
            System.out.println("This coffee type is already added");
        }
        else{
            coffeeMap.put(coffee.getCoffeeType(), coffee);
        }
    }

    public synchronized void addIngredient(Ingredient ingredient){
        if(ingredientIntegerMap.containsKey(ingredient.getName())){
            System.out.println("Updating the ingridient");
            if(ingredient.getQuantity() <= 0){
                System.out.println("Quantity can't be  negative or zero");
                return;
            }
            ingredient.setQuantity(ingredient.getQuantity());
        }
        else{
            ingredientIntegerMap.put(ingredient.getName(), ingredient);
        }
    }

    public synchronized void removeIngredient(CoffeeType coffeeType){
        Coffee coffee = coffeeMap.get(coffeeType);
        for(Map.Entry<Ingredient, Integer> entry : coffee.getRecipe().entrySet()){
            entry.getKey().reduceIngredient(entry.getValue());
        }
    }

    public synchronized List<Coffee> giveAvailableCoffeeOptions(){
        List<Coffee> filteredCoffeeList = new ArrayList<>();
        for(Map.Entry<CoffeeType, Coffee> entry: this.coffeeMap.entrySet()){
            if(entry.getValue().isAvailable()){
                filteredCoffeeList.add(entry.getValue());
            }

        }
        return filteredCoffeeList;
    }

    public List<Ingredient> notifyForEmptyIngredient(){
        List<Ingredient> emptyList = new ArrayList<>();
        for(Map.Entry<String, Ingredient> integerEntry : this.ingredientIntegerMap.entrySet()){
            if(integerEntry.getValue().getQuantity() <= 0){
                emptyList.add(integerEntry.getValue());
            }
        }
        return emptyList;
    }

}
