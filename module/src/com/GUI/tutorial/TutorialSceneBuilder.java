package com.GUI.tutorial;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TutorialSceneBuilder {
    private Scene tutorialScene = null;
    private Parent root = null;

    public void buildWinScene(Stage stage) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("TutorialScreen.fxml"));
            tutorialScene = new Scene(root);
            stage.setScene(tutorialScene);
            stage.show();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
