package JavaRush.JavaCore.PersonScannerAdapter;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String line = fileScanner.nextLine();
            String[] info = line.split(" ");

            Calendar calendar = new GregorianCalendar(Integer.parseInt(info[5]), Integer.parseInt(info[4]) - 1,
                    Integer.parseInt(info[3]));

            return new Person(info[1], info[2], info[0], calendar.getTime());
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}