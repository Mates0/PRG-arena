package cz.educanet.arena.presentation;

import cz.educanet.arena.data.GladiatorDatabase;
import cz.educanet.arena.logic.Arena;
import cz.educanet.arena.logic.Gladiator;

import java.util.Scanner;

public class ArenaCLI {

    private Arena logic;
    private Scanner sc;

    /**
     * Initialize all variables that are needed.
     */
    public void init() {
        logic = new Arena();
        sc = new Scanner(System.in);
    }

    public void renderLandingPage() {
        System.out.println("     /\\                         \n" +
                "    /  \\   _ __ ___ _ __   __ _ \n" +
                "   / /\\ \\ | '__/ _ \\ '_ \\ / _` |\n" +
                "  / ____ \\| | |  __/ | | | (_| |\n" +
                " /_/    \\_\\_|  \\___|_| |_|\\__,_|");
        System.out.println("---------------------------------");
    }

    public void renderGladiatorPicker() {
        Gladiator gladiator1 = new Gladiator();
        Gladiator gladiator2 = new Gladiator();
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
        sc.nextLine();
        GladiatorDatabase.saveGladiator(gladiator1.getName() + ".txt", gladiator1);
        GladiatorDatabase.saveGladiator(gladiator2.getName() + ".txt", gladiator2);
        System.out.println("Pick your fighter #1 (enter the path of the saved file):");
        String gladiator1File = sc.nextLine();
        System.out.println("Pick your fighter #2 (enter the path of the saved file):");
        String gladiator2File = sc.nextLine();

        gladiator1 = GladiatorDatabase.loadGladiator(gladiator1File);
        gladiator2 = GladiatorDatabase.loadGladiator(gladiator2File);
        logic.setGladiator1(gladiator1);
        logic.setGladiator2(gladiator2);
    }

    /**
     * Fight until one gladiator dies, or surrenders.
     */
    public void renderEntireFight() {
        float onehp1 = (float)logic.getGladiator1().getHp() / 20;
        float onehp2 = (float)logic.getGladiator2().getHp() / 20;
        String health1 = "";
        String health2 = "";
        while (logic.getWinner() == null) {
            logic.fight();
            float a = logic.getGladiator1().getHp() / onehp1;
            float b = logic.getGladiator2().getHp() / onehp2;
            for (int i = 0; i < a; i++) {
                health1 += "#";
            }
            for (int i = 0; i < b; i++) {
                health2 += "#";
            }
            System.out.println("------------------------" + logic.getRound() + ". kolo -------------");
            System.out.println("Zdraví bojovníků: ");
            System.out.println(logic.getGladiator2().getName() + ":[" + health2 + "]");
            System.out.println(logic.getGladiator1().getName() + ":[" + health1 + "]");
            System.out.println(logic.getGladiator1().getName() + " " + "útočí s úderem za" + " " + logic.getGladiator1().getDamage() + "hp");
            System.out.println(logic.getGladiator2().getName() + " " + "útočí s úderem za" + " " + logic.getGladiator2().getDamage() + "hp");
            health1 = "";
            health2 = "";
            if (logic.getWinner() == logic.getGladiator1()) {
                System.out.println("Vyhrává" + " " + logic.getGladiator1().getName());
                System.exit(0);
            }
            if (logic.getWinner() == logic.getGladiator2()) {
                System.out.println("Vyhrává" + " " + logic.getGladiator2().getName());
                System.exit(0);
            }
        }
    }
}

