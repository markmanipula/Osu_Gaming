package com.GUI.status;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class PlayerStatusSceneBuilder {
    private Scene playerStatusScene = null;
    private Parent root = null;

    public void buildPlayerStatusScene(Stage stage) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("PlayerStatusScreen.fxml"));
            playerStatusScene = new Scene(root);
            stage.setScene(playerStatusScene);
            stage.show();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
