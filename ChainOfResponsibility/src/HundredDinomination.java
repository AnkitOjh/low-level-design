public class HundredDinomination extends DiniminationProcessor{
    public HundredDinomination(DiniminationProcessor diniminationProcessor){
        super(diniminationProcessor);
    }

    public void withdrawAmount(String dinomination){
        if(dinomination.equalsIgnoreCase("100")){
            System.out.println("100");
        }
        else{
            super.withdrawAmount(dinomination);
        }
    }
}
