package game.RPG;

public class Archer extends AbstractHero implements Runnable {

    private static Archer archer = new Archer(100, 50);

    private Archer(int health, int mana) {
        this.health = health;
        this.mana = armor;
    }

    public static Archer getInstance() {
        return archer;
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
    }

    @Override
    public void fight(AbstractEnemy enemy) {
        while (enemy.health != 0) {
            enemy.health -= this.damage;
            try {
                System.out.println(this.getClass().getSimpleName() + "Отдыхает");
                Thread.sleep(150);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

}
