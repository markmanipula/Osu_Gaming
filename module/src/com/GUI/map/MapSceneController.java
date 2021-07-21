package com.GUI.map;

import com.GUI.SceneController;
import com.game.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class MapSceneController {
    @FXML
    private ImageView imageView;
    @FXML
    private Label currentLocationLabel;

    private Image myImage;
    private Player player = new Player();

    @FXML
    public void initialize() {
        displayImage();
        displayUserCurrentLocation();
    }

    @FXML
    public void goBackBtnActionEvent(ActionEvent event) throws IOException {
        // scene controller
        SceneController.switchScenesBaseOnBtnClick(event);
    }

    private void displayUserCurrentLocation() {
        currentLocationLabel.setText(player.getCurrentLocation());
    }
    private void displayImage() {
        myImage = new Image(this.getClass().getResourceAsStream("/images/Map.png"));
        System.out.println("Read image");
        imageView.setImage(myImage);
    }
}
