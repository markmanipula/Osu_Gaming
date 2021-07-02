package com.combat;

public class TestCombat {
    public static void main(String[] args) {

        JemadCombat JemadPlayer = new JemadCombat("Jemad");


        PlayerCombatLogic startFight = new PlayerCombatLogic();
        startFight.battleIntro();
        startFight.combatStart();
    }
}
