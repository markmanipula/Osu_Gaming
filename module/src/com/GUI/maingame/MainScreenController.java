package com.GUI.maingame;

import com.GUI.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {
    @FXML
    private MenuItem displayMapMenuItem;

    public void switchItIntoMap(ActionEvent event) throws IOException {
//        if (event.getSource() == displayMapMenuItem) {
//            System.out.println("a menu item got clicked");
//            MenuItem menuItemId = (MenuItem) event.getSource();
//            String id = menuItemId.getId();
//            System.out.println(id);
//            MenuItem menuItemTarget = (MenuItem) event.getTarget();
//            ContextMenu cm = menuItemTarget.getParentPopup();
//            System.out.println("Get Parent " + cm);
//            SceneController.switchSceneBaseOnMenuItemClick(event);
//        } else {
            SceneController.switchScenesBaseOnBtnClick(event);
        // }

    }
}
