public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        Elevator elevator = new Elevator();
        Thread th1 = new Thread(elevator);

        th1.start();
        Thread th12 = new Thread(() -> {
            try {
                elevator.printName("less priority");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        th12.setPriority(1);
        th12.start();
        th12.join();
        new Thread(() -> {
            try {
                elevator.printName("asas");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            elevator.release();
        }).start();
    }
}
