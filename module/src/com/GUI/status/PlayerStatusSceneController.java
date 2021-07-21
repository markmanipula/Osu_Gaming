package com.GUI.status;

import com.GUI.SceneController;
import com.game.Player;
import com.readjson.ReadStoryContentJson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class PlayerStatusSceneController {
    @FXML
    private ImageView imageView;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextArea storyTextArea;
    @FXML
    private TextField currentHp;
    @FXML
    private TextField attackDamage;
    @FXML
    private TextField currentLocation;
    @FXML
    private Button exitPlayerStatusButton;

    private Image fbiImage;
    // player class
    private Player player = new Player();

    @FXML
    public void initialize() {
        displayImage();
        setUpPlayerInfo();
    }

    // set up image
    private void displayImage() {
        fbiImage = new Image(PlayerStatusSceneController.class.getResourceAsStream("/images/fbiPlayer.jpg"));
        System.out.println("read image");
        imageView.setImage(fbiImage);
    }

    // set up name, story, current hp, attack damage, current location
    private void setUpPlayerInfo() {
        nameTextField.setText("Jemad");
        nameTextField.setEditable(false);
        // storyTextArea
        storyTextArea.setWrapText(true);
        storyTextArea.setText(ReadStoryContentJson.trimGameIntro("Game Intro"));
        storyTextArea.setEditable(false);
        // current hp
        currentHp.setText(player.getHp() + " / " + player.getFullHp());
        currentHp.setEditable(false);
        // attack damage
        attackDamage.setText(player.getMinDamage() + " ~ " + player.getMaxDamage());
        attackDamage.setEditable(false);
        // current location
        currentLocation.setText(player.getCurrentLocation());
        currentLocation.setEditable(false);
    }

    public void switchItIntoMain(ActionEvent event) throws IOException {
        SceneController.switchScenesBaseOnBtnClick(event);
    }

}
