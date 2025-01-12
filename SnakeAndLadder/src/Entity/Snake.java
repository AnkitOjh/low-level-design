package Entity;

import java.util.List;

public class Snake implements Props {
    private final List<Integer> source;
    private final List<Integer> destination;

    public Snake(List<Integer> source, List<Integer> destination){
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
