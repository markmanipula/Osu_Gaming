package com.GUI.map;

import com.GUI.SceneController;
import com.game.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class MapSceneController {
    @FXML
    private ImageView imageView;
    @FXML
    private Label currentLocationLabel;
    @FXML
    private Circle currentUserIndicator;

    private Image myImage;
    private Player player = new Player();

    @FXML
    public void initialize() {
        displayImage();
        displayUserCurrentLocation();
        placeIndicatorInMap();
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

    private void setIndicatorLocation(double x, double y) {
        currentUserIndicator.setLayoutX(x);
        currentUserIndicator.setLayoutY(y);
    }

    private void placeIndicatorInMap() {
        String jemadCurrentLocation = player.getCurrentLocation();
        switch (jemadCurrentLocation) {
            case "Outside Bar":
                setIndicatorLocation(75, 143);
                break;
            case "Inside Bar":
                setIndicatorLocation(148, 143);
                break;
            case "Pool Room":
                setIndicatorLocation(148, 192);
                break;
            case "Alley Behind Bar":
                setIndicatorLocation(230, 192);
                break;
            case "Locker Room":
                setIndicatorLocation(313, 192);
                break;
            case "Pool Deck":
                setIndicatorLocation(401, 192);
                break;
            case "Pool Bar":
                setIndicatorLocation(313, 252);
                break;
            case "Pool Deck: Upper Level":
                setIndicatorLocation(401, 252);
                break;
            case "Slot Machines":
                setIndicatorLocation(401, 300);
                break;
            case "Poker Tables":
                setIndicatorLocation(486, 307);
                break;
            case "Steak House":
                setIndicatorLocation(400, 356);
                break;
            case "VIP Room":
                setIndicatorLocation(486, 356);
                break;
            case "Elevator":
                setIndicatorLocation(562, 356);
                break;
            case "Hotel Halls":
                setIndicatorLocation(640, 356);
                break;
            case "Balcony":
                setIndicatorLocation(640, 407);
                break;
            case "Rooftop: Final Boss":
                setIndicatorLocation(715, 407);
                break;
        }
    }
}
