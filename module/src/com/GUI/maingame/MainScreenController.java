package com.GUI.maingame;

import com.GUI.SceneController;
import com.GUI.lose.LoseSceneBuilder;
import com.GUI.win.WinSceneBuilder;
import com.character.Enemy;
import com.combat.JemadCombat;
import com.game.Item;
import com.game.Player;
import com.readjson.ReadItemContentJson;
import com.readjson.ReadMoveContentJson;
import com.readjson.ReadRoomContentJson;
import com.story.StoryGenerator;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainScreenController {
    // test
    @FXML
    private AnchorPane pane;
    @FXML
    private Label incombatMessage;
    // end of test
    @FXML
    private MenuButton menuButton;
    @FXML
    private MenuItem displayMapMenuItem;
    @FXML
    private MenuItem aboutJemad;
    @FXML
    private MenuItem saveGame;
    @FXML
    private MenuItem loadGame;
    // script data
    @FXML
    private TextArea gameDescription;
    @FXML
    private MenuButton getItemMenuButton;
    @FXML
    private ListView inventoryListView;
    @FXML
    private Button userItemButton;
    @FXML
    private Label itemUserActionInfo;
    // movement buttons
    @FXML
    private Button south;
    @FXML
    private Button north;
    @FXML
    private Button east;
    @FXML
    private Button west;
    @FXML
    private Label currentLocationLabel;
    // Fight
    @FXML
    private Pane gamePane;
    @FXML
    private MenuButton fightButton;
    @FXML
    private TextArea playerFightTextArea;
    @FXML
    private ImageView jemadFacingRightImageView;
    private Image jemadFightImage;
    @FXML
    private TextArea enemyFightTextArea;
    @FXML
    private ImageView enemyFacingImageView;
    private Image enemyFightImage;
    @FXML
    private MenuButton jemadCombatMovementMenuButton;
    @FXML
    private TextArea fightCombatDialog;
    @FXML private Slider volumeSlider;
    private File directory;
    private File[] files;
    private ArrayList<File> songs;
    private int songNumber;
    private boolean running;
    private Media media;
    private MediaPlayer mediaPlayer;

    // player obj to retrieve the current location
    private Player jemad = new Player();
    // an hashmap to store the location and the enemy name
    private static HashMap<String, Enemy> DEFEATED_ENEMYLIST = new HashMap<>();
    private static ArrayList<String> OBTAINED_ITEMS = new ArrayList<>();

    @FXML
    public void initialize() {
        generateDescriptionBasedOnLocation();
        generatePossibleItemsInCurrentRoom();
        // get possible enemy located in player's current room
        generatePossibleEnemyInCurrentRoom();
        // hide all combat
        hideAllCombatInfo();

        displayInventory();
        // button for item utilize
        userItemButton.setOnAction(e -> useItemButtonHandler());
        // button for movements
        south.setOnAction(e -> {
            try {
                movementRoomHandler(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        north.setOnAction(e -> {
            try {
                movementRoomHandler(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        east.setOnAction(e -> {
            try {
                movementRoomHandler(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        west.setOnAction(e -> {
            try {
                movementRoomHandler(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        currentLocationLabel.setText(jemad.getCurrentLocation());

        songs = new ArrayList<File>();
        directory = new File("module/json/Music");
        files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                songs.add(file);
                System.out.println(file);
            }
        }
        media = new Media(songs.get(songNumber).toURI().toString());
        System.out.println(media);
        mediaPlayer = new MediaPlayer(media);
        playMedia();


        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                mediaPlayer.setVolume(volumeSlider.getValue() *.01);
            }

        });

    }

    public void playMedia(){
        mediaPlayer.play();
        System.out.println("Playing music");
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                System.out.println("Works");
                nextMedia();
                ;            }
        });
    }
    public void pauseMedia(){
        mediaPlayer.pause();
    }
    public void nextMedia() {
        if (songNumber < 1) {
            songNumber++;
            mediaPlayer.stop();
            System.out.println("Stopped");
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            playMedia();
        } else {
            songNumber = 0;
            mediaPlayer.stop();
            System.out.println("Music stop");
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            playMedia();
        }
    }



    // fight menu items
    public void generatePossibleEnemyInCurrentRoom() {
        JSONArray enemyList = ReadRoomContentJson.retrieveEnemiesOnCurrentRoom(jemad.getCurrentLocation());
        if (enemyList == null || enemyList.size() == 0) {
            return;
        }
        if (DEFEATED_ENEMYLIST != null && DEFEATED_ENEMYLIST.size() > 0) {
            // if enemy got defeated in current user's location
            if (DEFEATED_ENEMYLIST.containsKey(jemad.getCurrentLocation())) {
                String defeatedEnemy = DEFEATED_ENEMYLIST.get(jemad.getCurrentLocation()).getName();
                if (enemyList.contains(defeatedEnemy)) {
                    enemyList.remove(defeatedEnemy);
                }
            }
        }
        // loop to create possible options for all enemies in current room
        fightButton.getItems().clear();
        // if the enemy list is empty
        if (enemyList.isEmpty()) {
            MenuItem emptyItem = new MenuItem();
            emptyItem.setText("No enemy exist");
            fightButton.getItems().add(emptyItem);
        }

        for (Object eachEnemy: enemyList) {
            MenuItem enemyItem = new MenuItem();
            enemyItem.setId(String.valueOf(eachEnemy));
            enemyItem.setText(String.valueOf(eachEnemy));
            // put event on each enemy
            enemyItem.setOnAction(e -> enemyFightSceneHandler(e, String.valueOf(eachEnemy)));
            fightButton.getItems().add(enemyItem);
        }
    }

    // hide all combatInfo for init stage
    private void hideAllCombatInfo() {
        // hide all elements related to fight
        playerFightTextArea.setVisible(false);
        jemadCombatMovementMenuButton.setVisible(false);
        jemadFacingRightImageView.setVisible(false);
        enemyFacingImageView.setVisible(false);
        enemyFightTextArea.setVisible(false);
    }

    // display all hidencombat info
    private void showAllCombatInfo() {
        playerFightTextArea.setVisible(true);
        jemadCombatMovementMenuButton.setVisible(true);
        jemadFacingRightImageView.setVisible(true);
        enemyFacingImageView.setVisible(true);
        enemyFightTextArea.setVisible(true);
    }

    // display win after combat
    private void showWinStatement() {
        enemyFightImage = new Image(this.getClass().getResourceAsStream("/images/defeated.jpeg"));
        enemyFacingImageView.setImage(enemyFightImage);
        enemyFightTextArea.setText("You are stronger than I thought...\nYou won the fight");
        if (!jemad.getCurrentLocation().equals("Rooftop: Final Boss")) {
            playerFightTextArea.setText("You are no match to me.\n" +
                    "I will move to the next stage to fight and reach my goal.");
        }
    }

    // private method to disable buttons during fight scene
    private void duringFightDisableButtons() {
        // disable the buttons and menuItemButtons
        // disable movement btns
        incombatMessage.setText("In Combat");
        north.setManaged(false);
        north.setVisible(false);
        south.setManaged(false);
        south.setVisible(false);
        east.setManaged(false);
        east.setVisible(false);
        west.setManaged(false);
        west.setVisible(false);
        // disable menuButton
        menuButton.setManaged(false);
        menuButton.setVisible(false);
        // fight button
        fightButton.setManaged(false);
        fightButton.setVisible(false);
        // get item buttons
        getItemMenuButton.setManaged(false);
        getItemMenuButton.setVisible(false);
    }

    // private method to bring buttons back after fight scene
    private void afterFightAbleButtons() {
        incombatMessage.setText("Not in combat");
        // able the buttons and menuItemButtons
        // able movement btns
        north.setManaged(true);
        north.setVisible(true);
        south.setManaged(true);
        south.setVisible(true);
        east.setManaged(true);
        east.setVisible(true);
        west.setManaged(true);
        west.setVisible(true);
        // able menuButton
        menuButton.setManaged(true);
        menuButton.setVisible(true);
        // fight button
        fightButton.setManaged(true);
        fightButton.setVisible(true);
        // get item buttons
        getItemMenuButton.setManaged(true);
        getItemMenuButton.setVisible(true);
    }

    private void enemyFightSceneHandler(ActionEvent e, String fxId) {
        // disable unused button during fight/combat
        duringFightDisableButtons();
        // display jemad and enemy fight info
        showAllCombatInfo();
        Enemy selectedEnemy = new Enemy(fxId);

        // must disable all buttons (such as menu, getItem)
        fightCombatDialog(fxId);
        // set up enemy
        getEnemyInfo(selectedEnemy);
        // set up player
        getPlayerJemadInfo(selectedEnemy);
    }

    // set the dialog
    private void fightCombatDialog(String fxId) {
        // use the enemy name to retrieve the fighting story
        String storyLines = StoryGenerator.printStoryIntro(fxId);
        fightCombatDialog.setEditable(false);
        fightCombatDialog.setStyle("-fx-font-size: 3em;");
        fightCombatDialog.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
        fightCombatDialog.setText(storyLines);
    }

    // private method to retrieve current enemy info for fight
    private void getEnemyInfo(Enemy selectedEnemy) {
        getEnemyInfoHelper(selectedEnemy);
        enemyFightImage = new Image(this.getClass().getResourceAsStream("/images/enemyImage.jpeg"));
        enemyFacingImageView.setImage(enemyFightImage);
    }

    // private method just to retrieve enemy textarea data
    private void getEnemyInfoHelper(Enemy selectedEnemy) {
        String selectedEnemyName = selectedEnemy.getName();
        int selectedEnemyHp = selectedEnemy.getHp();
        int selectedEnemyMinDamage = selectedEnemy.getMinDamage();
        int selectedEnemyMaxDamage = selectedEnemy.getMaxDamage();
        enemyFightTextArea.setEditable(false);
        enemyFightTextArea.setStyle("-fx-font-size: 4em;");
        enemyFightTextArea.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
        enemyFightTextArea.setText(selectedEnemyName + "\n\nHp: " + selectedEnemyHp + "\n\nDamage: " + selectedEnemyMinDamage + " ~ " + selectedEnemyMaxDamage);
    }

    // private method to retrieve current Jemad's info for fight
    private void getPlayerJemadInfo(Enemy selectedEnemy) {
        getPlayerJemadInfoHelper();
        // set up the jemad facing image
        jemadFightImage = new Image(this.getClass().getResourceAsStream("/images/jemadFightImage.jpeg"));
        jemadFacingRightImageView.setImage(jemadFightImage);
        // set up the possible movements
        JSONArray jemadAttackMoves = ReadMoveContentJson.getAllPossibleAttackMoves();
        if (jemadAttackMoves == null || jemadAttackMoves.size() == 0) {
            return;
        }
        for (Object jemadAttack: jemadAttackMoves) {
            MenuItem eachAttack = new MenuItem();
            // jemadCombatMovementMenuButton
            // set it into lower case
            eachAttack.setId(String.valueOf(jemadAttack).toLowerCase());
            eachAttack.setText(String.valueOf(jemadAttack));
            // set an action about fight logic for each menu item
            eachAttack.setOnAction(e -> fightingCombatLogic(e, String.valueOf(jemadAttack).toLowerCase(), selectedEnemy));
            // loop until someone die
            jemadCombatMovementMenuButton.getItems().add(eachAttack);
        }
    }

    // private method just to retrieve current player info for textarea
    private void getPlayerJemadInfoHelper() {
        String playerName = jemad.getName();
        int playerHp = jemad.getHp();
        int playerMinDamage = jemad.getMinDamage();
        int playerMaxDamage = jemad.getMaxDamage();
        playerFightTextArea.setEditable(false);
        playerFightTextArea.setStyle("-fx-font-size: 4em;");
        playerFightTextArea.setStyle("-fx-focus-color: transparent; -fx-text-box-border: transparent;");
        playerFightTextArea.setText(playerName + "\n\nHp: " + playerHp + "\n\nDamage: " + playerMinDamage + " ~ " + playerMaxDamage);
    }

    // private method to move into lose scene
    private void moveToLoseScene() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));

        fadeTransition.setNode(pane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        fadeTransition.setOnFinished((ActionEvent event) -> {
            Stage stage = (Stage) menuButton.getScene().getWindow();
            LoseSceneBuilder loseSceneBuilder = new LoseSceneBuilder();
            loseSceneBuilder.buildLoseScene(stage);
        });
        fadeTransition.play();
    }

    // move to winning ending scene
    private void moveToVictoryScene() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(1000));

        fadeTransition.setNode(pane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        fadeTransition.setOnFinished((ActionEvent event) -> {
            Stage stage = (Stage) menuButton.getScene().getWindow();
            WinSceneBuilder winSceneBuilder = new WinSceneBuilder();
            try {
                winSceneBuilder.buildWinScene(stage);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        fadeTransition.play();
    }

    private void fightingCombatLogic(ActionEvent e, String jemadAttackMove, Enemy currentEnemy) {
        Media punch;
        MediaPlayer punchPlayer;
        punch = new Media(new File("module/json/punch.wav").toURI().toString());
        System.out.println(punch);
        punchPlayer = new MediaPlayer(punch);
        punchPlayer.play();

        boolean isDefeated = false;
        JemadCombat jemadCombatMove = new JemadCombat();
        int jemadHp = jemad.getHp();
        int enemyHp = currentEnemy.getHp();
        // random either 0 or 1
        int actualDamage = 0;
        int actualEnemyDamage = 0;
        ArrayList<String> enemyAttack = currentEnemy.enemyAttack();
        int firstMove = 0 + (int)(Math.random() * ((1 - 0) + 1));

        if (isDefeated || jemad.getHp() == 0) {
            fightCombatDialog.setText(StoryGenerator.printLoseBattleStatement());
            // transitionIntoLoseScene(e);
            return;
        }
        // player attack first
        if (firstMove == 0) {
            // jemad goes first
            actualDamage = jemadCombatMove.jemadMoves(jemadAttackMove);
            enemyHp -= actualDamage;
            currentEnemy.setHp(enemyHp);
            // reset enemy hp area
            getEnemyInfoHelper(currentEnemy);
            if (enemyHp <= 0) {
                // final boss
                if (currentEnemy.getName().equals("Don Fury")) {
                    System.out.println("Final boss fight!!");
                    currentEnemy.setHp(0);
                    // move to ending scene
                    moveToVictoryScene();
                    return;
                }

                // player won
                // need to print out the combat outro from JSON
                String combatOutro1PlayerWin = StoryGenerator.printStoryOutro(currentEnemy.getName());
                fightCombatDialog.setText(combatOutro1PlayerWin);
                // just set enemy health into 0
                currentEnemy.setHp(0);
                // display textarea of enemy with reset hp value
                getEnemyInfoHelper(currentEnemy);
                // able the disabled buttons
                afterFightAbleButtons();

                // add enemy name on the defeated list
                DEFEATED_ENEMYLIST.put(jemad.getCurrentLocation(), currentEnemy);
                // Update possible enemy?
                generatePossibleEnemyInCurrentRoom();
                // display you won
                showWinStatement();
                return;
            }
            actualEnemyDamage = Integer.parseInt(enemyAttack.get(1));
            // reset player hp area
            jemad.setHp(jemad.getHp() - actualEnemyDamage);
            getPlayerJemadInfoHelper();
            if (jemad.getHp() <= 0) {
                // enemy won
                fightCombatDialog.setText(StoryGenerator.printLoseBattleStatement());
                // reset jemad hp to 0
                jemad.setHp(0);
                getPlayerJemadInfoHelper();
                // replace the player image
                jemadFightImage = new Image(this.getClass().getResourceAsStream("/images/defeated.jpeg"));
                jemadFacingRightImageView.setImage(jemadFightImage);
                // bouncer 5, 10
                isDefeated = true;
                moveToLoseScene();
                // transitionIntoLoseScene(e);
                return;
            }
        } else {
            // enemy goes first
            actualEnemyDamage = Integer.parseInt(enemyAttack.get(1));
            jemad.setHp(jemad.getHp() - actualEnemyDamage);
            getPlayerJemadInfoHelper();
            if (jemad.getHp() <= 0) {
                // enemy won
                fightCombatDialog.setText(StoryGenerator.printLoseBattleStatement());
                // set Jemad hp into 0
                jemad.setHp(0);
                getPlayerJemadInfoHelper();
                // replace jemad image
                jemadFightImage = new Image(this.getClass().getResourceAsStream("/images/defeated.jpeg"));
                jemadFacingRightImageView.setImage(jemadFightImage);
                isDefeated = true;
                // transitionIntoLoseScene(e);
                moveToLoseScene();
                return;
            }
            actualDamage = jemadCombatMove.jemadMoves(jemadAttackMove);
            currentEnemy.setHp(currentEnemy.getHp() - actualDamage);
            getEnemyInfoHelper(currentEnemy);
            if (currentEnemy.getHp() <= 0) {
                if (currentEnemy.getName().equals("Don Fury")) {
                    System.out.println("Final boss fight!!");
                    // move to ending scene
                     moveToVictoryScene();
                     return;
                }
                // player won
                // need to print out the combat outro from JSON
                String combatOutro1PlayerWin = StoryGenerator.printStoryOutro(currentEnemy.getName());
                fightCombatDialog.setText(combatOutro1PlayerWin);
                // just set enemy health into 0
                currentEnemy.setHp(0);
                // display textarea of enemy with reset hp value
                getEnemyInfoHelper(currentEnemy);
                // able the disabled buttons
                afterFightAbleButtons();
                // add enemy name on the defeated list
                DEFEATED_ENEMYLIST.put(jemad.getCurrentLocation(), currentEnemy);
                // update possible enemy
                generatePossibleEnemyInCurrentRoom();
                // display you won
                showWinStatement();
                return;
            }
        }
        // print fighting summary
        String inCombatSummary = StoryGenerator
                .duringCombatSummaryPrint(firstMove, currentEnemy.getName(), jemadAttackMove, actualDamage, enemyAttack.get(0), enemyAttack.get(1));
        fightCombatDialog.setText(inCombatSummary);
    }

    // movement
    private void movementRoomHandler(ActionEvent e) throws IOException {
        String currentPlayerLocation = jemad.getCurrentLocation();
        // retrieve entire room based on current player location
        JSONObject roomObj = ReadRoomContentJson.getCurrentRoomContentJSON(currentPlayerLocation);
        Button btn =  (Button) e.getSource();
        String fxId = btn.getId();
        JSONArray nextRoomBasedOnButton = (JSONArray) roomObj.get(fxId);
        if (nextRoomBasedOnButton == null || nextRoomBasedOnButton.size() == 0) {
            return;
        }
        // if the movement for next direction is valid
        String movedLocation = String.valueOf(nextRoomBasedOnButton.get(0));
        // set Jemad's location to movedLocation
        jemad.setCurrentLocation(movedLocation);
        SceneController.switchScenesBaseOnBtnClick(e);
    }

    // private method to generate all possible item based on
    // current location
    private void generatePossibleItemsInCurrentRoom() {
        JSONArray itemList = ReadItemContentJson.getItemBasedOnLocation(jemad.getCurrentLocation());
        getItemMenuButton.getItems().removeAll();
        if (itemList == null || itemList.size() == 0) {
            return;
        }
        if (itemList != null && itemList.size() > 0) {
            // clear out the previous item inventory
            getItemMenuButton.getItems().clear();
            for (Object eachItem: itemList) {
                JSONObject eachItemObj = (JSONObject) eachItem;
                if (OBTAINED_ITEMS != null && OBTAINED_ITEMS.size() > 0) {
                    boolean isAlreadyObtained = OBTAINED_ITEMS.contains(String.valueOf(eachItemObj.get("name")));
                    if (isAlreadyObtained) {
                        continue;
                    }
                }
                MenuItem eachItemNameMenuItem = new MenuItem();
                eachItemNameMenuItem.setId(String.valueOf(eachItemObj.get("name")));
                eachItemNameMenuItem.setText(String.valueOf(eachItemObj.get("name")));
                eachItemNameMenuItem.setOnAction(e -> addItemInInventoryGUI(eachItemNameMenuItem.getText()));
                getItemMenuButton.getItems().add(eachItemNameMenuItem);

            }
        } else {
            MenuItem emptyItem = new MenuItem();
            emptyItem.setText("No items exist");
            getItemMenuButton.getItems().add(emptyItem);
        }
    }

    // private method for click event to put clicked item into the inventory GUI
    private void addItemInInventoryGUI(String itemId) {
        inventoryListView.getItems().clear();
        // created an item
        Item obtainedItem = new Item(itemId);
        boolean isAdded = jemad.addItemJson(obtainedItem);
        ArrayList<Item> jemadItems = jemad.getInventory();
        for (Item eachItem: jemadItems) {
            inventoryListView.getItems().add(eachItem.getItemName());
        }
        if (isAdded) {
            // just add item name (not considering scalability)
            OBTAINED_ITEMS.add(obtainedItem.getItemName());
            String infoHeaderText = "Found an item ( " + obtainedItem.getItemName() + ")";
            itemUserActionInfo.setText(infoHeaderText);
        }
        getItemMenuButton.getItems().clear();
        generatePossibleItemsInCurrentRoom();
    }

    private void displayInventory() {
        ArrayList<Item> itemDataFromInventory = jemad.getInventory();
        if (itemDataFromInventory == null) {
            return;
        }
        inventoryListView.getItems().removeAll();
        for (Item eachItem : itemDataFromInventory) {
            inventoryListView.getItems().add(eachItem.getItemName());
        }
    }

    // method to utilize the item
    private void useItemButtonHandler() {
        ObservableList<String> selectedItem;
        selectedItem = inventoryListView.getSelectionModel().getSelectedItems();
        // if the item had been selected
        if (selectedItem == null || selectedItem.size() <= 0) {
            // alert user to select an item
            return;
        }
        String selectedItemName = selectedItem.get(0);
        Item usedItem = new Item(selectedItemName);
        String itemUseMessage = jemad.useItemJson(usedItem);
        itemUserActionInfo.setText(itemUseMessage);
        // after use it
        // clear out the inventory gui and re populate the data
        inventoryListView.getItems().clear();
        ArrayList<Item> jemadItems = jemad.getInventory();
        for (Item eachItem: jemadItems) {
            inventoryListView.getItems().add(eachItem.getItemName());
        }
        // update textarea
        getPlayerJemadInfoHelper();
    }

    private void generateDescriptionBasedOnLocation() {
        String currentDescription = ReadRoomContentJson.trimRoomDescription(jemad.getCurrentLocation());
        gameDescription.setEditable(false);
        gameDescription.setWrapText(true);
        gameDescription.setText(currentDescription);
    }

    public void switchItIntoMap(ActionEvent event) throws IOException {
        if (event.getSource() == displayMapMenuItem || event.getSource() == aboutJemad ||  event.getSource() == saveGame ||  event.getSource() == loadGame) {
            MenuItem menuItemId = (MenuItem) event.getSource();
            String id = menuItemId.getId();
            // try to get the stage
            Stage stage = (Stage) menuButton.getScene().getWindow();
            SceneController.switchSceneBaseOnMenuItemClick(event, stage);
        } else {
            SceneController.switchScenesBaseOnBtnClick(event);
         }
    }
}
