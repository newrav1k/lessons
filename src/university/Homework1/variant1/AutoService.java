package university.Homework1.variant1;

/*
Вариант 1. Для работы с сущностью АВТОМОБИЛЬ (Car) разработать класс
АВТОСЕРВИС, в котором метод modify будет изменять название (марку)
автомобиля по следующему алгоритму:
         Все символы «a» должны быть заменены на «o»
         Все символы «i» должны быть заменены на «e»
         Все символы должны быть прописными
Начальные значения полей для сущности АВТОМОБИЛЬ вводит
пользователь с клавиатуры после старта программы. В результате работы
программы необходимо вывести на экран все значения полей (в том числе
        измененное) через запятую.
*/

import java.util.Scanner;

public class AutoService {

    private static final String MESSAGE =
            """
            Выполнил работу: Крицкий Кирилл
            Группа: РИБО-04-22
            Вариант: 13
            """;

    public static void modify(Car car) {
        String name = car.getName();
        car.setName(name.toUpperCase().replaceAll("A", "O")
                .replaceAll("I", "E"));
    }

    public static void start() {
        System.out.println(MESSAGE + "\nВведите марку автомобиля: ");
        Scanner scanner = new Scanner(System.in);
        Car car = new Car(scanner.nextLine());
        modify(car);
        System.out.println(car);
    }

    public static void main(String[] args) {
        start();
    }
}