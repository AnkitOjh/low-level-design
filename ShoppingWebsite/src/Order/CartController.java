package Order;

public class CartController {
    private Commander command;
    public CartController(Commander command){
        this.command = command;
    }
    public void executeItemAddOrRemove(){
        command.execute();
    }
}
