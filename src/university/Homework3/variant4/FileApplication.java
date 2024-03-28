package university.Homework3.variant4;

import java.util.*;
import java.io.*;

public class FileApplication {
    private static final ArrayList<String> list = new ArrayList<>();

    public static void readFromDirectory(String path, String extension) {
        File directory = new File(path);
        File[] files = directory.listFiles(); // получаем массив файлов в каталоге
        assert files != null;
        for (File file : files) { // пробег по всем файлам в каталоге
            String filePath = file.getAbsolutePath();
            if (file.isDirectory()) { // если это каталог
                readFromDirectory(filePath, extension); // рекурсия
            } else if (file.isFile() && filePath.substring(filePath.lastIndexOf(".")).equals(extension)) {
                list.add(getBytesFromFile(file));
            }
        }
    }

    public static String getBytesFromFile(File file) {
        String path = file.getAbsolutePath(); // получаем путь к файлу
        String result = null;
        try (FileInputStream inputStream = new FileInputStream(file)) { // поток чтения из файла
            byte[] bytes = new byte[inputStream.available()]; // массив байт с размером как у файла
            result = String.format("%s %s", path, bytes.length);
        } catch (IOException exception) {
            System.out.println("Произошла ошибка при чтении файла - " + path);
        }
        return result;
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        File file; // создаем переменную типа File
        do { // делай
            System.out.println("Введите путь к файлу: ");
            file = new File(scanner.nextLine()); // путь к файлу
            if (!file.exists()) System.out.println("Но ведь...такого файла не существует...");
        } while (!file.exists()); // пока файл не существует
        System.out.println("Введите расширение");
        String extension = scanner.nextLine(); // расширение
        readFromDirectory(file.getAbsolutePath(), extension); // считываем каталоги и файлы и заносим их в список
        list.stream().sorted(String::compareTo).forEach(System.out::println);
    }

    public static void main(String[] args) {
        start();
    }
}