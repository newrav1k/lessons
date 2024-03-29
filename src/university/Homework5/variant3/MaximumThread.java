package university.Homework5.variant3;

import java.util.Collections;
import java.util.ArrayList;

public class MaximumThread extends Thread {
    private final ArrayList<Integer> integers;
    private static int result = Integer.MIN_VALUE;

    public MaximumThread(ArrayList<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public void run() {
        if (!integers.isEmpty()) {
            result = Collections.max(integers);
        }
    }

    @Override
    public String toString() {
        return String.format("Максимальное число: %s", result);
    }
}