package com.GUI.lose;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoseSceneBuilder {
    private Scene loseScene = null;
    private Parent root = null;

    public void buildLoseScene(Stage stage) {
        try {
            root = FXMLLoader.load(getClass().getResource("LoseSceneScreen.fxml"));
            loseScene = new Scene(root);
            stage.setScene(loseScene);
            stage.show();
        }  catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
