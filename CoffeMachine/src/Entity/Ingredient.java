package Entity;

public class Ingredient {
    private final String name;
    private int quantity;

    public Ingredient(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public String getName(){
        return this.name;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void reduceIngredient(int quantity){
        this.quantity = this.quantity - quantity;
    }
}
