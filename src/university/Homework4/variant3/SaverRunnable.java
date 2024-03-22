package university.Homework4.variant3;

import java.io.*;

public class SaverRunnable implements Runnable {
    private Doctor doctor;
    private String path;

    public SaverRunnable(Doctor doctor, String path) {
        this.doctor = doctor;
        this.path = path;
    }

    @Override
    public void run() {
        if (this.doctor != null && this.path != null) {
            try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream(path))) {
                doctor.writeExternal(output);
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        }
    }
}