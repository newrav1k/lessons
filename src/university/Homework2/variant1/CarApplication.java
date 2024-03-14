package university.Homework2.variant1;

import java.util.ArrayList;
import java.util.Scanner;

public class CarApplication {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ArrayList<Car> CARS = new ArrayList<>() {{
        add(new Car("BMW", 2015, "x001xx"));
        add(new Car("Lada Vesta", 2020, "x002xx"));
        add(new Car("Kia Rio", 2012, "x003xx"));
    }};

    public static void addCar() {
        System.out.println("Введите марку автомобиля - ");
        String name = SCANNER.nextLine();
        int year;
        while (true) {
            System.out.println("Введите год выпуска автомобиля - ");
            try {
                year = Integer.parseInt(SCANNER.nextLine());
                if (year >= 1769){
                    break;
                } else {
                    System.out.println("Машины тогда не существовали...");
                }
            } catch (NumberFormatException exception) {
                System.out.println("Вы ввели не число...");
            }
        }
        System.out.println("Введите регистрационный номер автомобиля - ");
        String number = SCANNER.nextLine();
        CARS.add(new Car(name, year, number));
        showCars();
    }

    public static void deleteCarByNumber(String number) {
        CARS.removeIf(car -> car.getNumber().equals(number));
        showCars();
    }

    public static void clearList() {
        CARS.clear();
    }

    public static void showCars() {
        CARS.forEach(System.out::println);
    }

    public static void start() {
        System.out.println("""
                Выберите что хотите сделать :
                1 - добавить новый автомобиль
                2 - удалить автомобиль по регистрационному номеру
                3 - очистить список автомобилей
                4 - закончить ввод""");
        while (true) {
            String message = SCANNER.nextLine();
            switch (message) {
                case "1" -> addCar();
                case "2" -> {
                    System.out.println("Введите регистрационный номер автомобиля - ");
                    deleteCarByNumber(SCANNER.nextLine());
                }
                case "3" -> {
                    clearList();
                    System.out.println("Очищаю список...");
                }
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