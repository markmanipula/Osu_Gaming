package com.combat;

import com.game.Player;

import java.awt.image.RasterOp;
import java.util.HashMap;
import java.util.Random;

public class JemadCombat extends SotfCharacters{
    private Player jemad = new Player();
    Random random = new Random();
    //Hashmap for Jemad attack and damage

    // set up a default constructor
    public JemadCombat() {
        // empty
    }

    // method overloading
    public int jemadMoves() {
        int randomDamage = randomDamage(jemad.getMinDamage(),jemad.getMaxDamage());
        return randomDamage;
    }

    public int jemadMoves (String moves) {

        int randomDamage = randomDamage(jemad.getMinDamage(),jemad.getMaxDamage());

        HashMap<String, Integer> jemadMoves = new HashMap<>();
        jemadMoves.put("straight punch", randomDamage);
        jemadMoves.put("push kick", randomDamage);
        jemadMoves.put("uppercut", randomDamage);
        jemadMoves.put("head kick", randomDamage);
        jemadMoves.put("hip throw", randomDamage);
        //outputs 0 damage when not a valid move
        if(!jemadMoves.containsKey(moves)){
            return 0;
        }

        return jemadMoves.get(moves);
    }
    // whatever the name of the method is
    // within the PlayerCombatLogic

    public JemadCombat(String name) {
        super(name, 100, 100);
    }

    @Override
    public String defense(String userCommand) {
        return "";
    }

    // Jemad specific
    //made to evaluate userinput and determine dialogue
    @Override
    public String attack(String userCommand) {
        if(userCommand == null) return "not a valid move";

        if (userCommand.equals("straight punch")) {
            return ("Jemad plants his feet and throws a straight punch!");
        } else if (userCommand.equals("push kick")) {
            return ("Jemad quickly aims a push kick the enemies mid section");
        } else if (userCommand.equals("uppercut")) {
            return ("Jemad aims a uppercut to the chin of the opponent");
        } else if (userCommand.equals("head kick")) {
            return ("Jemad aims a strong high kick the the side of the opponents head");
        } else if (userCommand.equals("hip throw")) {
            return ("Jemad grabs the enemy and shifts his weight to throw them over his hip");
        } else {
            return "not a valid move";
        }
    }

    public static int randomDamage(int min, int max){
         int randomDamage = min + (int)(Math.random() * ((max - min) + 1));
         return randomDamage;
    }
}
