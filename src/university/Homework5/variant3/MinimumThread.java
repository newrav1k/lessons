package university.Homework5.variant3;

import java.util.Collections;
import java.util.ArrayList;

public class MinimumThread extends Thread {
    private final ArrayList<Integer> integers;

    private static int result = Integer.MAX_VALUE;

    public MinimumThread(ArrayList<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public void run() {
        if (!integers.isEmpty()) {
            result = Collections.min(integers);
        }
    }

    @Override
    public String toString() {
        return String.format("Минимальное число: %s", result);
    }
}