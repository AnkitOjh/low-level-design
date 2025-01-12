package Entity;

import java.util.List;

public class Ladder implements Props{
    private final List<Integer> source;
    private final List<Integer> destination;

    public Ladder(List<Integer> source, List<Integer> destination){
        this.source = source;
        this.destination = destination;
    }

    public List<Integer> getDestination(){
        return this.destination;
    }

    public List<Integer> getSource(){
        return this.source;
    }
}
