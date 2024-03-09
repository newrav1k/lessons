package game.CrossAndZero;

import java.util.*;

public class Person implements Runnable {
    private final Figure figure;
    private volatile static int setCount = 0;
    private static final int[] integers = new int[] {0, 1, 2};

    public Person(Figure figure) {
        this.figure = figure;
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {
            if (setCount == 9) {
                current.interrupt();
            }
            synchronized (Person.class) {
                this.setField();
            }
        }
    }

    public synchronized void setField() {
        int number1 = (int) (Math.random() * 3), number2 = (int) (Math.random() * 3);
        //Map<Integer, Integer> map = getRandom();
        String gameZone = CrossAndZero.field[number1][number2];
        if (gameZone.equals(" ")) {
            CrossAndZero.field[number1][number2] = this.figure.getFigure();
            CrossAndZero.showField();
            ++setCount;
        }
    }

}