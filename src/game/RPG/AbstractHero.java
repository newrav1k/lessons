package game.RPG;


public abstract class AbstractHero implements Hero {
    protected int health;
    protected int mana;
    protected int armor;
    protected int damage;

    @Override
    public void heal(FirstAidKit firstAidKit) {
        assert health <= 100;
        if (firstAidKit.ordinal() == 0) {
            health += 25;
        } else if (firstAidKit.ordinal() == 1) {
            health += 60;
        } else {
            health += 90;
        }
    }

    @Override
    public boolean defend(AbstractEnemy enemy) {
        int random = (int) (Math.random() * 100);
        if (this instanceof Knight && random < 25) {
            System.out.printf("%s отразил удар %s", this.getClass().getSimpleName(), enemy.getClass().getSimpleName());
            return true;
        } else if (this instanceof Mage && random < 50) {
            System.out.printf("%s отразил удар %s", this.getClass().getSimpleName(), enemy.getClass().getSimpleName());
            return true;
        } else if (this instanceof Archer && random < 65) {
            System.out.printf("%s отразил удар %s", this.getClass().getSimpleName(), enemy.getClass().getSimpleName());
            return true;
        }
        return false;
    }

    /*public static class Leg {

    }

    public static class Hand {

    }

    public static class Head {

    }*/
}
