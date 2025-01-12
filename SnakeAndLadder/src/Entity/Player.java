package Entity;

public class Player {
    private final String userName;

    private int[] position;
    public Player(String userName){
        this.userName = userName;
        position = new int[]{0, 0};
    }
    public String getUserName(){
        return this.userName;
    }
    public int[] getPosition(){
        return this.position;
    }
    public void setPosition(int[] position){
        this.position = position;
    }


}
