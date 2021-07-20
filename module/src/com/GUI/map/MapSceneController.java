package com.GUI.map;

import com.GUI.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class MapSceneController {
    @FXML
    private ImageView imageView;

    private Image myImage;

    @FXML
    public void initialize() {
        displayImage();
    }

    @FXML
    public void goBackBtnActionEvent(ActionEvent event) throws IOException {
        // scene controller
        SceneController.switchScenesBaseOnBtnClick(event);
    }

    public void displayImage() {
        myImage = new Image(this.getClass().getResourceAsStream("/images/Map.png"));
        System.out.println("Read image");
        imageView.setImage(myImage);
    }
}
