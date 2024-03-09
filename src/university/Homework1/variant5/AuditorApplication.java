package university.Homework1.variant5;

import java.util.Scanner;

public class AuditorApplication {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Auditor AUDITOR = new Auditor();
    private static final Store STORE;

    private static final String MESSAGE =
            """
            Выполнил работу: Крицкий Кирилл
            Группа: РИБО-04-22
            Вариант: 13
            """;

    static {
        System.out.println(MESSAGE + "\nВведите название магазина: ");
        STORE = new Store(SCANNER.nextLine());
    }

    public static void start() {
        if (STORE.getName().equals("IKEA")) {
            AUDITOR.closeStore(STORE);
        } else {
            AUDITOR.rebrand(STORE);
        }
        System.out.println(STORE);
    }

    public static void main(String[] args) {
        start();
    }

}