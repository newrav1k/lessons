package university.Homework1.variant3;

import java.util.Scanner;

public class DoctorApplication {
    private static final String MESSAGE = """
                    Выполнил работу: Крицкий Кирилл
                    Группа: РИБО-04-22
                    Вариант: 13
                    """;

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("""
                    %s
                    Выберите врача, которого Вы посетили, или завершение программы:
                    1 - стоматолог
                    2 - терапевт \n""", MESSAGE);
        String message = scanner.nextLine();
        System.out.print("Введите рецепт: ");
        switch (message) {
            case "1" -> System.out.println(new Dentist().writeRecipe(scanner.nextLine()));
            case "2" -> System.out.println(new Therapist().writeRecipe(scanner.nextLine()));
        }
    }

    public static void main(String[] args) {
        start();
    }
}