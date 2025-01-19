public class Message {
    private final String id;
    private String message;

    public Message(String id,String message){
        this.message = message;
        this.id = id;

    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
