package game.CrossAndZero;

import java.util.Arrays;

public class CrossAndZero {
    protected static final String[][] field = new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    protected volatile static int setCount = 0;

    public static void showField() {
        for (String[] strings : field) {
            System.out.println(Arrays.toString(strings));
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread player1 = new Thread(new Person(Figure.Cross), "Cross");
        Thread player2 = new Thread(new Person(Figure.Zero), "Zero");

        player1.start();
        player2.start();
    }
}