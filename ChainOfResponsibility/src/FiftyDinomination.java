public class FiftyDinomination extends DiniminationProcessor{

    public FiftyDinomination(DiniminationProcessor diniminationProcessor){
        super(diniminationProcessor);
    }

    public void withdrawAmount(String dinomination){
        if(dinomination.equalsIgnoreCase("50")){
            System.out.println("50");
        }
        else{
            super.withdrawAmount(dinomination);
        }
    }
}
