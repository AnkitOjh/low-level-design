import Order.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Cart cart = new Cart();
        Item item = new Item();
        CartController commander = new CartController(new AddItemToCart(cart,item));
        commander.executeItemAddOrRemove();
    }
}