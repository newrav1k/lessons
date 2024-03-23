package university.Homework4.variant3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class LoaderRunnable implements Runnable {
    private String path;

    public LoaderRunnable(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        if (this.path != null) {
            try (ObjectInput input = new ObjectInputStream(new FileInputStream(path))) {
                Doctor doctor = new Doctor();
                doctor.readExternal(input);
                System.out.printf("Объект доктор: %s", doctor);
            } catch (IOException | ClassNotFoundException exception) {
                throw new RuntimeException(exception);
            }
        }
    }
}