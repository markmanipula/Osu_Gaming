package com.combat;

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
        return 0;
    }
}
