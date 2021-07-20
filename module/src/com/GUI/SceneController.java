package com.GUI;

import com.GUI.intro.JemadIntroScene;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private static Stage stage;

    public static void switchScenesBaseOnBtnClick(ActionEvent event) throws IOException {
        Button btn = (Button) event.getSource();
        String id = btn.getId();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        System.out.println(stage);
        switch (id) {
            case "continueBtn":
//                System.out.println("continueBtn Clicked");
//                MainScreenBuildScene mainGameScene = new MainScreenBuildScene();
//                mainGameScene.buildMainGameScene(stage);
                break;
            case "startBtn":
                System.out.println("startBtn Clicked");
                JemadIntroScene jemadIntroScene = new JemadIntroScene();
                jemadIntroScene.buildIntroScene(stage);
                break;
        }
    }
}