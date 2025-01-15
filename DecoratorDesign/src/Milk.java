public class Milk extends ExtraDecorator{
    private Coffee coffee;
    public Milk(Coffee coffee){
        this.coffee = coffee;
    }
    @Override
    public int cost() {
        return coffee.cost()+10;
    }
}
