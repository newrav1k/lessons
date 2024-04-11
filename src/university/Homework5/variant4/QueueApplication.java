package university.Homework5.variant4;



public class QueueApplication {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new MyThread(1);
        Thread thread2 = new MyThread(2);

        thread1.start();
        thread2.start();
    }
}