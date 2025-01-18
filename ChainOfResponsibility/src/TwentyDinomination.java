public class TwentyDinomination extends  DiniminationProcessor{
    public TwentyDinomination(DiniminationProcessor diniminationProcessor) {
        super(diniminationProcessor);
    }

    public void withdrawAmount(String dinomination){
        if(dinomination.equalsIgnoreCase("20")){
            System.out.println("20 dinomination");
        }
        else{
            System.out.println("None can process");
        }
    }


}
