package university.Homework4.variant2;

import java.util.Scanner;

public class MessageApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу: ");

        LoaderRunnable runnable = new LoaderRunnable(scanner.nextLine());
        Thread load = new Thread(runnable, "load");

        load.start();
    }
}