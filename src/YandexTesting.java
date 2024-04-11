import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YandexTesting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine().trim();
        String input = scanner.nextLine().trim();

        List<Character> left = new ArrayList<>();
        List<Character> right = new ArrayList<>();

        Pattern pattern = Pattern.compile("<delete>|<bspace>|<left>|<right>|[a-z]");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String match = matcher.group();
            switch (match) {
                case "<delete>":
                    if (!right.isEmpty()) {
                        right.remove(right.size() - 1);
                    }
                    break;
                case "<bspace>":
                    if (!left.isEmpty()) {
                        left.remove(left.size() - 1);
                    }
                    break;
                case "<left>":
                    if (!left.isEmpty()) {
                        right.add(left.remove(left.size() - 1));
                    }
                    break;
                case "<right>":
                    if (!right.isEmpty()) {
                        left.add(right.remove(right.size() - 1));
                    }
                    break;
                default:
                    left.add(match.charAt(0));
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : left) {
            result.append(c);
        }
        for (int i = right.size() - 1; i >= 0; i--) {
            result.append(right.get(i));
        }
        if (word.equals(result.toString())) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}



class Helper_Task_1 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String message = reader.readLine();
            System.out.println(isEmo(message) ? "YES" : "NO");
        } catch (IOException ignore) {}
    }

    public static boolean isEmo(String message) {
        if (8 <= message.length() && message.length() < 100) {
            char[] chars = message.toCharArray();
            int dig = 0;
            int zag = 0;
            int pro = 0;
            for (char c : chars) {
                if (Character.isDigit(c)) {dig++;}
                if (Character.isUpperCase(c)) {zag++;}
                if (Character.isLowerCase(c)) {pro++;}
            }
            return dig > 0 && zag > 0 && pro > 0;
        }
        else {
            return false;
        }
    }
}



class Helper_Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine().trim();
        String input = scanner.nextLine().trim();

        List<Character> left = new ArrayList<>();
        List<Character> right = new ArrayList<>();

        Pattern pattern = Pattern.compile("<delete>|<bspace>|<left>|<right>|[a-z]");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String match = matcher.group();
            switch (match) {
                case "<delete>":
                    if (!right.isEmpty()) {
                        right.remove(right.size() - 1);
                    }
                    break;
                case "<bspace>":
                    if (!left.isEmpty()) {
                        left.remove(left.size() - 1);
                    }
                    break;
                case "<left>":
                    if (!left.isEmpty()) {
                        right.add(left.remove(left.size() - 1));
                    }
                    break;
                case "<right>":
                    if (!right.isEmpty()) {
                        left.add(right.remove(right.size() - 1));
                    }
                    break;
                default:
                    left.add(match.charAt(0));
            }
        }
        StringBuilder result = new StringBuilder();
        for (char c : left) {
            result.append(c);
        }
        for (int i = right.size() - 1; i >= 0; i--) {
            result.append(right.get(i));
        }
        if (word.equals(result.toString())) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        scanner.close();
    }
}