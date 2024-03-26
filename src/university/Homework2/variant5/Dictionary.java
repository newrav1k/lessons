package university.Homework2.variant5;

import java.util.*;

public class Dictionary {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final HashMap<String, HashSet<String>> SET = new LinkedHashMap<>() {{
        put("Abdication", new HashSet<>(){{
            add("отказ");
            add("отречение");
            add("сложение полномочий");
        }});
        put("Aperitif", new HashSet<>() {{
            add("аперитив");
        }});
        put("Mead", new HashSet<>() {{
            add("мёд");
            add("луг");
        }});
        put("Zizz", new HashSet<>() {{
            add("жужжание");
        }});
    }};

    public static void getNewWord(String message) {
        if (isExist(message)) {
            System.out.println("Введите перевод - ");
            HashSet<String> translate = SET.get(message);
            translate.add(SCANNER.nextLine());
            SET.put(message, translate);
        } else {
            HashSet<String> strings = new HashSet<>();
            System.out.println("Введите перевод - ");
            String translate = SCANNER.nextLine();
            strings.add(translate);
            SET.put(message, strings);
        }
        showSet();
    }

    public static void deleteWordByKey(String message) {
        System.out.println("Введите слово - ");
        SET.remove(message);
        showSet();
    }

    public static boolean isExist(String string) {
        for (var item : SET.entrySet()) {
            String key = item.getKey();
            if (key.equalsIgnoreCase(string)) {
                return true;
            }
        }
        return false;
    }

    public static void showSet() {
        for (var item : SET.entrySet()) {
            System.out.printf("%s - %s\n", item.getKey(), item.getValue().toString());
        }
    }

    public static void start() {
        System.out.println("""
                Выберите, что хотите сделать :
                1 - Добавить новое слово
                2 - Удалить слово
                3 - Вывести список
                4 - Закончить программу""");
        while (true) {
            String message = SCANNER.nextLine();
            switch (message) {
                case "1" -> {
                    System.out.println("Введите слово - ");
                    getNewWord(SCANNER.nextLine());
                }
                case "2" -> {
                    System.out.println("Введите слово - ");
                    deleteWordByKey(SCANNER.nextLine());
                }
                case "3" -> showSet();
                case "4" -> {
                    System.out.println("Завершаю программу...");
                    return;
                }
                default -> System.out.println("Что-то не то, введите ещё раз!");
            }
        }
    }

    public static void main(String[] args) {
        start();
    }
}