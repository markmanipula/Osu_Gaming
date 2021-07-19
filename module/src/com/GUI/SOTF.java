package com.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SOTF extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("TitleScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Spirit Of The Fist");
        stage.show();

      } catch (Exception e) {
          e.printStackTrace();
      }
    }
    public static String stringCombatIntro(){
        String printFight1 = ("___________.___  ________  ___ ______________._.\n" +
                "\\_   _____/|   |/  _____/ /   |   \\__    ___/| |\n" +
                " |    __)  |   /   \\  ___/    ~    \\|    |   | |\n" +
                " |     \\   |   \\    \\_\\  \\    Y    /|    |    \\|\n" +
                " \\___  /   |___|\\______  /\\___|_  / |____|    __\n" +
                "     \\/                \\/       \\/            \\/");
        StringBuilder printFightBuilder = new StringBuilder();
        printFightBuilder.append("\n"+ printFight1);
        return printFightBuilder.toString();
    }
}
