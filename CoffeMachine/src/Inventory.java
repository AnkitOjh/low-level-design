import Entity.Ingredient;
import Enums.CoffeeType;

import java.util.*;

public class Inventory {
    private Map<String, Ingredient> ingredientIntegerMap;
    private Map<CoffeeType, Coffee> coffeeMap;

    public Inventory(){
        this.coffeeMap = new HashMap<>();
        this.ingredientIntegerMap = new HashMap<>();
    }

    public void addCoffee(Coffee coffee){
        if(coffeeMap.containsKey(coffeeMap.containsKey(coffee.getCoffeeType()))){
            System.out.println("This coffee type is already added");
        }
        else{
            coffeeMap.put(coffee.getCoffeeType(), coffee);
        }
    }

    public void addIngredient(Ingredient ingredient){
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

    public List<Coffee> giveAvailableCoffeeOptions(){

    }

    public List<Ingredient> notifyForEmptyIngredient(){

    }



}
