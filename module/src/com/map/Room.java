package com.map;

public class Room {

    public static void outsideBar(){
        System.out.println(" ________________________\n" +
                "|                        |\n" +
                "|                        |\n" +
                "|       Outside Bar      |  ----->   Inside Bar\n" +
                "|                        |\n" +
                "|                        |\n" +
                "|________________________|\n");
    }

    public static void insideBar(){
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "Outside Bar   <-----  |         Inside Bar     |\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n" +
                "\n" +
                "                                   |\n" +
                "                                   |\n" +
                "                               Pool Room");
    }

    public static void poolRoom(){
        System.out.println("\t\t              Inside Bar\n" +
                "\t\t\t\t    |\n" +
                "\t\t\t\t    |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "\t\t      |\t\tPool Room      |  ----->   Alley Behind Bar\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
    }

    public static void alleyBehindBar(){
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                " Pool Room    <-----  |\t    Alley Behind Bar   |  ----->   Locker Room\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");

    }

    public static void lockerRoom(){
        System.out.println("                           ________________________\n" +
                "                          |                        |\n" +
                "                          |                        |\n" +
                "Alley Behind Bar  <-----  |\t  Locker Room      |  ----->   Pool Deck\n" +
                "                          |                        |\n" +
                "                          |                        |\n" +
                "                          |________________________|\n" +
                "                                        |\n" +
                "\t\t\t\t        |\n" +
                "                                    Pool Bar");
    }

    public static void poolDeck(){
        System.out.println("                            ________________________\n" +
                "                           |                        |\n" +
                "                           |                        |\n" +
                "Locker Room   <-----       |\t  Pool Deck  \t    |\n" +
                "                           |                        |\n" +
                "                           |                        |\n" +
                "                           |________________________|\n" +
                "\n" +
                "\t\t\t                |\n" +
                "\t\t                        |\n" +
                "\t\t\t   Pool Deck: Upper Level");

    }

    public static void poolBar(){
        System.out.println("\t\t              Locker Room\n" +
                "\t\t\t\t    |\n" +
                "\t\t\t\t    |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "\t\t      |\t\tPool Bar       |  ----->   Pool Deck: Upper Level\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");

    }

    public static void poolDeckUpperLevel(){
        System.out.println("\t\t\t\tPool Deck\n" +
                "\t\t\t\t    |\n" +
                "\t\t\t\t    |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "Pool Bar   <-----     | Pool Deck: Upper Level |\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n" +
                "\n" +
                "\t\t\t\t   |\n" +
                "\t\t\t\t   |\n" +
                "\t\t\t      Slot Machines");
    }

    public static void slotMachines(){
        System.out.println("\t\t\tPool Deck: Upper Level\n" +
                "\t\t\t\t  |\n" +
                "\t\t\t\t  |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "\t\t      |\t    Slot Machines      |  ----->   Poker Tables\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n" +
                "\n" +
                "\t\t\t\t  |\n" +
                "\t\t\t\t  |\n" +
                "\t\t\t     Steak House");

    }

    public static void pokerTables(){
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "Slot Machines  <----  |\t    Poker Tables       |\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n" +
                "\t\t\t\t |\n" +
                "\t\t\t\t |\n" +
                "\t\t\t      VIP Room");


    }

    public static void steakhouse(){
        System.out.println("\t                    Slot Machines\n" +
                "\t\t\t\t  |\n" +
                "\t\t\t\t  |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "\t\t      |\t     Steak House       |  ----->   VIP Room\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
    }

    public static void vipRoom(){
        System.out.println("\t\t\t     Poker Tables\n" +
                "\t\t\t\t  |\n" +
                "\t\t\t\t  |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                " Steak House  <-----  |\t      VIP Room\t       |  ----->   Elevator\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|");

    }

    public static void elevator(){
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                " VIP Room     <-----  |\t       Elevator\t       |  ----->   Hotel Halls\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|");

    }

    public static void hotelHalls(){
        System.out.println("                            ________________________\n" +
                "                           |                        |\n" +
                "                           |                        |\n" +
                " \tElevator   <-----  |\t  Hotel Halls  \t    |\n" +
                "                           |                        |\n" +
                "                           |                        |\n" +
                "                           |________________________|\n" +
                "\n" +
                "\t\t\t\t\t|\n" +
                "\t\t\t\t\t|\n" +
                "\t\t\t\t     Balcony\n");


    }

    public static void balcony(){
        System.out.println("\t\t              Hotel Halls\n" +
                "\t\t\t\t   |\n" +
                "\t\t\t\t   |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "\t\t      |\t       Balcony\t       |  ----->   Rooftop: Final Boss\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");

    }

    public static void rooftopFinalBoss(){
        System.out.println("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "Balcony   <-----      |   Rooftop: Final Boss  |\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");

    }

    //ASCII Art completed


}
