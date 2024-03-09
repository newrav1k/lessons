package game.RPG;

public interface Hero {
    void fight(AbstractEnemy enemy) throws InterruptedException;

    void heal(FirstAidKit firstAidKit);

    boolean defend(AbstractEnemy enemy);
}
