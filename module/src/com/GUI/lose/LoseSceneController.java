package com.GUI.lose;

import com.GUI.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoseSceneController {
    @FXML
    private AnchorPane pane;
    @FXML
    private ImageView defeatedImageView;
    private Image defeatImage;
    @FXML
    private Button restartButton;
    @FXML
    private Button exitButton;


    public void initialize() {
        restartButton.setOnAction(e -> {
            try {
                restartTheApplication(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        exitButton.setOnAction(e -> terminateApplication());
        setUpDefeatImage();
    }

    private void setUpDefeatImage() {
        defeatImage = new Image(this.getClass().getResourceAsStream("/images/defeated.jpeg"));
        defeatedImageView.setImage(defeatImage);
    }

    private void terminateApplication() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    private void restartTheApplication(ActionEvent e) throws IOException {
        System.out.println("Restart invoked");
        // need to switch out to the title stage
        SceneController.switchScenesBaseOnBtnClick(e);
    }
}
