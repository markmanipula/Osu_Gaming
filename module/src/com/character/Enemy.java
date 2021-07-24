package com.character;

import com.readjson.ReadEnemyContentJson;

import java.util.*;

public class Enemy {
    private String name;
    private int hp;
    private int minDamage;
    private int maxDamage;

    public Enemy() {
        // empty constructor
    }

    public Enemy(String name) {
        setName(name);
        // these data are set up from Json Enemy
        setHp();
        setMinDamage();
        setMaxDamage();
    }

    // attack
    // helper method to get random damage
    private int randomDamage(int min, int max){
        int randomDamage = min + (int)(Math.random() * ((max - min) + 1));
        return randomDamage;
    }

    public ArrayList<String> enemyAttack() {
        int randomDamage = randomDamage(this.getMinDamage(), this.getMaxDamage());
        HashMap<String, Integer> enemyAttack = new HashMap<>();
        //set dmg to 5 for testing purposes
        enemyAttack.put("Punch", randomDamage);
        enemyAttack.put("Kick", randomDamage);

        int movementSize = enemyAttack.size();
        int randomEnemyMovement = new Random().nextInt(movementSize);

        // random key set
        Set<String> keySet = enemyAttack.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        // Punch or kick
        String enemyRandomMovement = keyList.get(randomEnemyMovement);
        int enemyRandomDamage = enemyAttack.get(enemyRandomMovement);
        // for output
        ArrayList<String> enemyMovement = new ArrayList<>();
        enemyMovement.add(enemyRandomMovement);
        enemyMovement.add(String.valueOf(enemyRandomDamage));
        return enemyMovement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp() {
        this.hp = ReadEnemyContentJson.getSelectedEnemyHeathJson(this.getName());
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage() {
        this.minDamage = ReadEnemyContentJson.getEnemyMinimumDamageJson(this.getName());
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage() {
        this.maxDamage = ReadEnemyContentJson.getEnemyMaximumDamageJson(this.getName());
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", minDamage=" + minDamage +
                ", maxDamage=" + maxDamage +
                '}';
    }
}
