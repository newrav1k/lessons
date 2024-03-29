package university.Homework5.variant3;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberApplication {
    private static final ArrayList<Integer> INTEGER_ARRAY_LIST = new ArrayList<>();

    public static void initializeList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вводите числа через запятую: ");
        String[] message = scanner.nextLine().split(", ");
        for (String s : message) {
            int number;
            try {
                number = Integer.parseInt(s);
                INTEGER_ARRAY_LIST.add(number);
            } catch (NumberFormatException ignored) {

            }
        }
        System.out.println("Мы оставили только числа...");
        System.out.println(INTEGER_ARRAY_LIST);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("""
            Выполнил работу: Крицкий Кирилл
            Группа: РИБО-04-22
            Вариант: 13 \n""");
        initializeList();

        Thread minimum = new MinimumThread(INTEGER_ARRAY_LIST);
        Thread maximum = new MaximumThread(INTEGER_ARRAY_LIST);

        minimum.start();
        minimum.join();
        maximum.start();
        maximum.join();

        System.out.println(minimum);
        System.out.println(maximum);
    }
}