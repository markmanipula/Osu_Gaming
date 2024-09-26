package com.GUI.intro;

import com.GUI.SceneController;
import com.readjson.ReadStoryContentJson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class JemadIntroController {
    // private variables for scene
    private Scene mainGameScene = null;
    private Parent root = null;

    @FXML
    private TextArea jemadIntroDialog;

    @FXML
    private Button continueBtn;

    @FXML
    public void initialize() {
        setDialog();
    }

    public void setDialog() {
        // trying to add text dynamically
        String jemadIntro = ReadStoryContentJson.trimGameIntro("Game Intro");
        System.out.println(jemadIntro);
        jemadIntroDialog.setWrapText(true);
        jemadIntroDialog.setText(jemadIntro);
    }

    // method to push it into next scene
    // should be wait til JON pops up
    public void switchItIntoMainGame(ActionEvent event) throws IOException {
        SceneController.switchScenesBaseOnBtnClick(event);
    }
}
