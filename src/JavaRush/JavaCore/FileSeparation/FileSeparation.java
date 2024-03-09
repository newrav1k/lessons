package JavaRush.JavaCore.FileSeparation;

import java.io.*;

/*
Разделение файла
*/

public class FileSeparation {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String name1 = reader.readLine();
            String name2 = reader.readLine();
            String name3 = reader.readLine();
            try (FileInputStream stream1 = new FileInputStream(name1);
                 FileOutputStream stream2 = new FileOutputStream(name2);
                 FileOutputStream stream3 = new FileOutputStream(name3)) {
                byte[] buffer = new byte[1024];
                while (stream1.available() > 0) {
                    int count = stream1.read(buffer);
                    if (count % 2 == 0) {
                        stream2.write(buffer, 0, count / 2);
                        stream3.write(buffer, count / 2, count / 2);
                    } else {
                        stream2.write(buffer, 0, count / 2 + 1);
                        stream3.write(buffer, count / 2 + 1, count / 2);
                    }
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
