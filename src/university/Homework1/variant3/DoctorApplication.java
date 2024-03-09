package university.Homework1.variant3;

import java.util.Scanner;

public class DoctorApplication {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MESSAGE =
            """
            Выполнил работу: Крицкий Кирилл
            Группа: РИБО-04-22
            Вариант: 13
            """;

    public static void start(String message) {
        String result;
        switch (message.toLowerCase()) {
            case "стоматолог" -> {
                System.out.print("Введите рецепт: ");
                result = SCANNER.nextLine();
                System.out.println(Dentist.getInstance().writeRecipe(result));
            } case "терапевт" -> {
                System.out.print("Введите рецепт: ");
                result = SCANNER.nextLine();
                System.out.println(Therapist.getInstance().writeRecipe(result));
            }
        }
    }

    public static void main(String[] args) {
        System.out.printf("%s\nВведите врача, которого Вы посетили: ", MESSAGE);
        String message = SCANNER.nextLine();
        start(message);
    }

}