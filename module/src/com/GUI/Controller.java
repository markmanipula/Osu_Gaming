package com.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

    // private JemadIntroScene jemadIntroScene = null;

    public void switchToMainScreen(ActionEvent event) throws IOException {
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        System.out.println(event.getSource());
//        jemadIntroScene = new JemadIntroScene();
//        jemadIntroScene.buildIntroScene(stage);
        SceneController.switchScenesBaseOnBtnClick(event);
    }

    @FXML
    public void start (ActionEvent e) {
        System.out.println(e);
        Button btn = (Button) e.getSource();
        String id = btn.getId();
        System.out.println(id);
        if (id.equals("startBtn")) {


        }
        System.out.println(SOTF.stringCombatIntro());
    }
}
