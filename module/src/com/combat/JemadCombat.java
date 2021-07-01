package com.combat;

import com.game.*;
import com.map.*;

public class JemadCombat extends SotfCharacters{


    // array of Jemad basic attack and defense options
    public String[] jemadAttacks = {"Straight Punch", "Push Kick", "Uppercut", "Head Kick", "Hip Throw"};
    public String[] jemadDefense = {"Dodge", "Parry", "Block", "Duck"};

    // whatever the name of the method is
    // within the PlayerCombatLogic

    public JemadCombat(String name) {
        super(name, 100, 100);
    }

    @Override
    public int defense() {
        return 0;
    }

    // Jemad specific methods
    @Override
    public int attack() {
        if (jemadAttacks.equals("Straight Punch")) {
            System.out.println("Jemad plants his feet and throws a straight punch!");
        } else if (jemadAttacks.equals("Push Kick")) {
            System.out.println("Jemad quickly aims a push kick the enemies mid section");
        } else if (jemadAttacks.equals("Uppercut")) {
            System.out.println("Jemad aims a uppercut to the chin of the opponent");
        } else if (jemadAttacks.equals("Head Kick")) {
            System.out.println("Jemad aims a strong high kick the the side of the opponents head");
        } else if (jemadAttacks.equals("Hip Throw")) {
            System.out.println("Jemad grabs the enemy and shifts his weight to throw them over his hip");
        }
        return 0;
    }
}
