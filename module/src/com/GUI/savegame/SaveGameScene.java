package com.GUI.savegame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SaveGameScene {
    private Scene saveGameScene = null;
    private Scene saveGameSuccessScene = null;
    private Parent root = null;

    public void buildSaveGameScene(Stage stage) {
        try {
            root = FXMLLoader.load(this.getClass().getResource("SaveGameScreen.fxml"));
            saveGameScene = new Scene(root, 800, 600);
            stage.setScene(saveGameScene);
            stage.show();
        }  catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void buildSaveGameSuccessScene(Stage stage) {
        try {
            root = FXMLLoader.load(this.getClass().getResource("SaveGameSuccessScreen.fxml"));
            saveGameSuccessScene = new Scene(root, 800, 600);
            stage.setScene(saveGameSuccessScene);
            stage.show();
        }  catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
