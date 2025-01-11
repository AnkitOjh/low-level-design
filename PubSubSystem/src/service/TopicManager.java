package service;

import Entity.Message;
import Entity.Publisher;
import Entity.Topic;
import subscriber.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class TopicManager {
    private List<Topic> topicList;

    public TopicManager(){
        this.topicList = new ArrayList<>();
    }

    public synchronized void subscribeListenerToTopic(String topicName, ISubscriber subscriber){
        Topic topic = checkForTopic(topicName);
        if(topic != null){
            topic.addSubscriber(subscriber);
            System.out.println("subscribed successfully");
        }
        else{
            System.out.println("No topic with this name exists");
        }
    }

    public synchronized void subscribePublisherToTopic(String topicName, Publisher publisher){
        Topic topic = checkForTopic(topicName);
        if(topic != null){
            topic.addPublisher(publisher);
            publisher.setTopicList(topic);
            System.out.println("subscribed successfully");
        }
        else{
            System.out.println("No topic with this name exists");
        }
    }

    public synchronized void createTopic(String topicName){
        if(checkForTopic(topicName) != null){
            System.out.println("Topic with this name already exists");
        }
        else{
            System.out.println("Topic created successfully");
            topicList.add(new Topic(topicName));
        }
    }

    public void publishMessage(String topicName, Message message, Publisher publisher){
        Topic topic = checkForTopic(topicName);
        if(topic != null){
            if(topic.checkPublisher(publisher) == true){
                topic.addMessage(message);
                System.out.println("Publisher has added the message");
            }
        }
    }

    private Topic checkForTopic(String topicName){
        for(Topic topic: topicList){
            if(topic.getTopicName().equalsIgnoreCase(topicName)){
                return topic;
            }
        }
        return null;
    }
}
