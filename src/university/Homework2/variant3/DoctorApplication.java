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
    private static final String MESSAGE = """
            Выполнил работу: Крицкий Кирилл
            Группа: РИБО-04-22
            Вариант: 13
            """;

    private static void doctorsPrint() {
        System.out.println("\nВывожу список врачей...\n");
        DOCTORS.sort(Doctor::compareTo);
        DOCTORS.forEach(System.out::println);
    }

    public static void addDoctor() {
        Doctor doctor = new Doctor();
        System.out.println("Введите по очереди данные врача: \nИмя - ");
        doctor.setName(SCANNER.nextLine());
        System.out.println("Профессия - ");
        doctor.setProfessional(SCANNER.nextLine());

        System.out.println("Порядковый номер - ");
        int number = 0;
        while (!(number > 0 && DoctorApplication.isExistingNumber(number))) {
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

        DOCTORS.add(doctor);
        doctorsPrint();
    }

    protected static boolean isExistingNumber(int number) {
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
        System.out.printf("""
                %s
                Выберите, что хотите сделать :
                1 - добавить нового доктора
                2 - уведомить о прохождении доктором аттестации
                3 - вывести список докторов
                4 - закончить ввод \n""", MESSAGE);
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