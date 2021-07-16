package com.map;

public class Room {

    public static void outsideBar(String currentRoom){
        System.out.println(" ________________________\n" +
                "|                        |\n" +
                "|                        |");
        System.out.println("|\t\t" + currentRoom + "\t\t |" + "  ----->   Inside Bar");
        System.out.println("|                        |\n" +
                "|                        |\n" +
                "|________________________|\n");

    }

    public static void insideBar(String currentRoom){
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |");
        System.out.println("Outside Bar   <-----  " + "|\t\t" + currentRoom + " \t\t   |");
        System.out.println("                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("\t\t\t\t\t\t\t   " + "Pool Room" );

    }

    public static void poolRoom(String currentRoom){
        System.out.println("\t\t\t\t\t\t\t  " + "Inside Bar" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |");
        System.out.println( "\t\t\t\t\t  |\t\t" + currentRoom + "\t\t   |" + "  ----->   Alley Behind Bar");
        System.out.println("                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
    }

    public static void alleyBehindBar(String currentRoom){
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |");
        System.out.println(" Pool Room    <-----  " + "|\t\t" + currentRoom + "   |" + "  ----->   Locker Room");
        System.out.println("                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");

    }

    public static void lockerRoom(String currentRoom){
        System.out.println("                            ________________________\n" +
                "                           |                        |\n" +
                "                           |                        |");
        System.out.println("Alley Behind Bar   <-----  " + "|\t  " + currentRoom + "  \t\t|");
        System.out.println("                           |                        |\n" +
                "                           |                        |\n" +
                "                           |________________________|\n");
        System.out.println("\t\t\t\t\t\t\t\t   " + "     |" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "     |" );
        System.out.println("\t\t\t\t\t\t\t   " + "     Pool Bar" );
    }

    public static void poolDeck(String currentRoom){
        System.out.println(" ________________________\n" +
                "|                        |\n" +
                "|                        |");
        System.out.println("|\t\t" + currentRoom + "\t\t |");
        System.out.println("|                        |\n" +
                "|                        |\n" +
                "|________________________|");
        System.out.println("\t\t   " + "|" );
        System.out.println("\t\t   " + "|" );
        System.out.println("Pool Deck: Upper Level" );

    }

    public static void poolBar(String currentRoom){
        System.out.println("\t\t\t\t\t\t\t  " + "Locker Room" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |");
        System.out.println( "\t\t\t\t\t  |\t\t\t" + currentRoom + "\t   |" + "  ----->   Pool Deck: Upper Level");
        System.out.println("                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");


    }

    public static void poolDeckUpperLevel(String currentRoom){
        System.out.println("\t\t\t\t\t\t" + "\t   Pool Deck" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |");
        System.out.println("Pool Bar   <-----  " + "   | " + currentRoom + " |");
        System.out.println("                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("\t\t\t\t\t\t\t  " + "Slot Machines" );
    }

    public static void slotMachines(String currentRoom){
        System.out.println("\t\t\t\t\t\t" + "Pool Deck: Upper Level" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |");
        System.out.println("\t\t\t\t\t  |\t\t" + currentRoom + "\t   |" + "  ----->   Poker Tables");
        System.out.println("                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("\t\t\t\t\t\t" + "\t   Steak House" );
    }

    public static void pokerTables(String currentRoom){
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |");
        System.out.println("Slot Machines  <----  " + "|\t\t" + currentRoom + "\t   |");
        System.out.println("                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|");
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("\t\t\t\t\t\t\t  " + "  VIP Room" );

    }

    public static void steakhouse(String currentRoom){
        System.out.println("\t\t\t\t\t\t\t  " + "Slot Machines" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |");
        System.out.println( "\t\t\t\t\t  |\t\t  " + currentRoom + "\t   |" + "  ----->   VIP Room");
        System.out.println("                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
    }

    public static void vipRoom(String currentRoom){
        System.out.println("\t\t\t\t\t\t" + "\t  Poker Tables" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |");
        System.out.println(" Steak House  <-----  " + "|\t\t\t" + currentRoom + "\t   |" + "  ----->   Elevator");
        System.out.println("                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
    }

    public static void elevator(String currentRoom){
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |");
        System.out.println(" VIP Room     <-----  " + "|\t\t   " + currentRoom + "\t\t   |" + "  ----->   Hotel Halls");
        System.out.println("                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
    }

    public static void hotelHalls(String currentRoom){
        System.out.println("                            ________________________\n" +
                "                           |                        |\n" +
                "                           |                        |");
        System.out.println("\t\tElevator   <-----" + "  |\t  " + currentRoom + "  \t\t|");
        System.out.println("                           |                        |\n" +
                "                           |                        |\n" +
                "                           |________________________|\n");
        System.out.println("\t\t\t\t\t\t\t\t   " + "     |" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "     |" );
        System.out.println("\t\t\t\t\t\t\t   " + "      Balcony" );

    }

    public static void balcony(String currentRoom){
        System.out.println("\t\t\t\t\t\t\t  " + "Hotel Halls" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("\t\t\t\t\t\t\t\t   " + "|" );
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |");
        System.out.println( "\t\t\t\t\t  |\t\t\t" + currentRoom + "\t\t   |" + "  ----->   Rooftop");
        System.out.println("                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
    }

    public static void rooftopFinalBoss(String currentRoom){
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |");
        System.out.println("\tBalcony   <-----  " + "|\t " + currentRoom + "   |");
        System.out.println("                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
    }



}
