package com.GUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML private Pane pane;
    @FXML private Label songLabel;
    @FXML private Button playButton;
    @FXML private Slider volumeSlider;

    private File directory;
    private File[] files;
    private ArrayList<File> songs;
    private int songNumber;
    private boolean running;
    private Media media;
    private MediaPlayer mediaPlayer;



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        songs = new ArrayList<File>();
        directory = new File("module/src/Music");
        files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                songs.add(file);
                System.out.println(file);
            }
        }

        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                mediaPlayer.setVolume(volumeSlider.getValue() *0.01);

            }
        });

    }

    public void playMedia(){
        SOTF sotf = new SOTF();
        mediaPlayer.play();
        System.out.println("Playing music");

    }
    public void pauseMedia(){
        mediaPlayer.pause();

    }
    public void nextMedia(){
        if (songNumber < songs.size() - 1){
            songNumber++;
            mediaPlayer.stop();
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            playMedia();
        } else {
            songNumber = 0;
            mediaPlayer.stop();
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            playMedia();
        }

    }

    public void autoMedia() {
        mediaPlayer.setAutoPlay(true);
    }


//    public void switchToMainScreen(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

    // private JemadIntroScene jemadIntroScene = null;

    public void switchToMainScreen(ActionEvent event) throws IOException {
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        System.out.println(event.getSource());
//        jemadIntroScene = new JemadIntroScene();
//        jemadIntroScene.buildIntroScene(stage);
        SceneController.switchScenesBaseOnBtnClick(event);
    }

//    @FXML
//    public void start (ActionEvent e) {
//        System.out.println(e);
//        Button btn = (Button) e.getSource();
//        String id = btn.getId();
//        System.out.println(id);
//        if (id.equals("startBtn")) {
//
//
//        }
//        System.out.println(SOTF.stringCombatIntro());
//    }

}
