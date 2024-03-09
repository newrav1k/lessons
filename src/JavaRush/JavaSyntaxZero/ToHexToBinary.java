package JavaRush.JavaSyntaxZero;

import java.util.Optional;

public class ToHexToBinary {

    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        String binaryNumber = "11010111";
        System.out.println("Двоичное число " + binaryNumber +
                " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "d7";
        System.out.println("Шестнадцатеричное число " + hexNumber +
                " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        String result = "";
        int[] find = {0, 1};
        if (binaryNumber == null) {
            return result;
        } else {
            for (int i = 0; i < binaryNumber.length(); i++) {
                if (Character.getNumericValue(binaryNumber.charAt(i)) != find[0] &&
                        Character.getNumericValue(binaryNumber.charAt(i)) != find[1]) {
                    return result;
                }
            }
            binaryNumber = divFour(binaryNumber);
            for (int i = binaryNumber.length() - 1; i >= 0; i -= 4) {
                int value = 0, count = 0;
                for (int j = i; j > i - 4; j--) {
                    value += Character.getNumericValue(binaryNumber.charAt(j)) * Math.pow(2, count++);
                }
                result = HEX.charAt(value) + result;
            }
        }
        return result;
    }

    public static String toBinary(String hexNumber) {
        final int len = hexNumber.length();
        String result = "";
        Optional<String> optional = Optional.ofNullable(hexNumber);
        if (!optional.isPresent()) {
            return result;
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < HEX.length(); j++) {
                if (hexNumber.charAt(i) == HEX.charAt(j)) {
                    count++;
                }
            }
        }
        if (count == len) {
            return Binary(hexNumber);
        } else {
            return result;
        }
    }

    private static String divFour(String message) {
        final int len = message.length() % 4;
        if (len != 0) {
            return ("0".repeat((4 - len)) + message);
        } else {
            return message;
        }
    }

    private static String Binary(String message) {
        String result = "";
        for (int i = message.length() - 1; i >= 0; i--) {
            int value = Character.getNumericValue(message.charAt(i));
            if (value == 0) {
                result = "0".repeat(4) + result;
            }
            while (value > 0) {
                result = value % 2 + result;
                value /= 2;
            }
            result = divFour(result);
        }
        return result;
    }

}