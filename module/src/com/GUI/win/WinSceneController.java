package com.GUI.win;

import com.readjson.ReadStoryContentJson;
import com.story.TextOutput;
import com.story.TextWriter;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class WinSceneController implements Initializable {
    @FXML
    private TextArea gameEndingOutro;
    @FXML
    private Button exitButton;

    private TextOutput textOutput;
    private TextWriter textWriter;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String gameOutro = ReadStoryContentJson
                .trimGameScenePrintHelper("Hotel Suite", "Game Outro", "outro");

        textOutput = new TextOutput() {
            @Override
            public void writeText(String text) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        gameEndingOutro.setText(text);
                    }
                });
            }
        };
        applyTextAreaStyle();
        // animation
        textWriter = new TextWriter(gameOutro, 2500, textOutput);
        start();
        exitButton.setOnAction(e -> terminateApplication());
    }

    private void applyTextAreaStyle() {
        gameEndingOutro.setStyle("-fx-text-fill: #1e88e5;");
    }

    private void start() {
        Thread thread = new Thread(textWriter);
        thread.start();
    }

    private void terminateApplication() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
