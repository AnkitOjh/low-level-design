package Notification.Observer;

public class EmailNotification implements IObserver{

    public String email;
    public EmailNotification(String email){
        this.email = email;
    }
    @Override
    public void update(String event) {
        System.out.println("Email has been sent "+ email);
    }
}
