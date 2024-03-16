package university.Homework3.variant3;

import java.util.Scanner;
import java.nio.file.Path;
import java.io.*;

public class FileApplication {
    private static String inputPath;
    private static byte[] gamma;

    public static void initializePathAndGamma() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите путь к файлу: ");
            inputPath = scanner.nextLine();
            System.out.println("Введите гамму: ");
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
        Path path = Path.of(inputPath);
        String parentPath = path.getParent().toString();
        File file = new File(parentPath, "output.txt");
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