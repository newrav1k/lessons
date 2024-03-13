package university.Homework2.variant3;

import java.util.ArrayList;
import java.util.Scanner;

public class DoctorApplication {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ArrayList<Doctor> DOCTORS = new ArrayList<>() {{
        add(new Doctor("Антонов Антон Антонович", "Терапевт", 345, 15, false));
        add(new Doctor("Иванов Иван Иванович", "Хирург", 95, 20, false));
        add(new Doctor("Юрьев Юрий Аристархович", "Офтальмолог", 75, 10, false));
    }};

    private static void doctorsPrint() {
        DOCTORS.sort(Doctor::compareTo);
        DOCTORS.forEach(System.out::println);
    }

    public static void addDoctor() {
        System.out.println("Введите по очереди данные врача: \nИмя - ");
        String name = SCANNER.nextLine();
        System.out.println("Профессия - ");
        String professional = SCANNER.nextLine();
        System.out.println("Порядковый номер - ");
        int number;
        while (true) {
            number = Integer.parseInt(SCANNER.nextLine());
            if (!(number >= 0 && isExistingNumber(number))) {
                System.out.println("Вы ввели отрицательное число или такой врач уже существует!");
            } else {
                break;
            }
        }
        System.out.println("Количество рабочих смен - ");
        int days;
        while (true) {
            days = Integer.parseInt(SCANNER.nextLine());
            if (days > 0) {
                break;
            } else {
                System.out.println("Вы ввели отрицательное число!");
            }
        }
        System.out.println("Отметка о прохождении аттестации - ");
        boolean isCertification = Boolean.parseBoolean(SCANNER.nextLine());

        DOCTORS.add(new Doctor(name, professional, number, days, isCertification));
        doctorsPrint();
    }

    private static boolean isExistingNumber(int number) {
        for (Doctor doctor : DOCTORS) {
            if (doctor.getNumber() == number) {
                return false;
            }
        }
        return true;
    }

    public static void changeCertification(int number) {
        DOCTORS.forEach(doctor -> {
            if (doctor.getNumber() == number) {
                doctor.setCertification(true);
            }
        });
        doctorsPrint();
    }

    public static void start() {
        System.out.print("""
                    Выберите, что хотите сделать :
                    1 - добавить нового доктора
                    2 - уведомить о прохождении доктором аттестации
                    3 - вывести список докторов
                    4 - закончить ввод \n""");
        while (true) {
            String message = SCANNER.nextLine();
            switch (message) {
                case "1" -> addDoctor();
                case "2" -> {
                    System.out.println("Укажите порядковый номер доктора");
                    changeCertification(Integer.parseInt(SCANNER.nextLine()));
                }
                case "3" -> doctorsPrint();
                case "4" -> {
                    System.out.println("Завершаю программу...");
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        start();
    }
}