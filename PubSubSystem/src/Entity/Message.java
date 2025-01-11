package Entity;

public class Message {
    private int id;
    private String comment;

    public Message(String comment){
        this.comment = comment;
    }

    public void setMessage(String message){
        this.comment = message;
    }
    public String getMessage(){
        return this.comment;
    }


}
