package com.GUI.maingame;

import com.GUI.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {
    @FXML
    private MenuButton menuButton;
    @FXML
    private MenuItem displayMapMenuItem;


    public void switchItIntoMap(ActionEvent event) throws IOException {
        if (event.getSource() == displayMapMenuItem) {
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
