package Entity;

import subscriber.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private List<Publisher> publishers;
    private List<ISubscriber> subscribers;

    private List<Message> messages;

    private String name;

    public Topic(String name){
        this.name = name;
        this.publishers = new ArrayList<>();
        this.subscribers = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public synchronized void addPublisher(Publisher publisher){
        publishers.add(publisher);
    }
    public synchronized void addSubscriber(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }
    public synchronized boolean checkPublisher(Publisher publisher){
        return publishers.contains(publisher);
    }
    public synchronized boolean checkListener(ISubscriber subscriber){
        return subscribers.contains(subscriber);
    }

    public synchronized void addMessage(Message message){
        this.messages.add(message);
        notifyToAllListener(message);
    }
    private void notifyToAllListener(Message message){
        if(subscribers.size() == 0){
            System.out.println("No subscriber to be updated");
        }
        for(ISubscriber subscriber: subscribers){
            subscriber.updateMessage(message);
        }
        System.out.println("All subscriber got the message");
    }

    public String getTopicName(){
        return this.name;
    }
}
