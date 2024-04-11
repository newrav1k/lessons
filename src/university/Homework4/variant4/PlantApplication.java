package university.Homework4.variant4;

import java.util.Scanner;

public class PlantApplication {
    public static void main(String[] args) {
        Plant plant = new Plant("аоао", "rus", 5, 12, true);

        SaverRunnable saverRunnable = new SaverRunnable(plant, new Scanner(System.in).nextLine());
        Thread save = new Thread(saverRunnable, "save");

        save.start();
    }
}