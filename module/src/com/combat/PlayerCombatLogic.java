package com.combat;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class PlayerCombatLogic {
    // basic fight actions for Jemad


    // this is a test for fight intro
    public void startIntro(){

        try {
            System.out.println("============================================================");
            System.out.println("As Jemad walks up to the bar, he can smell the cheap cologne and heavily whiskied breath of the high-end bouncer");
            System.out.println("To get into the bar, he knows he will have to quickly deal with this guy and slip in unnoticed....");
            System.out.println("=============================================================");

            Thread.sleep(8000);
            System.out.println("The Bouncer recognizes him from the warning pictures his boss posted..");
            System.out.println("He quickly straightens up and rushes to attack me...");
            Thread.sleep(8000);
            System.out.println("Think quick Jemad.. what will you do....?");

            // call combat method for JemadCombat

        }catch (InterruptedException e){
            System.err.format("An error occured + " + e);
        }
    }
}
