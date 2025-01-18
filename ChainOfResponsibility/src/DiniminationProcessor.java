public abstract class DiniminationProcessor {

    private DiniminationProcessor next;
    public DiniminationProcessor(DiniminationProcessor diniminationProcessor){
        this.next = diniminationProcessor;
    }
    public void withdrawAmount(String dinomination){
        if(next != null){
            next.withdrawAmount(dinomination);
        }
    }
}
