package game.RPG;

public class Guardian extends AbstractEnemy implements Runnable {
    private static final Guardian guardian = new Guardian(150, 25); // Хранитель

    public Guardian(int health, int damage) {
        super(health, damage);
    }

    public static Guardian getInstance() {
        return guardian;
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
