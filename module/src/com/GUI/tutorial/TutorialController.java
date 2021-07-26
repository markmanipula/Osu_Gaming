package com.GUI.tutorial;

import com.GUI.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;


public class TutorialController {
    @FXML
    private Button tutorialToMainBtn;

    public void initialize() {

    }

    @FXML
    public void moveToTheMainFromTutorial(ActionEvent e) throws IOException {
        SceneController.switchScenesBaseOnBtnClick(e);
    }
}
