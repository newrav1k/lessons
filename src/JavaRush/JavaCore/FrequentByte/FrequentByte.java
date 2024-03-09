package JavaRush.JavaCore.FrequentByte;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FrequentByte {
    public static Map<Integer, Integer> integerMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream stream = new FileInputStream(reader.readLine())) {
            while (stream.available() > 0) {
                int data = stream.read();
                if (integerMap.containsKey(data)) {
                    int value = integerMap.get(data);
                    integerMap.put(data, ++value);
                } else {
                    integerMap.put(data, 1);
                }
            }
            Set<Map.Entry<Integer, Integer>> entries = integerMap.entrySet();
            StringBuilder builder = new StringBuilder();
            entries.stream().sorted((s1, s2) -> s2.getValue() - s1.getValue())
                    .filter(integerIntegerEntry ->
                            integerIntegerEntry.getValue() >= entries.stream().min((s1, s2)
                                    -> s2.getValue() - s1.getValue()).get().getValue())
                    .forEach(integerIntegerEntry -> builder.append(integerIntegerEntry.getKey() + " "));
            //entries.forEach(System.out::println);
            System.out.println(builder);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}