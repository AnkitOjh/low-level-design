package exception;

public class IllegalMove extends RuntimeException{
    public IllegalMove(String message){
        super(message);
    }

}
