package com.GUI.intro;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JemadIntroScene {
    private Scene jemadIntrScene = null;
    private Parent root = null;

    public void buildIntroScene(Stage stage) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("JemadIntroScene.fxml"));
            jemadIntrScene = new Scene(root);
            stage.setScene(jemadIntrScene);
            stage.show();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
