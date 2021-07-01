package com.combat;
import java.util.Scanner;
import java.util.Arrays;

import com.game.*;
import com.map.*;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class PlayerCombatLogic {
    private int enemyHealth = 50;


     Scanner userInput = new Scanner(System.in);


    // object for combat dialogue
    CombatDialogue dialogue = new CombatDialogue();

    //object for Jemad combat methods
    JemadCombat attacks = new JemadCombat();

    //Enemy object
    EnemyCombat enemy = new EnemyCombat();


//    EnemyCombat bouncerOne = new EnemyCombat();

    // this is a test for fight intro
    public void battleIntro(){

        // intro dialogue to enemy encounter
        dialogue.printCombatIntro();

    }

    // method for Player Combat
    public void combatStart(){
        while(enemyHealth <= 0)
        System.out.println("What kind of attack do I want to do? ");
        System.out.println(attacks.jemadAttacks);;
        String userCommand = userInput.nextLine();
    }

    public void battleOutro(){
        dialogue.printCombatOutro();
    }
}
