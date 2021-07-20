package com.GUI;

import com.GUI.intro.JemadIntroScene;
import com.GUI.maingame.MainScreenSceneBuilder;
import com.GUI.map.MapSceneBuilder;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
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
        }
    }

    // handles only actual buttons
    public static void switchScenesBaseOnBtnClick(ActionEvent event) throws IOException {
        Button btn = (Button) event.getSource();
        String id = btn.getId();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switch (id) {
            case "continueBtn":
            case "goBackBtn":
                System.out.println("continueBtn Clicked");
                System.out.println("Got the stage in " + stage);
                MainScreenSceneBuilder mainGameScene = new MainScreenSceneBuilder();
                mainGameScene.buildMainGameScene(stage);
                break;
            case "startBtn":
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
        }
    }
}