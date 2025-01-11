package service;

import Entity.Message;
import Entity.Publisher;
import subscriber.ISubscriber;

public class QueueProcessor {
    private TopicManager topicManager;

    public QueueProcessor(){
        this.topicManager = new TopicManager();
    }
    public void subscribeForListener(String topicName, ISubscriber subscriber){
        topicManager.subscribeListenerToTopic(topicName,subscriber);
    }
    public void subscribeForPublisher(String topicName, Publisher publisher){
        topicManager.subscribePublisherToTopic(topicName,publisher);
    }

    public void createNewTopic(String topicName){
        topicManager.createTopic(topicName);
    }

    public Message createMessage(String message){
        return new Message(message);
    }

    public void publishMessage(String topicName,String msg,String publisher){
        this.topicManager.publishMessage(topicName, new Message(msg), publisher);
    }
}
