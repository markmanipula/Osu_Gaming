package com.combat;

import java.util.HashMap;

public class JemadCombat extends SotfCharacters{


    // array of Jemad basic attack and defense options
    public String[] jemadAttacks = {"straight punch", "push kick", "uppercut", "head Kick", "hip throw"};
    public String[] jemadDefense = {"Dodge", "Parry", "Block", "Duck"};

    //Hashmap for Jemad attack and damage
    public int jemadMoves (String moves) {

        HashMap<String, Integer> jemadMoves = new HashMap<>();
        jemadMoves.put("straight punch", 5);
        jemadMoves.put("push kick", 5);
        jemadMoves.put("uppercut", 5);
        jemadMoves.put("head kick", 5);
        jemadMoves.put("hip throw", 5);
        //outputs 0 damage when not a valid move
        jemadMoves.put(moves, 0);

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
    }
