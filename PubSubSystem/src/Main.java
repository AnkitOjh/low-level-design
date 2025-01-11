import Entity.Publisher;
import Entity.Topic;
import service.QueueProcessor;
import subscriber.Subscriber;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        QueueProcessor queueProcessor = new QueueProcessor();
        queueProcessor.createNewTopic("topic-1");
        queueProcessor.createNewTopic("topic-2");
        queueProcessor.subscribeForListener("topic-1",new Subscriber("sub-1"));
        queueProcessor.subscribeForListener("topic-1",new Subscriber("sub-2"));
        queueProcessor.subscribeForPublisher("topic-1",new Publisher("pub-1"));
        queueProcessor.publishMessage("topic-1","message from pub-1","pub-1");

        //Negative scenio
        queueProcessor.publishMessage("topic-3","message from pub-1","pub-1");
        System.out.println("After this execution");
        queueProcessor.subscribeForPublisher("topic-3",new Publisher("pub-1"));
    }
}