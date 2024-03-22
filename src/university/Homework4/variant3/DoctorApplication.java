package university.Homework4.variant3;

import java.util.Scanner;

/*Вариант 3. Разработать программу для сохранения объекта класса ВРАЧ
        (Doctor). Обязательные требования к программе:
        ✓  Заполнение полей класса должно осуществляется пользователем после
старта программы.
        ✓  Класс должен содержать минимум 5 полей (переменных класса).
        ✓  Файл должен быть сохранен в корневой директории локального диска C
        (название и расширение – любое).
        ✓  Процедура сериализации должна быть реализована в отдельном потоке.
В результате работы программы необходимо вывести в консоль путь к
сохраненному файлу.*/

public class DoctorApplication {

    private static final Scanner scanner = new Scanner(System.in);

    public static Doctor addDoctor() {
        Doctor doctor = new Doctor();
        System.out.println("Введите по очереди данные врача: \nИмя - ");
        doctor.setName(scanner.nextLine());
        System.out.println("Профессия - ");
        doctor.setProfessional(scanner.nextLine());

        System.out.println("Порядковый номер - ");
        int number = 0;
        while (!(number > 0)) {
            try {
                number = Integer.parseInt(scanner.nextLine());
                doctor.setNumber(number);
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }

        System.out.println("Количество рабочих смен - ");
        int days = 0;
        while (!(days > 0)) {
            try {
                days = Integer.parseInt(scanner.nextLine());
                doctor.setDays(days);
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
        System.out.println("Отметка о прохождении аттестации - ");
        String isCertification = scanner.nextLine();
        doctor.setCertification(isCertification);

        return doctor;
    }

    public static void start() throws InterruptedException {
        Doctor doctor = addDoctor();

        System.out.println("Введите путь к файлу: ");
        String path = scanner.nextLine();

        SaverRunnable saverRunnable = new SaverRunnable(doctor, path);
        Thread save = new Thread(saverRunnable, "save");

        save.start();
    }

    public static void main(String[] args) throws InterruptedException {
        start();
    }
}