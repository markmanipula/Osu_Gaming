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
    public HashMap<String, Integer> enemiesCreator(){

        // enemy#1 'Bouncer'
        HashMap<String, Integer> bouncer = new HashMap<>();
        bouncer.put("Max Health", 100);
        bouncer.put("Attack", 5);

        return bouncer;

//        // enemy#2 'Security Guard'
//        HashMap<String, Integer> securityGuard = new HashMap<>();
//        securityGuard.put("Max Health", 100);
//        securityGuard.put("Attack", 5);
//
//        return securityGuard;
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
