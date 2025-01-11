package Entity;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private int id;

    private final String name;
    private List<Topic> topicList;

    private List<Message> messages;

    public Publisher(String name){
        topicList = new ArrayList<>();
        messages = new ArrayList<>();
        this.name = name;
    }
    public List<Topic> getTopicList(){
        return topicList;
    }

    public void setMessages(Message message){
        messages.add(message);
        System.out.println("Message added to publisher");
    }
    public synchronized void setTopicList(Topic topic){
        System.out.println("Topic added to publisher successfully");
        topicList.add(topic);
    }
}
