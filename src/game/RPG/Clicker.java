package game.RPG;

public class Clicker extends AbstractEnemy implements Runnable {
    private static Clicker clicker = new Clicker(100, 14); // Щелкун

    private Clicker(int health, int damage) {
        super(health, damage);
    }

    public static Clicker getInstance() {
        return clicker;
    }

    @Override
    public void fight(AbstractHero hero) {
        super.fight(hero);
    }

    @Override
    public void heal() {
        super.heal();
    }

    @Override
    public boolean defend(AbstractHero hero) {
        return super.defend(hero);
    }

    @Override
    public void run() {

    }
}
