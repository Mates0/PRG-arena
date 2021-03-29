package cz.educanet.arena.data;

import cz.educanet.arena.logic.Gladiator;

import java.io.*;

/**
 * Utils class that saves and loads gladiators.
 */
public class GladiatorDatabase {


    /**
     * @param filename path to the gladiator file.
     * @return loaded Gladiator
     */
    public static Gladiator loadGladiator(String filename) {
        // TODO:
        Gladiator gladiator = new Gladiator();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            gladiator.setName(br.readLine().split(":")[1]);
            gladiator.setHp(Integer.parseInt(br.readLine().split(":")[1]));
            gladiator.setMindmg(Integer.parseInt(br.readLine().split(":")[1]));
            gladiator.setMaxdmg(Integer.parseInt(br.readLine().split(":")[1]));

            br.close();
        } catch (IOException e) {
            System.out.println("error");
        }
        return gladiator;
    }

    /**
     * Saves the gladiator.
     * @param filename path to save too.
     * @param gladiator Gladiator to save.
     */
    public static void saveGladiator(String filename, Gladiator gladiator) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write("Jméno:" + gladiator.getName());
            bw.newLine();
            bw.write("Životy:" + gladiator.getHp());
            bw.newLine();
            bw.write("Minimální poškození:" + gladiator.getMindmg());
            bw.newLine();
            bw.write("Maximální poškození:" + gladiator.getMaxdmg());
            bw.newLine();
            bw.close();
        } catch(IOException e) {
            System.out.println("error");
        }
    }

}
