package vending;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Product,Integer> products;

    Inventory(){
        products = new HashMap<>();
    }

    public boolean findProduct(Product product){
        return products.containsKey(product) && products.get(product)>0;
    }
    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void updateQuantity(Product product, int quantity) {
        products.put(product, quantity);
    }

    public int getQuantity(Product product) {
        return products.getOrDefault(product, 0);
    }

    public boolean isAvailable(Product product) {
        return products.containsKey(product) && products.get(product) > 0;
    }
}
