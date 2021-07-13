package com.combat;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Scanner;

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

    public static void printStoryIntro(JSONObject story, String enemy) throws JSONException {
        Scanner userInput = new Scanner(System.in);
        ArrayList<String> scenes = new ArrayList<>();
        switch(enemy){
            case "bouncer":
                String intro1 = (String) story.getJSONObject("Bar").getJSONObject("Outside Bar").getString("Intro1");
                String intro2 = (String) story.getJSONObject("Bar").getJSONObject("Outside Bar").getString("Intro2");
                String intro3 = (String) story.getJSONObject("Bar").getJSONObject("Outside Bar").getString("Intro3");
                String comIntro = (String) story.getJSONObject("Bar").getJSONObject("Outside Bar").getString("Combat intro bar");
                scenes.add(intro1);
                scenes.add(intro2);
                scenes.add(intro3);
                scenes.add(comIntro);
                break;
            case "security guard":
                String ibi1 = (String) story.getJSONObject("Bar").getJSONObject("Inside bar").getString("Intro1");
                String ibi2 = (String) story.getJSONObject("Bar").getJSONObject("Inside bar").getString("Intro2");
                String ibi3 = (String) story.getJSONObject("Bar").getJSONObject("Inside bar").getString("Intro3");
                String ibci = (String) story.getJSONObject("Bar").getJSONObject("Inside bar").getString("Combat intro bar");
                scenes.add(ibi1);
                scenes.add(ibi2);
                scenes.add(ibi3);
                scenes.add(ibci);
                break;
            case "pool shark":
                String pri1 = (String) story.getJSONObject("Bar").getJSONObject("Pool Room").getString("Intro1");
                String pri2 = (String) story.getJSONObject("Bar").getJSONObject("Pool Room").getString("Intro2");
                String pri3 = (String) story.getJSONObject("Bar").getJSONObject("Pool Room").getString("Intro3");
                String prci = (String) story.getJSONObject("Bar").getJSONObject("Pool Room").getString("Combat intro Pool Room");
                scenes.add(pri1);
                scenes.add(pri2);
                scenes.add(pri3);
                scenes.add(prci);
                break;
            case "biker": break;

            case "pool boy":
                String pdi1 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck").getString("Intro1");
                String pdi2 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck").getString("Intro2");
                String pdi3 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck").getString("Intro3");
                String pdci = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck").getString("Combat intro Pool Room");
                scenes.add(pdi1);
                scenes.add(pdi2);
                scenes.add(pdi3);
                scenes.add(pdci);
                break;
            case "locker guard":
                String lri1 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Locker Room").getString("Intro1");
                String lri2 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Locker Room").getString("Intro2");
                String lri3 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Locker Room").getString("Intro3");
                String lrci = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Locker Room").getString("Combat intro Locker Room");
                scenes.add(lri1);
                scenes.add(lri2);
                scenes.add(lri3);
                scenes.add(lrci);
                break;
            case "dishwasher":
                String pbi1 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Bar").getString("Intro1");
                String pbi2 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Bar").getString("Intro2");
                String pbi3 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Bar").getString("Intro3");
                String pbci = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Bar").getString("Combat intro Pool bar");
                scenes.add(pbi1);
                scenes.add(pbi2);
                scenes.add(pbi3);
                scenes.add(pbci);
                break;
            case "slots guard":
                String cfi1 = (String) story.getJSONObject("Casino Floor").getJSONObject("Slot Machines").getString("Intro1");
                String cfi2 = (String) story.getJSONObject("Casino Floor").getJSONObject("Slot Machines").getString("Intro2");
                String cfi3 = (String) story.getJSONObject("Casino Floor").getJSONObject("Slot Machines").getString("Intro3");
                String cfci = (String) story.getJSONObject("Casino Floor").getJSONObject("Slot Machines").getString("Combat intro Slot Machines");
                scenes.add(cfi1);
                scenes.add(cfi2);
                scenes.add(cfi3);
                scenes.add(cfci);
                break;
            case "pit guard":
                String pti1 = (String) story.getJSONObject("Casino Floor").getJSONObject("Poker Tables").getString("Intro1");
                String pti2 = (String) story.getJSONObject("Casino Floor").getJSONObject("Poker Tables").getString("Intro2");
                String pti3 = (String) story.getJSONObject("Casino Floor").getJSONObject("Poker Tables").getString("Intro3");
                String ptci = (String) story.getJSONObject("Casino Floor").getJSONObject("Poker Tables").getString("Combat Intro Poker Table");
                scenes.add(pti1);
                scenes.add(pti2);
                scenes.add(pti3);
                scenes.add(ptci);
                break;
            case "chef":
                String shi1 = (String) story.getJSONObject("Casino Floor").getJSONObject("Steak House").getString("Intro1");
                String shi2 = (String) story.getJSONObject("Casino Floor").getJSONObject("Steak House").getString("Intro2");
                String shi3 = (String) story.getJSONObject("Casino Floor").getJSONObject("Steak House").getString("Intro3");
                String shci = (String) story.getJSONObject("Casino Floor").getJSONObject("Steak House").getString("Combat intro Steak House");
                scenes.add(shi1);
                scenes.add(shi2);
                scenes.add(shi3);
                scenes.add(shci);
                break;
            case "elevator man":
                String ei1 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Elevator").getString("Intro1");
                String ei2 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Elevator").getString("Intro2");
                String ei3 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Elevator").getString("Intro3");
                String eci = (String) story.getJSONObject("Hotel Suite").getJSONObject("Elevator").getString("Combat intro Elevator");
                scenes.add(ei1);
                scenes.add(ei2);
                scenes.add(ei3);
                scenes.add(eci);
                break;
            case "hall guard":
                String hhi1 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Hotel Halls").getString("Intro1");
                String hhi2 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Hotel Halls").getString("Intro2");
                String hhi3 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Hotel Halls").getString("Intro3");
                String hhci = (String) story.getJSONObject("Hotel Suite").getJSONObject("Hotel Halls").getString("Combat intro Hotel Halls");
                scenes.add(hhi1);
                scenes.add(hhi2);
                scenes.add(hhi3);
                scenes.add(hhci);
                break;
            case "ninja":
                String bi1 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Balcony").getString("Intro1");
                String bi2 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Balcony").getString("Intro2");
                String bi3 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Balcony").getString("Intro3");
                String bci = (String) story.getJSONObject("Hotel Suite").getJSONObject("Balcony").getString("Combat intro Balcony");
                scenes.add(bi1);
                scenes.add(bi2);
                scenes.add(bi3);
                scenes.add(bci);
                break;
            case "Bartender":
                String abbi1 = (String) story.getJSONObject("Bar").getJSONObject("Alley Behind Bar").getString("Intro1");
                String abbi2 = (String) story.getJSONObject("Bar").getJSONObject("Alley Behind Bar").getString("Intro2");
                String abbi3 = (String) story.getJSONObject("Bar").getJSONObject("Alley Behind Bar").getString("Intro3");
                String abbci = (String) story.getJSONObject("Bar").getJSONObject("Alley Behind Bar").getString("Combat intro Bar alley");
                scenes.add(abbi1);
                scenes.add(abbi2);
                scenes.add(abbi3);
                scenes.add(abbci);
                break;
            case "Life Guard": break;
            case "Pit Boss":
                String vri1 = (String) story.getJSONObject("Casino Floor").getJSONObject("VIP Room").getString("Intro1");
                String vri2 = (String) story.getJSONObject("Casino Floor").getJSONObject("VIP Room").getString("Intro2");
                String vri3 = (String) story.getJSONObject("Casino Floor").getJSONObject("VIP Room").getString("Intro3");
                String vrci = (String) story.getJSONObject("Casino Floor").getJSONObject("VIP Room").getString("Combat Intro VIP Room");
                scenes.add(vri1);
                scenes.add(vri2);
                scenes.add(vri3);
                scenes.add(vrci);
                break;
            case "Big Ben":
                String pduli1 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck Upper Level").getString("Intro1");
                String pduli2 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck Upper Level").getString("Intro2");
                String pduli3 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck Upper Level").getString("Intro3");
                String pdulci = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck Upper Level").getString("Combat intro Pool Deck Upper level");
                scenes.add(pduli1);
                scenes.add(pduli2);
                scenes.add(pduli3);
                scenes.add(pdulci);
                break;
            case "Don Fury":
                String ri1 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Rooftop: Final Boss").getString("Intro1");
                String ri2 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Rooftop: Final Boss").getString("Intro2");
                String ri3 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Rooftop: Final Boss").getString("Intro3");
                String rci = (String) story.getJSONObject("Hotel Suite").getJSONObject("Rooftop: Final Boss").getString("Combat intro Rooftop: Final Boss");
                scenes.add(ri1);
                scenes.add(ri2);
                scenes.add(ri3);
                scenes.add(rci);
                break;


        }
        for(String line: scenes){
            System.out.println(line);
            System.out.println("Enter to continue: ");
            String nextLine = userInput.nextLine().toLowerCase();
        }
        scenes.clear();
    }

    public static void printStoryOutro(JSONObject story, String enemy) throws JSONException {
            Scanner userInput = new Scanner(System.in);
            ArrayList<String> scenes = new ArrayList<>();
            switch(enemy){
                case "bouncer":
                    String outro1 = (String) story.getJSONObject("Bar").getJSONObject("Outside Bar").getString("Combat outro bar");
                    scenes.add(outro1);
                    break;
                case "security guard":
                    String ibo1 = (String) story.getJSONObject("Bar").getJSONObject("Inside bar").getString("Combat outro bar");
                    String ibo2 = (String) story.getJSONObject("Bar").getJSONObject("Inside bar").getString("Inside bar outro");
                    scenes.add(ibo1);
                    scenes.add(ibo2);
                    break;

                case "pool shark":
                    String pro1 = (String) story.getJSONObject("Bar").getJSONObject("Pool Room").getString("Combat outro Pool Room");
                    scenes.add(pro1);
                    break;

                case "biker": break;

                case "pool boy":
                    String pdo = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck").getString("Combat outro Pool Room");
                    scenes.add(pdo);
                    break;

                case "locker guard":
                    String lro = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Locker Room").getString("Combat outro locker Room");
                    scenes.add(lro);
                    break;

                case "dishwasher":
                    String pbi1 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Bar").getString("Combat outro Pool bar");
                    scenes.add(pbi1);
                    break;
                case "slots guard":
                    String cfo = (String) story.getJSONObject("Casino Floor").getJSONObject("Slot Machines").getString("Combat outro Slot Machines");
                    scenes.add(cfo);
                    break;

                case "pit guard":
                    String pto = (String) story.getJSONObject("Casino Floor").getJSONObject("Poker Tables").getString("Combat outro Poker Table");
                    scenes.add(pto);
                    break;

                case "chef":
                    String shi1 = (String) story.getJSONObject("Casino Floor").getJSONObject("Steak House").getString("Combat outro Steak House");
                    scenes.add(shi1);
                    break;
                case "elevator man":
                    String ei1 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Elevator").getString("Combat outro Elevator");
                    scenes.add(ei1);
                    break;

                case "hall guard":
                    String hhi1 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Hotel Halls").getString("Combat outro Hotel halls");
                    scenes.add(hhi1);
                    break;
                case "ninja":
                    String bi1 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Balcony").getString("Combat outro Balcony");
                    scenes.add(bi1);
                    break;
                case "Bartender":
                    String abbo = (String) story.getJSONObject("Bar").getJSONObject("Alley Behind Bar").getString("Combat outro Bar alley");

                    scenes.add(abbo);
                    break;

                case "Life Guard": break;
                case "Pit Boss":
                    String vri1 = (String) story.getJSONObject("Casino Floor").getJSONObject("VIP Room").getString("Combat outro VIP Room");
                    scenes.add(vri1);
                    break;

                case "Big Ben":
                    String pduli1 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck Upper Level").getString("Combat outro Pool Deck Upper level");
                    scenes.add(pduli1);
                    break;

                case "Don Fury":
                    String ri1 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Rooftop: Final Boss").getString("Combat outro Rooftop: Final Boss");
                    scenes.add(ri1);
                    break;


            }
            for(String line: scenes){
                System.out.println(line);
                System.out.println("Enter to continue: ");
                String nextLine = userInput.nextLine().toLowerCase();
            }
            scenes.clear();



    }
}
