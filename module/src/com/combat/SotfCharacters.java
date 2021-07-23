package com.combat;

import com.game.*;
import com.map.*;

public abstract class SotfCharacters {

    // variables that will apply to both Jemad(The main character) and his Enemies(Will be different types)
    // Variables for max and current HP
    public String name;
    public int characterMaxHP, characterCurrentHp;

    // default constructor
    public SotfCharacters() {
        // empty constructor
    }

    // Constructor for Jemad and enemies
    public SotfCharacters(String name, int maxHP, int currentHp){
        this.name = name;
        this.characterMaxHP = maxHP;
        this.characterCurrentHp = currentHp;
    }

    // abstract methods for attacks
    public abstract String attack(String userCommand);

    // abstract methods for defense
    public abstract String defense(String userCommand);


}
