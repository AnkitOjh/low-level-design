package Entity;

public class User {
    private int id;
    private String userName;
    private int reputation;
    public User(String name){
        this.reputation = 0;
        this.userName = name;
    }
    public int getReputation(){
        return this.reputation;
    }
    public void setReputation(int reputation){
        this.reputation = reputation;
    }

    public String getUserName(){
        return this.userName;
    }
}
