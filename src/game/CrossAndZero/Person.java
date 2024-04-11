package game.CrossAndZero;

public class Person extends Thread {
    private final Figure figure;

    public Person(Figure figure) {
        this.figure = figure;
    }

    public synchronized void changeField() {
        CrossAndZero.field[(int) Math.random() * 3][(int) Math.random() * 3] = this.figure.getFigure();
        CrossAndZero.showField();
    }

    @Override
    public synchronized void run() {
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {
            if (CrossAndZero.setCount == 9) {
                current.interrupt();
            }
            changeField();
            try {
                wait();
            } catch (InterruptedException ignored) {}
            notify();
            ++CrossAndZero.setCount;
        }
    }
}