package com.GUI.maingame;

import com.GUI.SceneController;
import com.GUI.lose.LoseSceneBuilder;
import com.character.Enemy;
import com.combat.JemadCombat;
import com.game.Item;
import com.game.Player;
import com.readjson.ReadItemContentJson;
import com.readjson.ReadMoveContentJson;
import com.readjson.ReadRoomContentJson;
import com.story.StoryGenerator;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

    // player obj to retrieve the current location
    private Player jemad = new Player();
    // an hashmap to store the location and the enemy name
    private static HashMap<String, Enemy> DEFEATED_ENEMYLIST = new HashMap<>();

    @FXML
    public void initialize() {
        System.out.println("is this print? from initializer");
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
    }

    // fight menu items
    public void generatePossibleEnemyInCurrentRoom() {
        System.out.println("fight button had been  cliekced!!");

        JSONArray enemyList = ReadRoomContentJson.retrieveEnemiesOnCurrentRoom(jemad.getCurrentLocation());
        if (enemyList == null || enemyList.size() == 0) {
            return;
        }
        System.out.println("Enemy: " + DEFEATED_ENEMYLIST);
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
        System.out.println("After defeat enemy: " + enemyList);
        // if the enemy list is empty
        if (enemyList.isEmpty()) {
            MenuItem emptyItem = new MenuItem();
            emptyItem.setText("No enemy exist");
            fightButton.getItems().add(emptyItem);
        }

        for (Object eachEnemy: enemyList) {
            System.out.println("making menuitems");
            MenuItem enemyItem = new MenuItem();
            enemyItem.setId(String.valueOf(eachEnemy));
            enemyItem.setText(String.valueOf(eachEnemy));
            // put event on each enemy
            enemyItem.setOnAction(e -> enemyFightSceneHandler(e, String.valueOf(eachEnemy)));
            fightButton.getItems().add(enemyItem);
            System.out.println("end of for loop");
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
        System.out.println("set back to things");
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

    private void fightingCombatLogic(ActionEvent e, String jemadAttackMove, Enemy currentEnemy) {
        boolean isDefeated = false;
        JemadCombat jemadCombatMove = new JemadCombat();
        System.out.println("got it into fight");
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
            System.out.println("got it in here");
            if (enemyHp <= 0) {
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
        System.out.println(fxId);
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
        if (itemList != null || itemList.size() > 0) {
            for (Object eachItem: itemList) {
                JSONObject eachItemObj = (JSONObject) eachItem;
                MenuItem eachItemNameMenuItem = new MenuItem();
                eachItemNameMenuItem.setId(String.valueOf(eachItemObj.get("name")));
                eachItemNameMenuItem.setText(String.valueOf(eachItemObj.get("name")));
                eachItemNameMenuItem.setOnAction(e -> addItemInInventoryGUI(eachItemNameMenuItem.getText()));
                getItemMenuButton.getItems().add(eachItemNameMenuItem);
            }
        } else {
            MenuItem itemDoesNotExist = new MenuItem();
            itemDoesNotExist.setId("none");
            itemDoesNotExist.setText("There is no item in this room");
            getItemMenuButton.getItems().add(itemDoesNotExist);
        }
    }

    // private method for click event to put clicked item into the inventory GUI
    private void addItemInInventoryGUI(String itemId) {
        inventoryListView.getItems().clear();
        // created an item
        Item obtainedItem = new Item(itemId);
        System.out.println("Item Obtained: " + obtainedItem);
        boolean isAdded = jemad.addItemJson(obtainedItem);
        ArrayList<Item> jemadItems = jemad.getInventory();
        for (Item eachItem: jemadItems) {
            inventoryListView.getItems().add(eachItem.getItemName());
        }
        if (isAdded) {
            String infoHeaderText = "Found an item ( " + obtainedItem.getItemName() + ")";
            itemUserActionInfo.setText(infoHeaderText);
        }
    }

    private void displayInventory() {
        ArrayList<Item> itemDataFromInventory = jemad.getInventory();
        System.out.println(itemDataFromInventory);
        if (itemDataFromInventory == null) {
            return;
        }
        inventoryListView.getItems().removeAll();
        System.out.println("From displayInventory: " + itemDataFromInventory);
        for (Item eachItem : itemDataFromInventory) {
            System.out.println(eachItem.getItemName());
            inventoryListView.getItems().add(eachItem.getItemName());
        }
    }

    // method to utilize the item
    private void useItemButtonHandler() {
        ObservableList<String> selectedItem;
        selectedItem = inventoryListView.getSelectionModel().getSelectedItems();
        System.out.println(selectedItem);
        // if the item had been selected
        if (selectedItem == null || selectedItem.size() <= 0) {
            System.out.println("hello world haha");
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
    }

    private void generateDescriptionBasedOnLocation() {
        // changed the location to inside bar to test
        // jemad.setCurrentLocation("Outside Bar");
        String currentDescription = ReadRoomContentJson.trimRoomDescription(jemad.getCurrentLocation());
        gameDescription.setEditable(false);
        gameDescription.setWrapText(true);
        gameDescription.setText(currentDescription);
    }

    public void switchItIntoMap(ActionEvent event) throws IOException {
        if (event.getSource() == displayMapMenuItem || event.getSource() == aboutJemad ||  event.getSource() == saveGame ||  event.getSource() == loadGame) {
            System.out.println("a menu item got clicked");
            MenuItem menuItemId = (MenuItem) event.getSource();
            String id = menuItemId.getId();
            System.out.println(id);
            // try to get the stage
            Stage stage = (Stage) menuButton.getScene().getWindow();
            SceneController.switchSceneBaseOnMenuItemClick(event, stage);
        } else {
            SceneController.switchScenesBaseOnBtnClick(event);
         }

    }

}
