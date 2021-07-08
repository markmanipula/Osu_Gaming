package com.combat;
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

    //method to clear screen
    public final static void clearScreen(){
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    // Method to determine subtraction to enemy health

    // this is a test for fight intro
    public void battleIntro(){

        // intro dialogue to enemy encounter
        dialogue.printCombatIntro();

    }

    // method for Player Combat
    // jemadMoveList is the reference to the hashmap
    public void combatStart(String enemyName) {
        HashMap<String, Integer> currentEnemy = enemy.enemyParser(enemyName);
        int currentEnemyHp = 0;
        do {
            clearScreen();
            //set enemy health to subclass health value
            System.out.println(currentEnemy.get("Max Health"));
            // Will set and display Jemad current health of '100'
            System.out.println("What kind of attack do I want to do? ");
            System.out.println(Arrays.toString(attacks.jemadAttacks));
            String userCommand = userInput.nextLine();
            System.out.println( attacks.attack(userCommand));
            //displays points of damage from Jemad's attack
            enemyDmg = attacks.jemadMoves(userCommand);
            // take the enemy dmg and modify
            currentEnemyHp = currentEnemy.get("Max Health");
            currentEnemyHp -= enemyDmg;
            currentEnemy.put("Max Health", currentEnemyHp);
//            currentEnemy.compute("Max Health", (String, Integer) -> Integer -= enemyDmg);
            System.out.println("The Bouncer took " + enemyDmg + " points of damage");
            // Enemies turn to attack method
            ArrayList<String> enemyTurn = enemy.enemyMoves();
            // print out enemy attack and damage to player
            System.out.println("The Bouncer attacks with a " + enemyTurn.get(0) + " and a damage of " + enemyTurn.get(1));
            jemadHealth -= Integer.parseInt(enemyTurn.get(1));
            System.out.println("Jemad health has dropped to " + jemadHealth + " ....");
            //Jemad turn to attack
            if (currentEnemyHp < 1) {
                System.out.println("Enemy health has now dropped to " + this.currentEnemyHp);
                dialogue.printCombatOutro();
            }

        }while(currentEnemyHp > 1 && jemadHealth > 1 );
    }

    public void battleOutro(){
        dialogue.printCombatOutro();
    }
}
