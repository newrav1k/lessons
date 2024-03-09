package game.RPG;

import java.util.*;

public class Game {
    private static final Scanner scanner = new Scanner(System.in);
    private static AbstractHero hero;
    protected static Map<String, Object> battleRoom = new HashMap() {{
        put("Hero", hero);
        put("Enemy", null);
    }};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Knight.getInstance().defend(Clicker.getInstance());
            System.out.println(i);
        }
    }

    public static AbstractHero getHero(String message) {
        while (true) {
            try {
                switch (message) {
                    case "knight" -> {
                        return Knight.getInstance();
                    }
                    case "Mage" -> {
                        return Mage.getInstance();
                    }
                    case "Archer" -> {
                        return Archer.getInstance();
                    }
                    default -> throw new IllegalArgumentException("Выберите верного героя!");
                }
            } catch (IllegalArgumentException exception) {
                continue;
            }
        }
    }

}
