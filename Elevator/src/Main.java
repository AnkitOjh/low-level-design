import entity.Elevator;
import entity.Floor;
import entity.Request;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        Elevator elevator = new Elevator(1,10);
        elevator.start();  // Start elevator thread

        Thread.sleep(3000);  // Simulate some delay

        new Thread(() -> elevator.addRequestList(new Request(1))).start();  // Add request in a new thread
        new Thread(() -> elevator.addRequestList(new Request(8))).start();

    }
}