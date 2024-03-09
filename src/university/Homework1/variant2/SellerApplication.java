package university.Homework1.variant2;

import java.util.Scanner;

public class SellerApplication {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Seller SELLER = new Seller();
    private static final Telephone TELEPHONE;
    private static final String MESSAGE =
            """
            Выполнил работу: Крицкий Кирилл
            Группа: РИБО-04-22
            Вариант: 13
            """;

    static {
        System.out.println(MESSAGE + "\nВведите название производителя: ");
        TELEPHONE = new Telephone(SCANNER.nextLine());
    }

    public static void start() {
        SELLER.modify(TELEPHONE);
        System.out.println(TELEPHONE);
    }

    public static void main(String[] args) {
        start();
    }
}