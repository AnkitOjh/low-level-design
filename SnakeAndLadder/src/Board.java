import Entity.Props;
import Entity.Snake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board {
    private HashMap<List<Integer>, Props> propsHashMap;
    public Board() {
        propsHashMap = new HashMap<>();
        Props propsOne = new Snake(List.of(1, 3), List.of(1, 1));
        propsHashMap.put(propsOne.getSource(),propsOne);
//        Props propsTwo = new Snake(new int[]{9, 4}, new int[]{2, 2});
//        propsHashMap.put(propsTwo.getSource(),propsTwo);
//        Props ladder = new Ladder(new int[]{2, 2}, new int[]{9, 4});
//        propsHashMap.put(ladder.getSource(),ladder);
    }
    public HashMap<List<Integer>, Props> getPropsHashMap(){
        return this.propsHashMap;
    }

    public int[] giveTheDestination(int diceValue, int[] position){
        int[] temp = new int[2];
        temp[0] = position[0];
        temp[1] = position[1];

        if(position[0] == 10 && position[1]-diceValue <=0){
            return position;
        }
        if(position[0]%2 !=0){
            if(position[1]+diceValue > 10){
                temp[1] = 21-diceValue-position[1];
                temp[0]+=1;
            }
            else{
                temp[1]+=diceValue;
            }
        }
        else{
            if(position[1]-diceValue <=0 ){
                temp[1] = 1+diceValue-position[1];
                temp[0]+=1;
            }
            else{
                temp[1]-= diceValue;
            }
        }
        List<Integer> destination = giveDestinationFromprops(temp);
        synchronized (this){
            if(destination != null){
                return new int[]{destination.get(0),destination.get(1)};
            }
        }

        return temp;
    }

    private List<Integer> giveDestinationFromprops(int[] position){
        List<Integer> list = new ArrayList<>();
        list.add(position[0]);
        list.add(position[1]);
        synchronized (this){
            if(propsHashMap.containsKey(list)){
                return propsHashMap.get(list).getDestination();
            }
        }
        return null;
    }
}

