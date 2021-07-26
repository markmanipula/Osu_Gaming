package com.replay;

import com.game.Player;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Set;


public class SaveGame {

    public static void save(Player player) {
        int hp = player.getHp();
        String currentLocation = player.getCurrentLocation();
        int minDamage = player.getMinDamage();
        int maxDamage = player.getMaxDamage();
        Set<String> playerItems = player.getPlayerItems();


        try {
            BufferedWriter saveTest = new BufferedWriter(new FileWriter("saveTest.txt"));
            saveTest.write("" + hp);
            saveTest.newLine();
            saveTest.write(currentLocation);
            saveTest.newLine();
            saveTest.write("" + minDamage);
            saveTest.newLine();;
            saveTest.write("" + maxDamage);
            saveTest.newLine();

            for (String items: playerItems){
                saveTest.write(items);
                saveTest.newLine();
            }

            saveTest.close();

        }
        catch (Exception e){
            System.out.println("Can't save file");
        }
    }
}
