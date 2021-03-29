package cz.educanet.arena.logic;

import java.util.Random;

public class Gladiator {
    /**
     * Name of the gladiator
     */
    private String name;
    public int hp;
    public int damage;
    public int maxdmg;
    public int mindmg;

    /**
     * @return true if hp is <= 0, else false
     */
    public boolean isDead() {
        return hp <= 0;
    }

    /**
     * Generates a random value between min. damage and max. damage and deals it to the enemy.
     * @param enemy Enemy gladiator
     */
    public void dealDamage(Gladiator enemy) {
        Random rand = new Random();
        damage = rand.nextInt(maxdmg - mindmg) + mindmg;
        enemy.setHp(enemy.getHp() - damage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setMindmg(int mindmg) {
        this.mindmg = mindmg;
    }

    public void setMaxdmg(int maxdmg) {
        this.maxdmg = maxdmg;
    }

    public int getMindmg() {
        return mindmg;
    }

    public int getMaxdmg() {
        return maxdmg;
    }
}
