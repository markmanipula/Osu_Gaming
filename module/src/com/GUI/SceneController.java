package com.GUI;

import com.GUI.intro.JemadIntroScene;
import com.GUI.loadgame.LoadGameScene;
import com.GUI.maingame.MainScreenSceneBuilder;
import com.GUI.map.MapSceneBuilder;
import com.GUI.savegame.SaveGameScene;
import com.GUI.status.PlayerStatusSceneBuilder;
import com.GUI.tutorial.TutorialSceneBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private static Stage stage;

    // handles only menuitems
    public static void switchSceneBaseOnMenuItemClick(ActionEvent event, Stage stage) throws IOException {
        MenuItem menuItemId = (MenuItem) event.getSource();
        String id = menuItemId.getId();
        System.out.println(id);

        MenuItem menuItemTarget = (MenuItem) event.getTarget();
        System.out.println(id);
        System.out.println("Got the stage in " + stage);
        switch (id) {
            case "displayMapMenuItem":
                System.out.println("goBackBtn Clicked");
                MapSceneBuilder mapSceneBuilder = new MapSceneBuilder();
                mapSceneBuilder.buildMapScene(stage);
                break;
            case "aboutJemad":
                System.out.println("aboutJemad menuItem clicked");
                PlayerStatusSceneBuilder playerSceneBuilder = new PlayerStatusSceneBuilder();
                playerSceneBuilder.buildPlayerStatusScene(stage);
                break;
            case "saveGame":
                System.out.println("saveGame menuItem clicked");
                SaveGameScene saveGameScene = new SaveGameScene();
                saveGameScene.buildSaveGameScene(stage);
                break;
            case "loadGame":
                System.out.println("loadGame menuItem clicked");
                LoadGameScene loadGameScene = new LoadGameScene();
                loadGameScene.buildLoadGameScene(stage);
                break;
        }
    }

    // handles only actual buttons
    public static void switchScenesBaseOnBtnClick(ActionEvent event) throws IOException {
        Button btn = (Button) event.getSource();
        String id = btn.getId();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switch (id) {
            case "north":
            case "south":
            case "east":
            case "west":
            case "continueBtn":
            case "goBackBtn":
            case "doNotSaveGameBtn":
            case "doNotLoadBtn":
            case "loadBtnOk":
            case "exitPlayerStatusButton":
                System.out.println("continueBtn Clicked");
                System.out.println("Got the stage in " + stage);
                MainScreenSceneBuilder mainGameScene = new MainScreenSceneBuilder();
                mainGameScene.buildMainGameScene(stage);
                break;
            case "startBtn":
            case "restartButton":
            case "tutorialToMainBtn":
                System.out.println("startBtn Clicked");
                JemadIntroScene jemadIntroScene = new JemadIntroScene();
                jemadIntroScene.buildIntroScene(stage);
                break;
            // placeholder until we figure out menu item thing
            case "viewMapBtn":
                System.out.println("goBackBtn Clicked");
                MapSceneBuilder mapSceneBuilder = new MapSceneBuilder();
                mapSceneBuilder.buildMapScene(stage);
                break;
            case "saveGameBtn":
                System.out.println("saveGameBtnYes Clicked");
                SaveGameScene saveGameScene = new SaveGameScene();
                saveGameScene.buildSaveGameSuccessScene(stage);
                break;
            case "saveGameBtnOk":
                stage.close();
                break;
            case "loadBtn":
                LoadGameScene loadGameScene = new LoadGameScene();
                loadGameScene.buildLoadGameWaitScene(stage);
                break;
            case "tutorialBtn":
                TutorialSceneBuilder tutorialScene = new TutorialSceneBuilder();
                tutorialScene.buildWinScene(stage);
                break;
        }
    }
}