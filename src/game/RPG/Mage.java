package game.RPG;

public class Mage extends AbstractHero implements Runnable {

    private static Mage mage = new Mage(100, 50);

    private Mage(int health, int mana) {
        this.health = health;
        this.mana = armor;
    }

    public static Mage getInstance() {
        return mage;
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
                System.out.println(this.getClass().getSimpleName() + "Отдыхает...");
                Thread.sleep(150);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

}
