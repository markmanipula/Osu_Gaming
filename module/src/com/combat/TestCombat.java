package com.combat;

import org.json.JSONException;

import java.io.IOException;

public class TestCombat {
    public static void main(String[] args) throws IOException, JSONException {

        JemadCombat JemadPlayer = new JemadCombat("Jemad");


        PlayerCombatLogic startFight = new PlayerCombatLogic();
        startFight.battleIntro();
        startFight.combatStart("bouncer");
    }
}
