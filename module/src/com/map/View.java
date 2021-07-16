package com.map;

public class View {

    public static void possibleRoutes(String currentRoom){
        switch (currentRoom){
            case "Outside Bar":
                Room.outsideBar();
                break;

            case "Inside Bar":
                Room.insideBar();
                break;

            case "Pool Room":
                Room.poolRoom();
                break;

            case "Alley Behind Bar":
                Room.alleyBehindBar();
                break;

            case "Locker Room":
                Room.lockerRoom();
                break;

            case "Pool Deck":
                Room.poolDeck();
                break;

            case "Pool Bar":
                Room.poolBar();
                break;

            case "Pool Deck: Upper Level":
                Room.poolDeckUpperLevel();
                break;

            case "Slot Machines":
                Room.slotMachines();
                break;

            case "Poker Tables":
                Room.pokerTables();
                break;

            case "Steak House":
                Room.steakhouse();
                break;

            case "VIP Room":
                Room.vipRoom();
                break;

            case "Elevator":
                Room.elevator();
                break;

            case "Hotel Halls":
                Room.hotelHalls();
                break;

            case "Balcony":
                Room.balcony();
                break;

            default:
                Room.rooftopFinalBoss();
        }
    }
}
