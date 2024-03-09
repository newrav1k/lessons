package game.RPG;

import java.util.ArrayList;
import java.util.List;

class Knight extends AbstractHero implements Runnable {

    private static final Knight knight = new Knight(100, 50, 25);
    private List<FirstAidKit> firstAidKits = new ArrayList<>();

    private Knight(int health, int armor, int damage) {
        this.health = health;
        this.armor = armor;
        this.damage = damage;
    }

    public static Knight getInstance() {
        return knight;
    }

    public void takeHeal() {
        int random = (int) (Math.random() * 3);
        super.heal(firstAidKits.get(random));
    }

    @Override
    public void run() {
        AbstractEnemy enemy = (AbstractEnemy) Game.battleRoom.get("Enemy");
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