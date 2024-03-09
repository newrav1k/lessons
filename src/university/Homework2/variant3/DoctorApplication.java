package university.Homework2.variant3;

import java.util.ArrayList;
import java.util.Scanner;

/*Вариант 3. Разработать программу для работы со списком ВРАЧЕЙ (Doctor).
Для каждого ВРАЧА содержится следующая информация: ФИО (строка),
специальность (строка), порядковый номер в списке сотрудников
(положительное число), количество рабочих смен в месяц (положительное
                                                                число), отметка о прохождении аттестации (логический тип).
Заполнить список начальными значениями (минимум 3) необходимо в коде программы.
Программа должна предоставлять пользователю две функции:
         Добавление данных нового врача в список. При этом если пользователь
пытается добавить врача с уже существующим порядковым номером,
необходимо выводить соответствующее сообщение.
         Изменение флага о прохождении аттестации для выбранного врача.
В результате работы программы после каждой операции необходимо
выводить на экран текущее содержимое списка врачей С СОРТИРОВКОЙ
        ПО ФИО, например:
Антонов Антон Антонович, терапевт, 345, 15, true
Иванов Иван Иванович, хирург, 5, 20, true
Юрьев Юрий Аристархович, офтальмолог, 65, 10, false*/

public class DoctorApplication {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ArrayList<Doctor> doctors = new ArrayList<>() {{
        add(new Doctor("Антонов Антон Антонович", "Терапевт", 345, 15, false));
        add(new Doctor("Иванов Иван Иванович", "Хирург", 95, 20, false));
        add(new Doctor("Юрьев Юрий Аристархович", "Офтальмолог", 75, 10, false));
    }};

    private static void doctorsPrint() {
        doctors.stream().sorted(Doctor::compareTo).forEach(System.out::println);
    }

    public static void addDoctor() {
        System.out.println("Введите по очереди данные врача: \nИмя - ");
        String name = SCANNER.nextLine();
        System.out.println("Профессия - ");
        String professional = SCANNER.nextLine();
        int number;
        int days;
        while (true) {
            System.out.println("Порядковый номер - ");
            number = Integer.parseInt(SCANNER.nextLine());
            if (number >= 0 && isExistingNumber(number)) {
                System.out.println("Количество рабочих смен - ");
                days = Integer.parseInt(SCANNER.nextLine());
                if (days >= 0) {
                    break;
                } else {
                    System.out.println("Вы ввели отрицательное число!\n");
                }
            } else {
                System.out.println("Вы ввели отрицательное число или такой врач уже существует!");
            }
        }
        System.out.println("Отметка о прохождении аттестации - ");
        boolean isCertification = SCANNER.nextBoolean();
        doctors.add(new Doctor(name, professional, number, days, isCertification));
        doctorsPrint();
    }

    private static boolean isExistingNumber(int number) {
        for (var doctor : doctors) {
            if (doctor.getNumber() == number) {
                return false;
            }
        }
        return true;
    }

    public static void changeCertification(int number) {
        doctors.forEach(doctor -> {
            if (doctor.getNumber() == number) {
                doctor.setCertification(true);
            }
        });
        doctorsPrint();
    }

    public static void start() {
        System.out.println("""
                Выберите что хотите сделать :
                1 - добавить нового доктора
                2 - уведомить о прохождении доктором аттестации
                3 - закончить ввод""");
        while (true) {
            try {
                String message = SCANNER.nextLine();
                switch (message) {
                    case "1" -> addDoctor();
                    case "2" -> {
                        System.out.println("(Укажите порядковый номер доктора)");
                        changeCertification(SCANNER.nextInt());
                    }
                    case "3" -> {
                        System.out.println("Завершаю программу...");
                        return;
                    }
                }
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        start();
    }
}