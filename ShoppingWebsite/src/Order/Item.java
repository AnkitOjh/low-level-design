package Order;

public class Item {
    private final int id;
    private final String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
