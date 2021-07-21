package com.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.print.DocFlavor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;


public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;



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

    @FXML
    public void start (ActionEvent e) {
        System.out.println(e);
        Button btn = (Button) e.getSource();
        String id = btn.getId();
        System.out.println(id);
        if (id.equals("startBtn")) {


        }
        System.out.println(SOTF.stringCombatIntro());
    }

}
