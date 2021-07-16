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
            ArrayList<String> enemyTurn = enemy.enemyMoves();
            introCombatSummaryPrint(enemyName, currentEnemyHp);
            System.out.print("Decide your move >");
            String userAttack = userInput.nextLine().toLowerCase();
            enemyDmg = attacks.jemadMoves(userAttack);
            currentEnemyHp-= enemyDmg;
            duringCombatSummaryPrint(enemyName, userAttack, enemyDmg, enemyTurn.get(0), enemyTurn.get(1));
            jemadHealth -= Integer.parseInt(enemyTurn.get(1));
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

    public void introCombatSummaryPrint(String enemyName, int currentEnemyHp) {
        System.out.println("=".repeat(40)  + "=".repeat(40));
        System.out.printf("%-20s %20s %n", "Player HP", enemyName + " HP");
        System.out.printf("%-20s %20s %n", jemadHealth, currentEnemyHp);
        System.out.println("Your available moves:" );
        System.out.println(jemadMovesList);
        System.out.println("=".repeat(40)  + "=".repeat(40));
    }

    public void duringCombatSummaryPrint(String enemyName, String userMovement, int amountOfDamageUserDeal, String enemyMovement, String amountOfDamageEnemyDeal) {
        System.out.println("= You used " + userMovement  + "! for " + amountOfDamageUserDeal + " damage!");
        System.out.println("= The " + enemyName + " attacks with a " + enemyMovement + " and a damage of " + amountOfDamageEnemyDeal);
    }

    public void battleOutro() throws InterruptedException {
        dialogue.printCombatOutro();
    }
}
