package game.RPG;

public class Devourer extends AbstractEnemy implements Runnable {

    private static final Devourer devourer = new Devourer(300, 45); // Пожиратель
    public Devourer(int health, int damage) {
        super(health, damage);
    }

    public static Devourer getInstance() {
        return devourer;
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
