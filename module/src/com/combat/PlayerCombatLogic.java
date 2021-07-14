package com.combat;
import com.game.GameStart;
import com.game.Player;
import com.readjson.ReadMoveContentJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
// import com.client.Client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;


public class PlayerCombatLogic {
    private int currentEnemyHp = 10;
    private int jemadHealth = 100;
    private int enemyDmg = 0;
    private int jemadDmg = 0;

    //obj to take user input for attacks
     Scanner userInput = new Scanner(System.in);

    // object for combat dialogue
    CombatDialogue dialogue = new CombatDialogue();

    //object for Jemad combat methods
    JemadCombat attacks = new JemadCombat("Jemad");

    //object for enemy combat methods
    EnemyCombat enemy = new EnemyCombat("Bouncer");

    //Combat dialogue objects
    GameStart endGame = new GameStart();

    public PlayerCombatLogic() throws IOException {
    }

    //method to clear screen
    public final static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Method to determine subtraction to enemy health

    // this is a test for fight intro
    public void battleIntro(){

        // intro dialogue to enemy encounter
        dialogue.printCombatIntro();

    }
    //for JAR file
    // String movesJson = "com/json/Moves_JSON.txt";

    //for intellij Terminal
//    String movesJson = "module/src/com/json/Moves_JSON.txt";
//    String moveContents = new String((Files.readAllBytes(Paths.get(movesJson))));

    //json for moveContents
    JSONObject j = ReadMoveContentJson.getAllUserFightContentJSON();
    JSONArray jemadMovesList = (JSONArray) j.get("Jemad Attacks");



    public void combatMethod(JSONObject object, JSONObject story, String enemyName) throws InterruptedException {
        clearScreen();
        CombatDialogue.printStoryIntro(story, enemyName);
        printFight();
        Thread.sleep(700);
        JSONObject currentEnemy = (JSONObject) object.get(enemyName);
        currentEnemyHp = Integer.parseInt(String.valueOf(currentEnemy.get("Max Health")));
        do{
            clearScreen();
            System.out.println("=Current Health: " + jemadHealth + " =========================== " + enemyName + " Health: " + currentEnemyHp + "=");
            System.out.print("=\n");
            System.out.print("=\n");
            System.out.print("=\n");
            System.out.print("=\n");
            System.out.print("=\n");
            System.out.print("=\n");
            System.out.print("=\n");
            System.out.print("==========================================================================================\n");
            System.out.println(jemadMovesList);
            String userAttack = userInput.nextLine().toLowerCase();
            System.out.println("Your next attack:");
            enemyDmg = attacks.jemadMoves(userAttack);
            System.out.println("You used " + userAttack + "! for " + enemyDmg + " damage!");
            currentEnemyHp-= enemyDmg;

            //enemy turn to attack
            // Enemies turn to attack method
            ArrayList<String> enemyTurn = enemy.enemyMoves();
           // print out enemy attack and damage to player
            System.out.println("The Bouncer attacks with a " + enemyTurn.get(0) + " and a damage of " + enemyTurn.get(1));
            jemadHealth -= Integer.parseInt(enemyTurn.get(1));
            System.out.println("Jemad health has dropped to " + jemadHealth + " ....");
            System.out.println("Press the enter key to continue");
            String pressEnter = userInput.nextLine().toLowerCase();

        if (currentEnemyHp < 1) {
            System.out.println("Enemy health has now dropped to 0");
            Player.addDefeatedEnemy(enemyName);
            Player.addDefeatedBoss(enemyName);
            dialogue.printCombatOutro();
            CombatDialogue.printStoryOutro(story, enemyName);
        }else if (jemadHealth < 1){
            System.out.println("..damn, my skills are getting dull\n");
            System.out.println("*Jemad passes out and never heard from again...*");
            Thread.sleep(3000);
            System.out.println("Better luck next time...");
            System.out.println("Press Enter to exit");
            String userContinue = userInput.nextLine().toLowerCase();
            System.exit(0);
        }

    }while(currentEnemyHp > 1 && jemadHealth > 1 );
    }

    public void printFight(){
        System.out.println("___________.___  ________  ___ ______________._.\n" +
                "\\_   _____/|   |/  _____/ /   |   \\__    ___/| |\n" +
                " |    __)  |   /   \\  ___/    ~    \\|    |   | |\n" +
                " |     \\   |   \\    \\_\\  \\    Y    /|    |    \\|\n" +
                " \\___  /   |___|\\______  /\\___|_  / |____|    __\n" +
                "     \\/                \\/       \\/            \\/");
    }

    public void battleOutro() throws InterruptedException {
        dialogue.printCombatOutro();
    }



}
