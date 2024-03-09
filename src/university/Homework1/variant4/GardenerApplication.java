package university.Homework1.variant4;

import java.util.Scanner;

public class GardenerApplication {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Gardener GARDENER = new Gardener();
    private static final Plant plant;

    private static final String MESSAGE =
            """
            Выполнил работу: Крицкий Кирилл
            Группа: РИБО-04-22
            Вариант: 13
            """;

    static {
        System.out.println(MESSAGE + "\nВведите название цветка: ");
        plant = new Plant(SCANNER.nextLine());
    }

    public static void start() {
        GARDENER.filter(plant);
        System.out.println(plant);
    }

    public static void main(String[] args) {
        start();
    }
}