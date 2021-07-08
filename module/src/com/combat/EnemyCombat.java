package com.combat;

import java.util.*;

import com.game.*;
import com.map.*;
import com.map.Map;

public class EnemyCombat extends SotfCharacters{


    public EnemyCombat(String name) {
        super(name, 50, 50);
    }

    public ArrayList<String> enemyMoves() {
        //hashmap for enemy attacks
        HashMap<String, Integer> enemyAttack = new HashMap<>();
        //set dmg to 5 for testing purposes
        enemyAttack.put("Punch", 5);
        enemyAttack.put("Kick", 5);
        //create Set of Strings to store non-duplicate items
        Set<String> keySet = enemyAttack.keySet();
        //
        List<String> keyList = new ArrayList<>(keySet);
        int size = keyList.size();
        int random = new Random().nextInt(size);
        String randomKey = keyList.get(random);
        Integer randomValue = enemyAttack.get(randomKey);
        ArrayList<String> output = new ArrayList<>();
        output.add(randomKey);
        output.add(randomValue.toString());

        return output;
    }

    //

    // hashmap for enemies
    public HashMap<String, Integer> bouncerEnemy() {

        // enemy#1 'Bouncer'
        HashMap<String, Integer> bouncer = new HashMap<>();
        bouncer.put("Max Health", 25);
        bouncer.put("Attack", 5);
        return bouncer;
    }
    //hashmap for bodyguard enemy
    public HashMap<String, Integer> bodyGuardEnemy(){
        // enemy#2 'Body Guard'
        HashMap<String, Integer> bodyGuard = new HashMap<>();
        bodyGuard.put("Max Health", 30);
        bodyGuard.put("Attack", 5);

        return bodyGuard;
    }

    //enemy parser
    public HashMap<String, Integer> enemyParser(String enemyType){
        if (enemyType.equals("bouncer")) {
            return bouncerEnemy();
        }else if (enemyType.equals("bodyguard")){
            return bodyGuardEnemy();
        } else {
            return bouncerEnemy();
        }
    }

    // Enemy specific attacks and defense
    @Override
    public String attack(String userCommand) {
        return "";
    }

    @Override
    public String defense(String userCommand) {
        return "";
    }
}
