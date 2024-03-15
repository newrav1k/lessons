package university.Homework1.variant3;

import java.util.Scanner;

public class DoctorApplication {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MESSAGE = """
                    Выполнил работу: Крицкий Кирилл
                    Группа: РИБО-04-22
                    Вариант: 13
                    """;

    public static void start() {
        System.out.printf("""
                    %s
                    Выберите врача, которого Вы посетили, или завершение программы:
                    1 - стоматолог
                    2 - терапевт \n""", MESSAGE);
        String message = SCANNER.nextLine();
        switch (message) {
            case "1" -> {
                System.out.print("Введите рецепт: ");
                System.out.println(new Dentist().writeRecipe(SCANNER.nextLine()));
            }
            case "2" -> {
                System.out.print("Введите рецепт: ");
                System.out.println(new Therapist().writeRecipe(SCANNER.nextLine()));
            }
        }
    }

    public static void main(String[] args) {
        start();
    }
}
