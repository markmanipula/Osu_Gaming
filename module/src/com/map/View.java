package com.map;

public class View {

    public static void possibleRoutes(String currentRoom){
        switch (currentRoom){
            case "Outside Bar":
                System.out.println(Room.outsideBar());
                break;

            case "Inside Bar":
                System.out.println(Room.insideBar());
                break;

            case "Pool Room":
                System.out.println(Room.poolRoom());
                break;

            case "Alley Behind Bar":
                System.out.println(Room.alleyBehindBar());;
                break;

            case "Locker Room":
                System.out.println(Room.lockerRoom());
                break;

            case "Pool Deck":
                System.out.println(Room.poolDeck());
                break;

            case "Pool Bar":
                System.out.println(Room.poolBar());
                break;

            case "Pool Deck: Upper Level":
                System.out.println(Room.poolDeckUpperLevel());
                break;

            case "Slot Machines":
                System.out.println(Room.slotMachines());
                break;

            case "Poker Tables":
                System.out.println(Room.pokerTables());
                break;

            case "Steak House":
                System.out.println(Room.steakhouse());
                break;

            case "VIP Room":
                System.out.println(Room.vipRoom());
                break;

            case "Elevator":
                System.out.println(Room.elevator());
                break;

            case "Hotel Halls":
                System.out.println(Room.hotelHalls());
                break;

            case "Balcony":
                System.out.println(Room.balcony());
                break;

            default:
                System.out.println(Room.rooftopFinalBoss());
        }
    }
}
