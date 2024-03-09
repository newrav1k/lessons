package game.RPG;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEnemy implements Enemy {
    protected int health;
    protected int damage;
    private static final List<AbstractEnemy> enemies = new ArrayList<>() {{
        add(Clicker.getInstance());
        add(Devourer.getInstance());
        add(Guardian.getInstance());
    }};

    public AbstractEnemy(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    @Override
    public void fight(AbstractHero hero) {
        while (hero.health != 0) {
            hero.health -= this.damage;
            try {
                Thread.sleep(150);
            } catch (InterruptedException exception) {
                System.out.println(this.getClass().getSimpleName() + "Отдыхает");
            }
        }
    }

    @Override
    public void heal() {
        try {
            Thread.sleep(10000);
            this.health += 5;
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public boolean defend(AbstractHero hero) {
        int random = (int) (Math.random() * 100);
        if (this instanceof Clicker && random < 25) {
            System.out.printf("%s отразил удар %s", this.getClass().getSimpleName(), hero.getClass().getSimpleName());
            return true;
        } else if (this instanceof Guardian && random < 50) {
            System.out.printf("%s отразил удар %s", this.getClass().getSimpleName(), hero.getClass().getSimpleName());
            return true;
        } else if (this instanceof Devourer && random < 65) {
            System.out.printf("%s отразил удар %s", this.getClass().getSimpleName(), hero.getClass().getSimpleName());
            return true;
        }
        return false;
    }

    public static AbstractEnemy takeEnemy() {
        return enemies.get((int) (Math.random() * 2));
    }

}
