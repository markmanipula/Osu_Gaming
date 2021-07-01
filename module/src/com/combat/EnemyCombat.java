package com.combat;

import java.util.HashMap;
import com.game.*;
import com.map.*;

public class EnemyCombat extends SotfCharacters{


    public EnemyCombat(String name) {
        super(name, 50, 50);
    }

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
