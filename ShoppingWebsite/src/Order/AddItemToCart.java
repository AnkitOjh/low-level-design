package Order;

public class AddItemToCart implements Commander{
    private Cart cart;
    private Item item;

    public AddItemToCart(Cart cart, Item item){
        this.cart = cart;
        this.item = item;
    }
    @Override
    public void execute() {
        cart.addItem(item);
    }
}
