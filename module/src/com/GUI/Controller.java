package com.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Controller {
    @FXML
    public void start (ActionEvent e) {
        System.out.println(SOTF.stringCombatIntro());
    }


}
