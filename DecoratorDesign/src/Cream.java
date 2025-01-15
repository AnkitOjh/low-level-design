public class Cream extends ExtraDecorator {
    private Coffee coffee;
    public Cream(Coffee coffee){
        this.coffee = coffee;
    }
    @Override
    public int cost() {
        return coffee.cost()+20;
    }
}
