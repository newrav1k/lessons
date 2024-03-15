package university.Homework2.variant4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class PassportApplication {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ArrayList<Passport> PASSPORTS = new ArrayList<>() {{
        add(new Passport("Антонов Андрей Антонович", 445566, "сантехник", false));
        add(new Passport("Иванов Иван Иванович", 112134, "директор", true));
        add(new Passport("Яковлева Юлия Аристарховна", 306306, "секретарь", false));
        add(new Passport("Патриций Юлий Астапович", 826571, "программист", false));
        add(new Passport("Волк Тимур Сергеевич", 265771, "шут", false));
    }};

    public static void addPassport() {
        System.out.println("Введите ФИО - ");
        String name = SCANNER.nextLine();
        System.out.println("Введите номер пропуска - ");
        int number = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Введите должность - ");
        String post = SCANNER.nextLine();
        System.out.println("Введите прохождение - ");
        boolean isPassingCompleted = SCANNER.nextBoolean();
        PASSPORTS.add(new Passport(name, number, post, isPassingCompleted));
        showPassports();
    }

    public static void showPassports() {
        PASSPORTS.stream().sorted(Comparator.comparing(Passport::getName)).forEach(System.out::println);
        System.out.println();
        PASSPORTS.stream().sorted(Comparator.comparingInt(Passport::getNumber)).forEach(System.out::println);
    }

    public static void start() {
        System.out.println("""
                Выберите, что хотите сделать:
                1 - добавить пропуск в список
                2 - вывести списки
                3 - завершить программу""");
        while (true) {
            String message = SCANNER.nextLine();
            switch (message) {
                case "1" -> addPassport();
                case "2" -> showPassports();
                case "3" -> {
                    System.out.println("Завершаю программу...");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        start();
    }
}