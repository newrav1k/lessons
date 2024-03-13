package university.Homework1.variant3;

import java.util.Scanner;

public class DoctorApplication {
    private static final Therapist THERAPIST = Therapist.getInstance();
    private static final Dentist DENTIST = Dentist.getInstance();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MESSAGE =
            """
                    Выполнил работу: Крицкий Кирилл
                    Группа: РИБО-04-22
                    Вариант: 13
                    """;

    public static void start() {
        System.out.println(MESSAGE);
        while (true) {
            System.out.print("""
                    Выберите врача, которого Вы посетили, или завершение программы:
                    1 - стоматолог
                    2 - терапевт
                    3 - завершить программу \n""");
            String message = SCANNER.nextLine();
            switch (message) {
                case "1" -> {
                    System.out.print("Введите рецепт: ");
                    System.out.println(DENTIST.writeRecipe(SCANNER.nextLine()));
                }
                case "2" -> {
                    System.out.print("Введите рецепт: ");
                    System.out.println(THERAPIST.writeRecipe(SCANNER.nextLine()));
                }
                case "3" -> {
                    System.out.println("Завершаю программу...");
                    return;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        start();
    }
}