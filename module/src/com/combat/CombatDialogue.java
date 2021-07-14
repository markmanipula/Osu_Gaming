package com.combat;

import com.game.GameStart;
import org.json.simple.JSONObject;
//import org.json.JSONException;
//import org.json.JSONObject;

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

    public static void printStoryIntro(JSONObject story, String enemy) {
        Scanner userInput = new Scanner(System.in);
        ArrayList<String> scenes = new ArrayList<>();
        switch(enemy){
            case "bouncer":
                JSONObject bouncerBar = (JSONObject) story.get("Bar");
                JSONObject bouncerOutSideBar = (JSONObject) bouncerBar.get("Outside Bar");
                String intro1 = String.valueOf(bouncerOutSideBar.get("Intro1"));
                String intro2 = String.valueOf(bouncerOutSideBar.get("Intro2"));
                String intro3 = String.valueOf(bouncerOutSideBar.get("Intro3"));
                String comIntro = String.valueOf(bouncerOutSideBar.get("Combat intro bar"));
//                String intro1 = (JSONObject)story.get("Bar").get("Outside Bar").getString("Intro1");
//                String intro2 = (String) story.get("Bar").getJSONObject("Outside Bar").getString("Intro2");
//                String intro3 = (String) story.get("Bar").getJSONObject("Outside Bar").getString("Intro3");
//                String comIntro = (String) story.get("Bar").getJSONObject("Outside Bar").getString("Combat intro bar");

                scenes.add(intro1);
                scenes.add(intro2);
                scenes.add(intro3);
                scenes.add(comIntro);
                break;
            case "security guard":
                JSONObject securityGuard= (JSONObject) story.get("Bar");
                JSONObject securityGuardInsideBar = (JSONObject) securityGuard.get("Inside bar");
                String ibi1 = String.valueOf(securityGuardInsideBar.get("Intro1"));
                String ibi2 = String.valueOf(securityGuardInsideBar.get("Intro2"));
                String ibi3 = String.valueOf(securityGuardInsideBar.get("Intro3"));
                String ibci = String.valueOf(securityGuardInsideBar.get("Combat intro bar"));

//                String ibi1 = (String) story.getJSONObject("Bar").getJSONObject("Inside bar").getString("Intro1");
//                String ibi2 = (String) story.getJSONObject("Bar").getJSONObject("Inside bar").getString("Intro2");
//                String ibi3 = (String) story.getJSONObject("Bar").getJSONObject("Inside bar").getString("Intro3");
//                String ibci = (String) story.getJSONObject("Bar").getJSONObject("Inside bar").getString("Combat intro bar");
                scenes.add(ibi1);
                scenes.add(ibi2);
                scenes.add(ibi3);
                scenes.add(ibci);
                break;
            case "pool shark":
                JSONObject poolShark= (JSONObject) story.get("Bar");
                JSONObject poolSharkPoolRoom = (JSONObject) poolShark.get("Pool Room");
                String pri1 = String.valueOf(poolSharkPoolRoom.get("Intro1"));
                String pri2 = String.valueOf(poolSharkPoolRoom.get("Intro2"));
                String pri3 = String.valueOf(poolSharkPoolRoom.get("Intro3"));
                String prci = String.valueOf(poolSharkPoolRoom.get("Combat intro Pool Room"));

//                String pri1 = (String) story.getJSONObject("Bar").getJSONObject("Pool Room").getString("Intro1");
//                String pri2 = (String) story.getJSONObject("Bar").getJSONObject("Pool Room").getString("Intro2");
//                String pri3 = (String) story.getJSONObject("Bar").getJSONObject("Pool Room").getString("Intro3");
//                String prci = (String) story.getJSONObject("Bar").getJSONObject("Pool Room").getString("Combat intro Pool Room");
                scenes.add(pri1);
                scenes.add(pri2);
                scenes.add(pri3);
                scenes.add(prci);
                break;
            case "biker": break;

            case "pool boy":
                JSONObject poolBoy = (JSONObject) story.get("Pool & Cabanas");
                JSONObject poolBoyPoolRoom = (JSONObject) poolBoy.get("Pool Room");
                String pdi1 = String.valueOf(poolBoyPoolRoom.get("Intro1"));
                String pdi2 = String.valueOf(poolBoyPoolRoom.get("Intro2"));
                String pdi3 = String.valueOf(poolBoyPoolRoom.get("Intro3"));
                String pdci = String.valueOf(poolBoyPoolRoom.get("Combat intro Pool Room"));

//                String pdi1 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck").getString("Intro1");
//                String pdi2 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck").getString("Intro2");
//                String pdi3 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck").getString("Intro3");
//                String pdci = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck").getString("Combat intro Pool Room");
                scenes.add(pdi1);
                scenes.add(pdi2);
                scenes.add(pdi3);
                scenes.add(pdci);
                break;
            case "locker guard":
                JSONObject lockerGuard = (JSONObject) story.get("Pool & Cabanas");
                JSONObject lockerGuardPoolRoom = (JSONObject) lockerGuard.get("Locker Room");
                String lri1 = String.valueOf(lockerGuardPoolRoom.get("Intro1"));
                String lri2 = String.valueOf(lockerGuardPoolRoom.get("Intro2"));
                String lri3 = String.valueOf(lockerGuardPoolRoom.get("Intro3"));
                String lrci = String.valueOf(lockerGuardPoolRoom.get("Combat intro Pool Room"));

//                String lri1 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Locker Room").getString("Intro1");
//                String lri2 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Locker Room").getString("Intro2");
//                String lri3 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Locker Room").getString("Intro3");
//                String lrci = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Locker Room").getString("Combat intro Locker Room");
                scenes.add(lri1);
                scenes.add(lri2);
                scenes.add(lri3);
                scenes.add(lrci);
                break;
            case "dishwasher":
                JSONObject dishWasher = (JSONObject) story.get("Pool & Cabanas");
                JSONObject dishWasherPoolBar = (JSONObject) dishWasher.get("Pool Bar");
                String pbi1 = String.valueOf(dishWasherPoolBar.get("Intro1"));
                String pbi2 = String.valueOf(dishWasherPoolBar.get("Intro2"));
                String pbi3 = String.valueOf(dishWasherPoolBar.get("Intro3"));
                String pbci = String.valueOf(dishWasherPoolBar.get("Combat intro Pool bar"));

//                String pbi1 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Bar").getString("Intro1");
//                String pbi2 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Bar").getString("Intro2");
//                String pbi3 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Bar").getString("Intro3");
//                String pbci = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Bar").getString("Combat intro Pool bar");
                scenes.add(pbi1);
                scenes.add(pbi2);
                scenes.add(pbi3);
                scenes.add(pbci);
                break;
            case "slots guard":
                JSONObject slotsGuard = (JSONObject) story.get("Casino Floor");
                JSONObject slotsGuardCasinoFloor = (JSONObject) slotsGuard.get("Slot Machines");
                String cfi1 = String.valueOf(slotsGuardCasinoFloor.get("Intro1"));
                String cfi2 = String.valueOf(slotsGuardCasinoFloor.get("Intro2"));
                String cfi3 = String.valueOf(slotsGuardCasinoFloor.get("Intro3"));
                String cfci = String.valueOf(slotsGuardCasinoFloor.get("Combat intro Slot Machines"));
//                String cfi1 = (String) story.getJSONObject("Casino Floor").getJSONObject("Slot Machines").getString("Intro1");
//                String cfi2 = (String) story.getJSONObject("Casino Floor").getJSONObject("Slot Machines").getString("Intro2");
//                String cfi3 = (String) story.getJSONObject("Casino Floor").getJSONObject("Slot Machines").getString("Intro3");
//                String cfci = (String) story.getJSONObject("Casino Floor").getJSONObject("Slot Machines").getString("Combat intro Slot Machines");
                scenes.add(cfi1);
                scenes.add(cfi2);
                scenes.add(cfi3);
                scenes.add(cfci);
                break;
            case "pit guard":
                JSONObject pitGuard = (JSONObject) story.get("Casino Floor");
                JSONObject pitGuardCasinoFloor = (JSONObject) pitGuard.get("Slot Machines");
                String pti1 = String.valueOf(pitGuardCasinoFloor.get("Intro1"));
                String pti2 = String.valueOf(pitGuardCasinoFloor.get("Intro2"));
                String pti3 = String.valueOf(pitGuardCasinoFloor.get("Intro3"));
                String ptci = String.valueOf(pitGuardCasinoFloor.get("Combat Intro Poker Table"));
//                String pti1 = (String) story.getJSONObject("Casino Floor").getJSONObject("Poker Tables").getString("Intro1");
//                String pti2 = (String) story.getJSONObject("Casino Floor").getJSONObject("Poker Tables").getString("Intro2");
//                String pti3 = (String) story.getJSONObject("Casino Floor").getJSONObject("Poker Tables").getString("Intro3");
//                String ptci = (String) story.getJSONObject("Casino Floor").getJSONObject("Poker Tables").getString("Combat Intro Poker Table");
                scenes.add(pti1);
                scenes.add(pti2);
                scenes.add(pti3);
                scenes.add(ptci);
                break;
            case "chef":
                JSONObject chef = (JSONObject) story.get("Casino Floor");
                JSONObject chefCasinoFloor = (JSONObject) chef.get("Steak House");
                String shi1 = String.valueOf(chefCasinoFloor.get("Intro1"));
                String shi2 = String.valueOf(chefCasinoFloor.get("Intro2"));
                String shi3 = String.valueOf(chefCasinoFloor.get("Intro3"));
                String shci = String.valueOf(chefCasinoFloor.get("Combat intro Steak House"));

//                String shi1 = (String) story.getJSONObject("Casino Floor").getJSONObject("Steak House").getString("Intro1");
//                String shi2 = (String) story.getJSONObject("Casino Floor").getJSONObject("Steak House").getString("Intro2");
//                String shi3 = (String) story.getJSONObject("Casino Floor").getJSONObject("Steak House").getString("Intro3");
//                String shci = (String) story.getJSONObject("Casino Floor").getJSONObject("Steak House").getString("Combat intro Steak House");
                scenes.add(shi1);
                scenes.add(shi2);
                scenes.add(shi3);
                scenes.add(shci);
                break;
            case "elevator man":
                JSONObject elevatorMan = (JSONObject) story.get("Hotel Suite");
                JSONObject elevatorManElevator = (JSONObject) elevatorMan.get("Elevator");
                String ei1 = String.valueOf(elevatorManElevator.get("Intro1"));
                String ei2 = String.valueOf(elevatorManElevator.get("Intro2"));
                String ei3 = String.valueOf(elevatorManElevator.get("Intro3"));
                String eci = String.valueOf(elevatorManElevator.get("Combat intro Elevator"));

//                String ei1 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Elevator").getString("Intro1");
//                String ei2 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Elevator").getString("Intro2");
//                String ei3 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Elevator").getString("Intro3");
//                String eci = (String) story.getJSONObject("Hotel Suite").getJSONObject("Elevator").getString("Combat intro Elevator");
                scenes.add(ei1);
                scenes.add(ei2);
                scenes.add(ei3);
                scenes.add(eci);
                break;
            case "hall guard":
                JSONObject hallGuard = (JSONObject) story.get("Hotel Suite");
                JSONObject hallGuardHotelHall = (JSONObject) hallGuard.get("Hotel Halls");
                String hhi1 = String.valueOf(hallGuardHotelHall.get("Intro1"));
                String hhi2 = String.valueOf(hallGuardHotelHall.get("Intro2"));
                String hhi3 = String.valueOf(hallGuardHotelHall.get("Intro3"));
                String hhci = String.valueOf(hallGuardHotelHall.get("Combat intro Hotel Halls"));

//                String hhi1 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Hotel Halls").getString("Intro1");
//                String hhi2 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Hotel Halls").getString("Intro2");
//                String hhi3 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Hotel Halls").getString("Intro3");
//                String hhci = (String) story.getJSONObject("Hotel Suite").getJSONObject("Hotel Halls").getString("Combat intro Hotel Halls");
                scenes.add(hhi1);
                scenes.add(hhi2);
                scenes.add(hhi3);
                scenes.add(hhci);
                break;
            case "ninja":
                JSONObject ninja = (JSONObject) story.get("Hotel Suite");
                JSONObject ninjaBalcony = (JSONObject) ninja.get("Balcony");
                String bi1 = String.valueOf(ninjaBalcony.get("Intro1"));
                String bi2 = String.valueOf(ninjaBalcony.get("Intro2"));
                String bi3 = String.valueOf(ninjaBalcony.get("Intro3"));
                String bci = String.valueOf(ninjaBalcony.get("Combat intro Balcony"));

//                String bi1 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Balcony").getString("Intro1");
//                String bi2 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Balcony").getString("Intro2");
//                String bi3 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Balcony").getString("Intro3");
//                String bci = (String) story.getJSONObject("Hotel Suite").getJSONObject("Balcony").getString("Combat intro Balcony");
                scenes.add(bi1);
                scenes.add(bi2);
                scenes.add(bi3);
                scenes.add(bci);
                break;
            case "bartender":
                JSONObject bartender = (JSONObject) story.get("Bar");
                JSONObject bartenderAlley = (JSONObject) bartender.get("Alley Behind Bar");
                String abbi1 = String.valueOf(bartenderAlley.get("Intro1"));
                String abbi2 = String.valueOf(bartenderAlley.get("Intro2"));
                String abbi3 = String.valueOf(bartenderAlley.get("Intro3"));
                String abbci = String.valueOf(bartenderAlley.get("Combat intro Bar alley"));

//                String abbi1 = (String) story.getJSONObject("Bar").getJSONObject("Alley Behind Bar").getString("Intro1");
//                String abbi2 = (String) story.getJSONObject("Bar").getJSONObject("Alley Behind Bar").getString("Intro2");
//                String abbi3 = (String) story.getJSONObject("Bar").getJSONObject("Alley Behind Bar").getString("Intro3");
//                String abbci = (String) story.getJSONObject("Bar").getJSONObject("Alley Behind Bar").getString("Combat intro Bar alley");
                scenes.add(abbi1);
                scenes.add(abbi2);
                scenes.add(abbi3);
                scenes.add(abbci);
                break;
            case "life guard": break;
            case "pit boss":
                JSONObject pitBoss = (JSONObject) story.get("Casino Floor");
                JSONObject pitBossVIPRoom = (JSONObject) pitBoss.get("VIP Room");
                String vri1 = String.valueOf(pitBossVIPRoom.get("Intro1"));
                String vri2 = String.valueOf(pitBossVIPRoom.get("Intro2"));
                String vri3 = String.valueOf(pitBossVIPRoom.get("Intro3"));
                String vrci = String.valueOf(pitBossVIPRoom.get("Combat Intro VIP Room"));

//                String vri1 = (String) story.getJSONObject("Casino Floor").getJSONObject("VIP Room").getString("Intro1");
//                String vri2 = (String) story.getJSONObject("Casino Floor").getJSONObject("VIP Room").getString("Intro2");
//                String vri3 = (String) story.getJSONObject("Casino Floor").getJSONObject("VIP Room").getString("Intro3");
//                String vrci = (String) story.getJSONObject("Casino Floor").getJSONObject("VIP Room").getString("Combat Intro VIP Room");
                scenes.add(vri1);
                scenes.add(vri2);
                scenes.add(vri3);
                scenes.add(vrci);
                break;
            case "big ben":
                JSONObject bigBen = (JSONObject) story.get("Pool & Cabanas");
                JSONObject bigBenPool = (JSONObject) bigBen.get("Pool Deck Upper Level");
                String pduli1 = String.valueOf(bigBenPool.get("Intro1"));
                String pduli2 = String.valueOf(bigBenPool.get("Intro2"));
                String pduli3 = String.valueOf(bigBenPool.get("Intro3"));
                String pdulci = String.valueOf(bigBenPool.get("Combat intro Pool Deck Upper level"));

//                String pduli1 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck Upper Level").getString("Intro1");
//                String pduli2 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck Upper Level").getString("Intro2");
//                String pduli3 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck Upper Level").getString("Intro3");
//                String pdulci = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck Upper Level").getString("Combat intro Pool Deck Upper level");
                scenes.add(pduli1);
                scenes.add(pduli2);
                scenes.add(pduli3);
                scenes.add(pdulci);
                break;
            case "Don Fury":
                JSONObject donFury = (JSONObject) story.get("Hotel Suite");
                JSONObject donFuryFinalBoss = (JSONObject) donFury.get("Rooftop: Final Boss");
                String ri1 = String.valueOf(donFuryFinalBoss.get("Intro1"));
                String ri2 = String.valueOf(donFuryFinalBoss.get("Intro2"));
                String ri3 = String.valueOf(donFuryFinalBoss.get("Intro3"));
                String rci = String.valueOf(donFuryFinalBoss.get("Combat intro Pool Deck Upper level"));


//                String ri1 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Rooftop: Final Boss").getString("Intro1");
//                String ri2 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Rooftop: Final Boss").getString("Intro2");
//                String ri3 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Rooftop: Final Boss").getString("Intro3");
//                String rci = (String) story.getJSONObject("Hotel Suite").getJSONObject("Rooftop: Final Boss").getString("Combat intro Rooftop: Final Boss");
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

    public static void printStoryOutro(JSONObject story, String enemy)  {
            Scanner userInput = new Scanner(System.in);
            ArrayList<String> scenes = new ArrayList<>();
            switch(enemy){
                case "bouncer":
                    JSONObject bouncerBar = (JSONObject) story.get("Bar");
                    JSONObject bouncerOutSideBar = (JSONObject) bouncerBar.get("Outside Bar");
                    String outro1 = String.valueOf(bouncerOutSideBar.get("Combat outro bar"));

                    // String outro1 = (String) story.getJSONObject("Bar").getJSONObject("Outside Bar").getString("Combat outro bar");
                    scenes.add(outro1);
                    break;
                case "security guard":
                    JSONObject securityGuardBar = (JSONObject) story.get("Bar");
                    JSONObject securityGuardOutSideBar = (JSONObject) securityGuardBar.get("Inside bar");
                    String ibo1 = String.valueOf(securityGuardOutSideBar.get("Combat outro bar"));
                    String ibo2 = String.valueOf(securityGuardOutSideBar.get("Inside bar outro"));

//                    String ibo1 = (String) story.getJSONObject("Bar").getJSONObject("Inside bar").getString("Combat outro bar");
//                    String ibo2 = (String) story.getJSONObject("Bar").getJSONObject("Inside bar").getString("Inside bar outro");
                    scenes.add(ibo1);
                    scenes.add(ibo2);
                    break;

                case "pool shark":
                    JSONObject poolShark = (JSONObject) story.get("Bar");
                    JSONObject poolSharkPoolRoom = (JSONObject) poolShark.get("Pool Room");
                    String pro1 = String.valueOf(poolSharkPoolRoom.get("Combat outro Pool Room"));

                    // String pro1 = (String) story.getJSONObject("Bar").getJSONObject("Pool Room").getString("Combat outro Pool Room");
                    scenes.add(pro1);
                    break;

                case "biker": break;

                case "pool boy":
                    JSONObject poolBoy = (JSONObject) story.get("Pool & Cabanas");
                    JSONObject poolBoyPoolDeck = (JSONObject) poolBoy.get("Pool Deck");
                    String pdo = String.valueOf(poolBoyPoolDeck.get("Combat outro Pool Room"));

                    // String pdo = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck").getString("Combat outro Pool Room");
                    scenes.add(pdo);
                    break;

                case "locker guard":
                    JSONObject lockerGuard = (JSONObject) story.get("Pool & Cabanas");
                    JSONObject lockerGuardLockerRoom = (JSONObject) lockerGuard.get("Locker Room");
                    String lro = String.valueOf(lockerGuardLockerRoom.get("Combat outro locker Room"));

                    // String lro = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Locker Room").getString("Combat outro locker Room");
                    scenes.add(lro);
                    break;

                case "dishwasher":
                    JSONObject dishWasher = (JSONObject) story.get("Pool & Cabanas");
                    JSONObject dishWasherPoolBar = (JSONObject) dishWasher.get("Pool Bar");
                    String pbi1 = String.valueOf(dishWasherPoolBar.get("Combat outro Pool bar"));

                    // String pbi1 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Bar").getString("Combat outro Pool bar");
                    scenes.add(pbi1);
                    break;
                case "slots guard":
                    JSONObject slotsGuard = (JSONObject) story.get("Casino Floor");
                    JSONObject slotsGuardSlotMachine = (JSONObject) slotsGuard.get("Slot Machines");
                    String cfo = String.valueOf(slotsGuardSlotMachine.get("Combat outro Slot Machines"));

                    // String cfo = (String) story.getJSONObject("Casino Floor").getJSONObject("Slot Machines").getString("Combat outro Slot Machines");
                    scenes.add(cfo);
                    break;

                case "pit guard":
                    JSONObject pitGuard = (JSONObject) story.get("Casino Floor");
                    JSONObject pitGuardPokerTable = (JSONObject) pitGuard.get("Poker Tables");
                    String pto = String.valueOf(pitGuardPokerTable.get("Combat outro Poker Table"));

                    // String pto = (String) story.getJSONObject("Casino Floor").getJSONObject("Poker Tables").getString("Combat outro Poker Table");
                    scenes.add(pto);
                    break;

                case "chef":
                    JSONObject chef = (JSONObject) story.get("Casino Floor");
                    JSONObject chefSteakHouse = (JSONObject) chef.get("Steak House");
                    String shi1 = String.valueOf(chefSteakHouse.get("Combat outro Steak House"));

                    // String shi1 = (String) story.getJSONObject("Casino Floor").getJSONObject("Steak House").getString("Combat outro Steak House");
                    scenes.add(shi1);
                    break;
                case "elevator man":
                    JSONObject elevatorMan = (JSONObject) story.get("Hotel Suite");
                    JSONObject elevatorManElevator = (JSONObject) elevatorMan.get("Elevator");
                    String ei1 = String.valueOf(elevatorManElevator.get("Combat outro Elevator"));

                    // String ei1 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Elevator").getString("Combat outro Elevator");
                    scenes.add(ei1);
                    break;

                case "hall guard":
                    JSONObject hallGuard = (JSONObject) story.get("Hotel Suite");
                    JSONObject hallGuardHalls = (JSONObject) hallGuard.get("Hotel Halls");
                    String hhi1 = String.valueOf(hallGuardHalls.get("Combat outro Hotel halls"));

                    // String hhi1 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Hotel Halls").getString("Combat outro Hotel halls");
                    scenes.add(hhi1);
                    break;
                case "ninja":
                    JSONObject ninja = (JSONObject) story.get("Hotel Suite");
                    JSONObject ninjaBalcony = (JSONObject) ninja.get("Balcony");
                    String bi1 = String.valueOf(ninjaBalcony.get("Combat outro Balcony"));

                    // String bi1 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Balcony").getString("Combat outro Balcony");
                    scenes.add(bi1);
                    break;
                case "bartender":
                    JSONObject bartender = (JSONObject) story.get("Bar");
                    JSONObject bartenderAlley = (JSONObject) bartender.get("Alley Behind Bar");
                    String abbo = String.valueOf(bartenderAlley.get("Combat outro Bar alley"));

                    // String abbo = (String) story.getJSONObject("Bar").getJSONObject("Alley Behind Bar").getString("Combat outro Bar alley");

                    scenes.add(abbo);
                    break;

                case "life guard": break;
                case "pit boss":
                    JSONObject pitBoss = (JSONObject) story.get("Casino Floor");
                    JSONObject pitBossVIPRoom = (JSONObject) pitBoss.get("VIP Room");
                    String vri1 = String.valueOf(pitBossVIPRoom.get("Combat outro VIP Room"));

                    // String vri1 = (String) story.getJSONObject("Casino Floor").getJSONObject("VIP Room").getString("Combat outro VIP Room");
                    scenes.add(vri1);
                    break;

                case "big ben":
                    JSONObject bigBen = (JSONObject) story.get("Pool & Cabanas");
                    JSONObject bigBenPoolDeck = (JSONObject) bigBen.get("Pool Deck Upper Level");
                    String pduli1 = String.valueOf(bigBenPoolDeck.get("Combat outro Pool Deck Upper level"));

                    // String pduli1 = (String) story.getJSONObject("Pool & Cabanas").getJSONObject("Pool Deck Upper Level").getString("Combat outro Pool Deck Upper level");
                    scenes.add(pduli1);
                    break;

                case "Don Fury":
                    JSONObject donFury = (JSONObject) story.get("Hotel Suite");
                    JSONObject donFuryFinalBoss = (JSONObject) donFury.get("Rooftop: Final Boss");
                    String ri1 = String.valueOf(donFuryFinalBoss.get("Combat outro Rooftop: Final Boss"));

                    JSONObject gameOutroObj = (JSONObject) donFury.get("Game Outro");
                    String gameOutro = String.valueOf(gameOutroObj.get("outro"));

                    // String ri1 = (String) story.getJSONObject("Hotel Suite").getJSONObject("Rooftop: Final Boss").getString("Combat outro Rooftop: Final Boss");
                    // String gameOutro = (String) story.getJSONObject("Hotel Suite").getJSONObject("Game Outro").getString("outro");
                    scenes.add(ri1);
                    scenes.add(gameOutro);
                    break;


            }
            for(String line: scenes){
                System.out.println(line);
                System.out.println("Enter to continue: ");
                String nextLine = userInput.nextLine().toLowerCase();
            }
            scenes.clear();





    }
    public void gameOver(){
        GameStart thisIsTheEnd = new GameStart();
        thisIsTheEnd.gameEnd();
    }
}
