package com.GUI.map;

import com.GUI.SceneController;
import com.GUI.maingame.MainScreenController;
import com.game.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MapSceneController {
    @FXML
    private ImageView imageView;
    @FXML
    private Label currentLocationLabel;
    @FXML
    private Circle currentUserIndicator;

    private Image myImage;
    private Player player = new Player();

    // rectangles to hide the elements
    @FXML
    private Rectangle hideInsideBar;
    @FXML
    private Rectangle hidePoolRoom;
    @FXML
    private Rectangle hideAlley;
    @FXML
    private Rectangle hideLockerRoom;
    @FXML
    private Rectangle hidePoolDeck;
    @FXML
    private Rectangle hidePoolBar;
    @FXML
    private Rectangle hidePoolDeckUpper;
    @FXML
    private Rectangle hideSlotMachine;
    @FXML
    private Rectangle hidePokerTable;
    @FXML
    private Rectangle hideSteakHouse;
    @FXML
    private Rectangle hideVIPRoom;
    @FXML
    private Rectangle hideElevator;
    @FXML
    private Rectangle hideHotelHalls;
    @FXML
    private Rectangle hideBalcony;
    @FXML
    private Rectangle hideFinalBoss;

    @FXML
    public void initialize() {
        displayImage();
        displayUserCurrentLocation();
        placeIndicatorInMap();
        updateAllMapBlock();
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

    private void updateAllMapBlock() {
        hideInsideBar.setVisible(MainScreenController.getPlayerVisitedPlaces("Inside Bar"));
        hidePoolRoom.setVisible(MainScreenController.getPlayerVisitedPlaces("Pool Room"));
        hideAlley.setVisible(MainScreenController.getPlayerVisitedPlaces("Alley Behind Bar"));
        hideLockerRoom.setVisible(MainScreenController.getPlayerVisitedPlaces("Locker Room"));
        hidePoolDeck.setVisible(MainScreenController.getPlayerVisitedPlaces("Pool Deck"));
        hidePoolBar.setVisible(MainScreenController.getPlayerVisitedPlaces("Pool Bar"));
        hidePoolDeckUpper.setVisible(MainScreenController.getPlayerVisitedPlaces("Pool Deck: Upper Level"));
        hideSlotMachine.setVisible(MainScreenController.getPlayerVisitedPlaces("Slot Machines"));
        hidePokerTable.setVisible(MainScreenController.getPlayerVisitedPlaces("Poker Tables"));
        hideSteakHouse.setVisible(MainScreenController.getPlayerVisitedPlaces("Steak House"));
        hideVIPRoom.setVisible(MainScreenController.getPlayerVisitedPlaces("VIP Room"));
        hideElevator.setVisible(MainScreenController.getPlayerVisitedPlaces("Elevator"));
        hideHotelHalls.setVisible(MainScreenController.getPlayerVisitedPlaces("Hotel Halls"));
        hideBalcony.setVisible(MainScreenController.getPlayerVisitedPlaces("Balcony"));
        hideFinalBoss.setVisible(MainScreenController.getPlayerVisitedPlaces("Rooftop: Final Boss"));
    }

    private void placeIndicatorInMap() {
        String jemadCurrentLocation = player.getCurrentLocation();
        switch (jemadCurrentLocation) {
            case "Outside Bar":
                setIndicatorLocation(67, 189);
                break;
            case "Inside Bar":
                setIndicatorLocation(144, 189);
                updateAllMapBlock();
                break;
            case "Pool Room":
                setIndicatorLocation(144, 238);
                updateAllMapBlock();
                break;
            case "Alley Behind Bar":
                setIndicatorLocation(234, 239);
                updateAllMapBlock();
                break;
            case "Locker Room":
                setIndicatorLocation(317, 239);
                updateAllMapBlock();
                break;
            case "Pool Deck":
                setIndicatorLocation(409, 239);
                updateAllMapBlock();
                break;
            case "Pool Bar":
                setIndicatorLocation(317, 304);
                updateAllMapBlock();
                break;
            case "Pool Deck: Upper Level":
                setIndicatorLocation(408, 304);
                updateAllMapBlock();
                break;
            case "Slot Machines":
                setIndicatorLocation(409, 353);
                updateAllMapBlock();
                break;
            case "Poker Tables":
                setIndicatorLocation(496, 352);
                updateAllMapBlock();
                break;
            case "Steak House":
                setIndicatorLocation(409, 402);
                updateAllMapBlock();
                break;
            case "VIP Room":
                setIndicatorLocation(496, 402);
                updateAllMapBlock();
                break;
            case "Elevator":
                setIndicatorLocation(572, 401);
                updateAllMapBlock();
                break;
            case "Hotel Halls":
                setIndicatorLocation(650, 402);
                updateAllMapBlock();
                break;
            case "Balcony":
                setIndicatorLocation(651, 456);
                updateAllMapBlock();
                break;
            case "Rooftop: Final Boss":
                setIndicatorLocation(730, 458);
                updateAllMapBlock();
                break;
        }
    }
}
