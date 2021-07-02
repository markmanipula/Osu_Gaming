package com.combat;
import java.util.Scanner;
import java.util.Arrays;


public class PlayerCombatLogic {
    public int enemyHealth = 50;

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
    public void combatStart() {
        do {
            clearScreen();
            System.out.println("What kind of attack do I want to do? ");
            System.out.println(Arrays.toString(attacks.jemadAttacks));
            String userCommand = userInput.nextLine();
            System.out.println( attacks.attack(userCommand));
        }while(enemyHealth >= 0);
    }

    public void battleOutro(){
        dialogue.printCombatOutro();
    }
}
