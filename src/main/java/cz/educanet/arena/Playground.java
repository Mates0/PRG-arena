package cz.educanet.arena;

import cz.educanet.arena.logic.Arena;
import cz.educanet.arena.logic.Gladiator;

import java.util.Scanner;

/**
 * This is just a playground class... You can create new gladiators and persist them ect.
 */
public class Playground {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gladiator gladiator1 = new Gladiator();
        Gladiator gladiator2 = new Gladiator();
        Arena logic = new Arena();
        System.out.println("Zadej jméno prvního gladiátora: ");
        gladiator1.setName(sc.nextLine());
        System.out.println("Zadej jméno druhého gladiátora: ");
        gladiator2.setName(sc.nextLine());
        System.out.println("Zadej počet životů prvního gladiátora: ");
        gladiator1.setHp(sc.nextInt());
        System.out.println("Zadej počet životů druhého gladiátora: ");
        gladiator2.setHp(sc.nextInt());
        System.out.println("Zadej minimalni/maximální poškození prvního gladiátora: ");
        gladiator1.mindmg = sc.nextInt();
        gladiator1.maxdmg = sc.nextInt();
        System.out.println("Zadej minimalni/maximální poškození druhého gladiátora: ");
        gladiator2.mindmg = sc.nextInt();
        gladiator2.maxdmg = sc.nextInt();
        logic.setGladiator1(gladiator1);
        logic.setGladiator2(gladiator2);
        float onehp1 = (float) gladiator1.getHp() / 20;
        float onehp2 = (float) gladiator2.getHp() / 20;
        String health1 = "";
        String health2 = "";
        while (logic.getWinner() == null) {
            float a = gladiator1.getHp() / onehp1;
            float b = gladiator2.getHp() / onehp2;
            for (int i = 0; i < a; i++) {
                health1 += "#";
            }
            for (int i = 0; i < b; i++) {
                health2 += "#";
            }
            logic.fight();
            System.out.println("------------------------" + logic.getRound() + ". kolo -------------");
            System.out.println("Zdraví bojovníků: ");
            System.out.println(gladiator2.getName() + ":[" + health2 + "]");
            System.out.println(gladiator1.getName() + ":[" + health1 + "]");
            System.out.println(gladiator1.getName() + " " + "útočí s úderem za" + " " +  logic.getGladiator1().getDamage() + "hp");
            System.out.println(gladiator2.getName() + " " + "útočí s úderem za" + " " +  logic.getGladiator2().getDamage() + "hp");
            health1 = "";
            health2 = "";
        }
        if (logic.getWinner() == gladiator1) {
            System.out.println("Vyhrává" + " " + gladiator1.getName());
            System.exit(0);
        }
        if (logic.getWinner() == gladiator2) {
            System.out.println("Vyhrává" + " " + gladiator2.getName());
            System.exit(0);
        }
    }
}
