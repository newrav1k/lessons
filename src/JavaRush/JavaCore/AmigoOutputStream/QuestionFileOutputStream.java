package JavaRush.JavaCore.AmigoOutputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream original;

    public QuestionFileOutputStream(AmigoOutputStream original) {
        this.original = original;
    }

    @Override
    public void flush() throws IOException {
        original.flush();
    }

    @Override
    public void write(int b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String message = reader.readLine();
        if (message.equals("Д")) {
            original.close();
        }
    }
}
