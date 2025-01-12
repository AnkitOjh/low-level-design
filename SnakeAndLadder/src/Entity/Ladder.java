package Entity;

public class Ladder implements Props{
    private final int[] source;
    private final int[] destination;

    public Ladder(int[] source, int[] destination){
        this.source = source;
        this.destination = destination;
    }

    public int[] getDestination(){
        return this.destination;
    }

    public int[] getSource(){
        return this.source;
    }
}
