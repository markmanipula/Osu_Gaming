package com.map;

public class View {

    public static void possibleRoutes(String currentRoom){
        switch (currentRoom){
            case "Outside Bar":
                Room.outsideBar(currentRoom);
                break;

            case "Inside Bar":
                Room.insideBar(currentRoom);
                break;

            case "Pool Room":
                Room.poolRoom(currentRoom);
                break;

            case "Alley Behind Bar":
                Room.alleyBehindBar(currentRoom);
                break;

            case "Locker Room":
                Room.lockerRoom(currentRoom);
                break;

            case "Pool Deck":
                Room.poolDeck(currentRoom);
                break;

            case "Pool Bar":
                Room.poolBar(currentRoom);
                break;

            case "Pool Deck: Upper Level":
                Room.poolDeckUpperLevel(currentRoom);
                break;

            case "Slot Machines":
                Room.slotMachines(currentRoom);
                break;

            case "Poker Tables":
                Room.pokerTables(currentRoom);
                break;

            case "Steak House":
                Room.steakhouse(currentRoom);
                break;

            case "VIP Room":
                Room.vipRoom(currentRoom);
                break;

            case "Elevator":
                Room.elevator(currentRoom);
                break;

            case "Hotel Halls":
                Room.hotelHalls(currentRoom);
                break;

            case "Balcony":
                Room.balcony(currentRoom);
                break;

            default:
                Room.rooftopFinalBoss(currentRoom);
        }
    }
}
