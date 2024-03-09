package game.RPG;

public interface Enemy {
    void fight(AbstractHero hero);

    void heal();

    boolean defend(AbstractHero hero);
}
