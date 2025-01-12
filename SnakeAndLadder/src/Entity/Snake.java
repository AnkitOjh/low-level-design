package Entity;

public class Snake implements Props {
    private final int[] source;
    private final int[] destination;

    public Snake(int[] source, int[] destination){
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
