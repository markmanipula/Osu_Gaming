package com.combat;

public class CombatDialogue {

    public static void printCombatIntro(){
        try {
            System.out.println("===========================================================");
            System.out.println("The Bouncer recognizes him from the warning pictures his boss posted..");
            System.out.println("He quickly straightens up and rushes to attack me...");
            Thread.sleep(1000);
            System.out.println("Think quick Jemad.. what will you do?");

        }catch (InterruptedException e){
            System.err.format("An error occured + " + e);
        }
    }
    public static void printCombatOutro() throws InterruptedException {
        System.out.println(" ____  __.                     __     ________          __  ._.\n" +
                "|    |/ _| ____   ____   ____ |  | __ \\_____  \\  __ ___/  |_| |\n" +
                "|      <  /    \\ /  _ \\_/ ___\\|  |/ /  /   |   \\|  |  \\   __\\ |\n" +
                "|    |  \\|   |  (  <_> )  \\___|    <  /    |    \\  |  /|  |  \\|\n" +
                "|____|__ \\___|  /\\____/ \\___  >__|_ \\ \\_______  /____/ |__|  __\n" +
                "        \\/    \\/            \\/     \\/         \\/             \\/");
        Thread.sleep(700);

        System.out.println("==============================================================");
        System.out.println("Guess he was not as tough as he thought..");
        System.out.println("All that training and another enemy down!");
    }
}
