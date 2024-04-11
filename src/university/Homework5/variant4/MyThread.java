package university.Homework5.variant4;

/*Разработать программу, которая строго по очереди выводит в
консоль имя текущего работающего потока. Обязательные требования к
программе:
     Программа должна работать непрерывно (будет плюсом, если реализуете прерывание
    работы по нажатию на какую-нибудь клавишу).
     Для демонстрации работы необходимо создать два дополнительных потока.
     Программа должна использовать synchronized или wait/notify.*/


public class MyThread extends Thread {
    private static final Object locker = new Object();
    private static int queue = 1;
    private int numberOfThread;

    public MyThread(int numberOfThread) {
        this.numberOfThread = numberOfThread;
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (!currentThread().isInterrupted()) {
            synchronized (locker) {
                while (numberOfThread != queue) {
                    try {
                        locker.wait();
                    } catch (InterruptedException ignore) {}
                }
                System.out.println(current.getName());
                try {
                    sleep(1000);
                } catch (InterruptedException ignore) {}
                queue = numberOfThread == 1 ? 2 : 1;
                locker.notify();
            }
        }
    }
}