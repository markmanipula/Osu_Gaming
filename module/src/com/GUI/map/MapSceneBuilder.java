package com.GUI.map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MapSceneBuilder {
    private Scene mapScene = null;
    private Parent root = null;

    public void buildMapScene(Stage stage) {
        try {
            root = FXMLLoader.load(getClass().getResource("MapScreen.fxml"));
            mapScene = new Scene(root, 800, 600);
            stage.setScene(mapScene);
            stage.show();
        }  catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
