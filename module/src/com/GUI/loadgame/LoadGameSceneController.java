package com.GUI.loadgame;

import com.GUI.SceneController;
import com.game.Item;
import com.game.Player;
import com.map.Map;
import com.readjson.ReadItemContentJson;
import com.replay.LoadGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadGameSceneController {
    private Map map = new Map();
    private Player jemad = new Player();


    @FXML
    public void initialize() {

    }

    @FXML
    public void doNotLoadGameBtnActionEvent(ActionEvent event) throws IOException {
        // scene controller
        SceneController.switchScenesBaseOnBtnClick(event);
    }

    @FXML
    public void loadGameBtnActionEvent(ActionEvent event) throws IOException {

        ArrayList<Object> attributes = new ArrayList<>();

        try{
            BufferedReader saveFile = new BufferedReader(new FileReader("savedGame.txt"));
            int playerHP = Integer.parseInt(saveFile.readLine());
            String currentLocation = saveFile.readLine();
            int minDamage = Integer.parseInt(saveFile.readLine());
            int maxDamage = Integer.parseInt(saveFile.readLine());
            int itemCount = 0;
            ArrayList<String> listOfItems = new ArrayList<String>();
            String nextLine = saveFile.readLine();
            while (nextLine != null){
                itemCount += 1;
                listOfItems.add(nextLine);
                nextLine = saveFile.readLine();
            }

            //adding attributes to ArrayList
            attributes.add(playerHP);
            attributes.add(currentLocation);
            attributes.add(minDamage);
            attributes.add(maxDamage);
            if (listOfItems.size() > 0){
                for (String item: listOfItems){
                    attributes.add(item);
                }
            }

            //closing saved file
            saveFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (Exception e){
            System.out.println("Could not load saved game attributes");
        }

        //Reading Attributes from save file
        ArrayList<Object> savedGameArray = LoadGame.loadAttributesFromSaveGameFile();
        int savedGameArraySize = savedGameArray.size();
        int numOfItems = savedGameArraySize - 4;
        jemad.setHp((Integer) savedGameArray.get(0));
        String startingLocation = (String) savedGameArray.get(1);
        jemad.setMinDamage((Integer) savedGameArray.get(2));
        jemad.setMaxDamage((Integer) savedGameArray.get(3));
        int itemIndex = 4;
        while (numOfItems > 0){
            String itemString = (String) savedGameArray.get(itemIndex);
            JSONObject jsonItemObject = ReadItemContentJson.getItemBasedOnItemName(itemString);
            String itemName = (String) jsonItemObject.get("name");
            Item newItem = new Item(itemName);
            jemad.addItemJson(newItem);
            itemIndex += 1;
            numOfItems -= 1;
        }

        //Put player in room they left off from
        jemad.setCurrentLocation(startingLocation);

        //Go Back to main Screen
        SceneController.switchScenesBaseOnBtnClick(event);

    }

    @FXML
    public void loadGameBtnOkActionEvent(ActionEvent event) throws IOException {
        // scene controller
        SceneController.switchScenesBaseOnBtnClick(event);
    }


}
