package subscriber;

import Entity.Message;

public class Subscriber implements ISubscriber{

    private final String name;
    public Subscriber(String name){
        this.name = name;
    }
    @Override
    public void updateMessage(Message message) {
        System.out.println("Message => "+message.getMessage());
    }
}
