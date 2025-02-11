public class Elevator implements Runnable{

    @Override
    public void run() {
        System.out.println("I am Elevator ="+ Thread.currentThread());
    }

    public synchronized void printName(String h) throws InterruptedException {
        System.out.println("Print name = "+ Thread.currentThread()+" "+ h);
        wait();
        System.out.println("=========> "+ Thread.currentThread());
        System.out.println("Wait after thread");
    }

    public synchronized void release(){
        System.out.println("Notify called");
        notifyAll();
    }
}
