package com.GUI.loadgame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadGameScene {

    private Scene loadGameScene = null;
    private Parent root = null;

    public void buildLoadGameScene(Stage stage) {
        try {
            root = FXMLLoader.load(this.getClass().getResource("LoadGameScreen.fxml"));
            loadGameScene = new Scene(root, 800, 600);
            stage.setScene(loadGameScene);
            stage.show();
        }  catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
