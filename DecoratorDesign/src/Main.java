public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Milk(new Cream(new Expresso()));
        System.out.println(coffee.cost());

    }
}