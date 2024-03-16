package university.Homework3.variant3;

import java.util.Scanner;
import java.io.*;

/*
C:\Users\OlegK\OneDrive\Рабочий стол\input.txt
C:\Users\OlegK\OneDrive\Рабочий стол\output.txt
*/

/*Вариант 3.
Разработать программу для модификации входного файла.
Модификация заключается в последовательном наложении гаммы (операция XOR) на байты
входного файла.
    Обязательные требования к программе:
         Путь к исходному файлу, а также байты гаммы задает пользователь
после старта программы.
         Необходимо открыть файл, прочитать содержащиеся в нем байты,
осуществить побайтовую операцию XOR с гаммой и записать выходной
результат в новый файл.
         Новый файл должен быть сохранен рядом с исходным.

Пример содержимого входного файла (6 байт):
0x1A, 0x2B, 0x3C, 0x3C, 0x44, 0x44

Гамма: ABCD (2 байта)

Содержимое выходного файла (6 байт):
0xB1, 0xE6, 0x97, 0xF1, 0xEF, 0x89*/

public class FileApplication {
    private static String inputPath;
    private static byte[] gamma;

    public static void initializePathAndGamma() {
        System.out.println("Введите путь к файлу: ");
        try (Scanner scanner = new Scanner(System.in)) {
            inputPath = scanner.nextLine();
            gamma = hexStringToByteArray(scanner.nextLine());
        }
    }

    public static byte[] readBytesFromFile() throws IOException {
        File file = new File(inputPath);
        try (FileInputStream inputStream = new FileInputStream(file)) {
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            for (int i = 0; i < data.length; i++) {
                data[i] ^= gamma[i % gamma.length];
            }
            return data;
        }
    }

    public static void writeBytesToFile(byte[] bytes) throws IOException {
        File file = new File("C:\\Users\\OlegK\\OneDrive\\Рабочий стол\\output.bin");
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(bytes);
        }
    }

    public static byte[] hexStringToByteArray(String s) throws IllegalArgumentException {
        int len = s.length();
        if (len % 2 == 1) {
            throw new IllegalArgumentException("Error hexString");
        }
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static void start() throws IOException {
        initializePathAndGamma();
        writeBytesToFile(readBytesFromFile());
    }

    public static void main(String[] args) throws IOException {
        start();
    }
}