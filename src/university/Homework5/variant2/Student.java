package university.Homework5.variant2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student extends Thread {
    private String name;
    private Semaphore semaphore;

    public Student(String name, Semaphore semaphore) {
        this.name = name;
        this.semaphore = semaphore;
    }
    public void waiting() {
        System.out.printf("%s ожидает свободного места за столом\n", name);
    }

    public void eating() {
        System.out.printf("%s принимает пищу\n", name);
    }

    public void exit() {
        System.out.printf("%s выходит из-за стола\n", name);
    }

    @Override
    public void run() {
        waiting();
        try {
            semaphore.acquire();
            eating();
            Thread.sleep(3000);
        } catch (InterruptedException exception) {
            Logger.getLogger(Student.class.getName())
                    .log(Level.SEVERE, null, exception);
        } finally {
            semaphore.release();
        }
        exit();
    }
}