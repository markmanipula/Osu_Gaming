package com.replay;

import com.game.Player;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Set;


public class SaveGame {

    public static void save(Player player) {
        int hp = player.getHp();
        String currentLocation = player.getCurrentLocation();
        int minDamage = player.getMinDamage();
        int maxDamage = player.getMaxDamage();
        Set<String> playerItems = player.getPlayerItems();

        //Will create new savedGame file if it does not exists.
        //Else it will overwrite previous save and then write to file

        try {
            File saveFile = new File("savedGame.txt");
            if (saveFile.createNewFile()) {
                System.out.println("File created: " + saveFile.getName());
            } else {
                File oldSave = new File("savedGame.txt");
                oldSave.delete();
                saveFile = new File("savedGame.txt");
                saveFile.createNewFile();
                System.out.println("File created: " + saveFile.getName());
            }
            BufferedWriter savedGame = new BufferedWriter(new FileWriter("savedGame.txt"));
            savedGame.write("" + hp);
            savedGame.newLine();
            savedGame.write(currentLocation);
            savedGame.newLine();
            savedGame.write("" + minDamage);
            savedGame.newLine();;
            savedGame.write("" + maxDamage);
            savedGame.newLine();

            for (String items: playerItems){
                savedGame.write(items);
                savedGame.newLine();
            }

            savedGame.close();

        }
        catch (Exception e){
            System.out.println("Can't save file");
        }
    }

}
