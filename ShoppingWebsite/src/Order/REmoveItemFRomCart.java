package Order;

public class REmoveItemFRomCart implements Commander{
    private Cart cart;
    private Item item;

    public REmoveItemFRomCart(){
        this.cart = cart;
        this.item = item;
    }
    @Override
    public void execute() {
        this.cart.removeItem(item);
    }
}
