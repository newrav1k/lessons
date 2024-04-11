package university.Homework4.variant4;

import java.io.*;

public class SaverRunnable implements Runnable {
    private final Plant plant;
    private final String path;

    public SaverRunnable(Plant plant, String path) {
        this.plant = plant;
        this.path = path;
    }

    @Override
    public void run() {
        if (path != null && plant != null) {
            try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream(path))) {
                plant.writeExternal(output);
            } catch (IOException exception) {
                System.out.println("При записи объекта в файл произошла ошибка");
            }
        }
    }
}