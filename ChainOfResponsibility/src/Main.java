public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DiniminationProcessor diniminationProcessor = new HundredDinomination(new FiftyDinomination(new TwentyDinomination(null)));
        diniminationProcessor.withdrawAmount("50");
    }
}
