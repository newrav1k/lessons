package university.Homework4.variant3;

import java.util.Scanner;

// C:\Users\OlegK\OneDrive\Рабочий стол\input.txt

public class DoctorApplication {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Doctor addDoctor() {
        Doctor doctor = new Doctor();
        System.out.println("Введите по очереди данные врача: \nИмя - ");
        doctor.setName(SCANNER.nextLine());
        System.out.println("Профессия - ");
        doctor.setProfessional(SCANNER.nextLine());

        System.out.println("Порядковый номер - ");
        int number = 0;
        while (!(number > 0)) {
            try {
                number = Integer.parseInt(SCANNER.nextLine());
                doctor.setNumber(number);
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }

        System.out.println("Количество рабочих смен - ");
        int days = 0;
        while (!(days > 0)) {
            try {
                days = Integer.parseInt(SCANNER.nextLine());
                doctor.setDays(days);
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
        System.out.println("Отметка о прохождении аттестации - ");
        String isCertification = SCANNER.nextLine();
        doctor.setCertification(isCertification);

        return doctor;
    }

    public static void start() throws InterruptedException {
        System.out.println("""
            Выполнил работу: Крицкий Кирилл
            Группа: РИБО-04-22
            Вариант: 13 \n""");
        Doctor doctor = addDoctor();

        System.out.println("Введите путь к файлу: ");
        String path = SCANNER.nextLine();

        SaverRunnable saverRunnable = new SaverRunnable(doctor, path);
        LoaderRunnable loaderRunnable = new LoaderRunnable(path);

        Thread save = new Thread(saverRunnable, "save");
        Thread load = new Thread(loaderRunnable, "load");

        save.start();
        save.join();
        load.start();
        load.join();
    }

    public static void main(String[] args) throws InterruptedException {
        start();
    }
}