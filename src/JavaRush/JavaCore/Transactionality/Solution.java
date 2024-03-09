package JavaRush.JavaCore.Transactionality;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws CorruptedDataException {
        Solution solution = new Solution();
        solution.joinData();
    }

    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String name1 = reader.readLine();
            String name2 = reader.readLine();
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name1))) {
                while (bufferedReader.ready()) {
                    allLines.add(bufferedReader.readLine());
                }
            }
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name2))) {
                while (bufferedReader.ready()) {
                    forRemoveLines.add(bufferedReader.readLine());
                }
            }
        } catch (CorruptedDataException exception) {
            exception.printStackTrace();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void joinData() throws CorruptedDataException {
        if (forRemoveLines.containsAll(allLines)) { // allLines.stream().allMatch(forRemoveLines.get(0)::contains)
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
