package game.CrossAndZero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrossAndZero {
    private static final List<Thread> people = new ArrayList<>() {{
        add(new Thread(new Person(Figure.Cross), "Cross"));
        add(new Thread(new Person(Figure.Zero), "Zero"));
    }};
    protected static final String[][] field = new String[][] {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    public static boolean hasWinner = false;

    public static void main(String[] args) throws InterruptedException {
        people.forEach(Thread::start);
    }

    public synchronized static void showField() {
        for (String[] strings : field) {
            System.out.println(Arrays.toString(strings));
        }
        System.out.println();
    }

}