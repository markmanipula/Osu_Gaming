package com.combat;

public class CombatDialogue {

    public static void printCombatIntro(){
        try {
            System.out.println("The Bouncer recognizes him from the warning pictures his boss posted..");
            System.out.println("He quickly straightens up and rushes to attack me...");
            Thread.sleep(8000);
            System.out.println("Think quick Jemad.. what will you attack?");

        }catch (InterruptedException e){
            System.err.format("An error occured + " + e);
        }
    }
    public static void printCombatOutro(){
        System.out.println("==============================================================");
        System.out.println("Guess he was not as tough as he thought..");
    }
}
