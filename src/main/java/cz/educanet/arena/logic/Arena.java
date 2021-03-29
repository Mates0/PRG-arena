package cz.educanet.arena.logic;

/**
 * Represents the arena.
 */
public class Arena {

    private Gladiator gladiator1;
    private Gladiator gladiator2;
    /**
     * Represents the current round. This property is incremented each round.
     */
    private int round;

    /**
     * Makes the gladiators fight one round.
     */
    public void fight() {
        if (!gladiator1.isDead())
            gladiator1.dealDamage(gladiator2);

        if (!gladiator2.isDead())
            gladiator2.dealDamage(gladiator1);

        round++;
    }

    /**
     * @return the winner, null if none.
     */
    public Gladiator getWinner() {
        if (gladiator1.isDead())
            return gladiator2;

        if (gladiator2.isDead())
            return gladiator1;

        return null;
    }

    public void setGladiator1(Gladiator gladiator1) {
        this.gladiator1 = gladiator1;
    }

    public void setGladiator2(Gladiator gladiator2) {
        this.gladiator2 = gladiator2;
    }

    public Gladiator getGladiator1() {
        return gladiator1;
    }

    public Gladiator getGladiator2() {
        return gladiator2;
    }

    public int getRound() {
        return round;
    }
}
