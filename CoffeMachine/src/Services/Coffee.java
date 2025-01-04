package Services;

import Entity.Ingredient;
import Enums.CoffeeType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public class Coffee {
    private final CoffeeType coffeeType;
    private Map<Ingredient,Integer> recipe;
    private BigDecimal price;

    public Coffee(CoffeeType coffeeType, Map<Ingredient,Integer> recipe, BigDecimal price){
        this.coffeeType = coffeeType;
        this.price = price;
        this.recipe = recipe;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    public CoffeeType getCoffeeType(){
     return this.coffeeType;
    }

    public Map<Ingredient, Integer> getRecipe(){
        return this.recipe;
    }

    public boolean isAvailable(){
        for(Map.Entry<Ingredient, Integer> entry : this.recipe.entrySet()){
            if(entry.getKey().getQuantity() < entry.getValue()){
                return false;
            }
        }
        return true;
    }


}
