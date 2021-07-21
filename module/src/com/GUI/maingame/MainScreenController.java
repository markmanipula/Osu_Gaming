package com.GUI.maingame;

import com.GUI.SceneController;
import com.game.Player;
import com.readjson.ReadRoomContentJson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {
    @FXML
    private MenuButton menuButton;
    @FXML
    private MenuItem displayMapMenuItem;
    @FXML
    private MenuItem aboutJemad;
    // script data
    @FXML
    private TextArea gameDescription;

    // player obj to retrieve the current location
    private Player jemad = new Player();

    @FXML
    public void initialize() {
        System.out.println("is this print? from initializer");
        generateDescriptionBasedOnLocation();
    }

    private void generateDescriptionBasedOnLocation() {
        // changed the location to inside bar to test
        jemad.setCurrentLocation("Inside Bar");
        String currentDescription = ReadRoomContentJson.trimRoomDescription(jemad.getCurrentLocation());
        gameDescription.setEditable(false);
        gameDescription.setWrapText(true);
        gameDescription.setText(currentDescription);
    }

    public void switchItIntoMap(ActionEvent event) throws IOException {
        if (event.getSource() == displayMapMenuItem || event.getSource() == aboutJemad) {
            System.out.println("a menu item got clicked");
            MenuItem menuItemId = (MenuItem) event.getSource();
            String id = menuItemId.getId();
            System.out.println(id);
            // try to get the stage
            Stage stage = (Stage) menuButton.getScene().getWindow();
            SceneController.switchSceneBaseOnMenuItemClick(event, stage);
        } else {
            SceneController.switchScenesBaseOnBtnClick(event);
         }

    }
}
