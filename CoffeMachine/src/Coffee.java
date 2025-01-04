import Entity.Ingredient;
import Enums.CoffeeType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Coffee {
    private CoffeeType coffeeType;
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


}
