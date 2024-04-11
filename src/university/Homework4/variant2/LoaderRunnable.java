package university.Homework4.variant2;

import java.io.*;

public class LoaderRunnable implements Runnable {
    private final String path;

    public LoaderRunnable(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        if (this.path != null && new File(this.path).exists()) {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
                Message message = (Message) input.readObject();
                System.out.println(message);
            } catch (IOException | ClassNotFoundException exception) {
                System.out.println("Что-то пошло не так с загрузкой из файла - " + path);
            }
        }
    }
}