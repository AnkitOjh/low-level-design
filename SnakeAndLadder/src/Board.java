import Entity.Ladder;
import Entity.Props;
import Entity.Snake;

import java.util.HashMap;

public class Board {
    private HashMap<int[], Props> propsHashMap;
    public Board() {
        propsHashMap = new HashMap<>();
        Props propsOne = new Snake(new int[]{2, 5}, new int[]{1, 1});
        propsHashMap.put(propsOne.getSource(),propsOne);
        Props propsTwo = new Snake(new int[]{9, 4}, new int[]{2, 2});
        propsHashMap.put(propsTwo.getSource(),propsTwo);
        Props ladder = new Ladder(new int[]{2, 2}, new int[]{9, 4});
        propsHashMap.put(ladder.getSource(),ladder);
    }
    public HashMap<int[], Props> getPropsHashMap(){
        return this.propsHashMap;
    }

    public int[] giveTheDestination(int diceValue, int[] position){
        int[] temp = new int[2];
        temp[0] = position[0];
        temp[1] = position[1];
        int[] destination = giveDestinationFromprops(position);
        if(position[0] == 10 && position[1]-diceValue <=0){
            return position;
        }
        if(destination != null){
            return destination;
        }
        if(position[0]%2 ==0){
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
        return temp;
    }

    private int[] giveDestinationFromprops(int[] position){
        if(propsHashMap.containsKey(position)){
            return propsHashMap.get(position).getDestination();
        }
        return null;
    }
}

