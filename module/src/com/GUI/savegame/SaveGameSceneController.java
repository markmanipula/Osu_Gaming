package com.GUI.savegame;

import com.GUI.SceneController;
import com.game.Item;
import com.game.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveGameSceneController {
    private Player jemad = new Player();


    @FXML
    public void initialize() {

    }

    @FXML
    public void doNotSaveGameBtnActionEvent(ActionEvent event) throws IOException {
        // scene controller
        SceneController.switchScenesBaseOnBtnClick(event);
    }

    @FXML
    public void saveGameBtnActionEvent(ActionEvent event) throws IOException {
        int hp = jemad.getHp();
        String currentLocation = jemad.getCurrentLocation();
        int minDamage = jemad.getMinDamage();
        int maxDamage = jemad.getMaxDamage();
        ArrayList<Item> jemadInventory = jemad.getInventory();

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

            for (Item items: jemadInventory){
                savedGame.write(items.getItemName());
                savedGame.newLine();
            }

            savedGame.close();

        }
        catch (Exception e){
            System.out.println("Can't save file");
        }


        // Back to scene controller to close out game
        SceneController.switchScenesBaseOnBtnClick(event);
    }

    @FXML
    public void saveGameBtnSuccessActionEvent(ActionEvent event) throws IOException {
        // scene controller
        SceneController.switchScenesBaseOnBtnClick(event);
    }

}
