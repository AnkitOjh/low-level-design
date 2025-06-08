import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        Elevator elevator = new Elevator();
//        Thread th1 = new Thread(elevator);
//
//        th1.start();
//        Thread th12 = new Thread(() -> {
//            try {
//                elevator.printName("less priority");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        th12.setPriority(1);
//        th12.start();
//        th12.join();
//        new Thread(() -> {
//            try {
//                elevator.printName("asas");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }).start();
//
//        new Thread(() -> {
//            elevator.release();
//        }).start();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=1;i<=5;i++){
            executorService.submit(new MyTask(i));
        }
        executorService.shutdown();

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching data in: " + Thread.currentThread().getName());
            return "Hello, Future!";
        });

        String result = future.get(); // Blocks until result is available
        System.out.println("Result: " + result);

    }
}
