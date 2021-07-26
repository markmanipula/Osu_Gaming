package com.GUI.win;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WinSceneBuilder {
    private Scene winScene = null;
    private Parent root = null;

    public void buildWinScene(Stage stage) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("WinScreen.fxml"));
            winScene = new Scene(root);
            stage.setScene(winScene);
            stage.show();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
