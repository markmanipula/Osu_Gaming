package com.GUI.maingame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenSceneBuilder {
    private Scene mainGameScene = null;
    private Parent root = null;

    public void buildMainGameScene(Stage stage) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            mainGameScene = new Scene(root);
            stage.setScene(mainGameScene);
            stage.show();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
