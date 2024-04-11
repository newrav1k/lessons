package university.Homework5.variant1;

public class MyThread extends Thread {
    private static final Object locker = new Object();
    private static int countOfThreads = 0;
    private static int queue = 1;
    private final int numberOfThread;

    public MyThread(int numberOfThread) {
        this.numberOfThread = numberOfThread;
        countOfThreads++;
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        do {
            synchronized (locker) {
                while (numberOfThread != queue) {
                    try {
                        locker.wait();
                    } catch (InterruptedException exception) {
                        current.interrupt();
                    }
                }
                System.out.println(current.getName());
                try {
                    sleep(1000);
                } catch (InterruptedException exception) {
                    current.interrupt();
                }
                queue = numberOfThread % countOfThreads + 1;
                locker.notifyAll();
            }
        } while (!current.isInterrupted());
    }
}