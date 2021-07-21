package com.map;

public class Room {

    public static String outsideBar(){
        StringBuilder mapAscii = new StringBuilder();
        mapAscii.append(" ________________________\n" +
                "|                        |\n" +
                "|                        |\n" +
                "|       Outside Bar      |  ----->   Inside Bar\n" +
                "|                        |\n" +
                "|                        |\n" +
                "|________________________|\n");
        return mapAscii.toString();
    }

    public static String insideBar(){
        StringBuilder mapAscii = new StringBuilder();
        mapAscii.append("                       ________________________\n" +
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
        return mapAscii.toString();
    }

    public static String poolRoom(){
        StringBuilder mapAscii = new StringBuilder();
        mapAscii.append("\t\t              Inside Bar\n" +
                "\t\t\t\t    |\n" +
                "\t\t\t\t    |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "\t\t      |\t\tPool Room      |  ----->   Alley Behind Bar\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
        return mapAscii.toString();
    }

    public static String alleyBehindBar(){
        StringBuilder mapAscii = new StringBuilder();
        mapAscii.append("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                " Pool Room    <-----  |\t    Alley Behind Bar   |  ----->   Locker Room\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
        return mapAscii.toString();
    }

    public static String lockerRoom(){
        StringBuilder mapAscii = new StringBuilder();
        mapAscii.append("                           ________________________\n" +
                "                          |                        |\n" +
                "                          |                        |\n" +
                "Alley Behind Bar  <-----  |\t  Locker Room      |  ----->   Pool Deck\n" +
                "                          |                        |\n" +
                "                          |                        |\n" +
                "                          |________________________|\n" +
                "                                        |\n" +
                "\t\t\t\t        |\n" +
                "                                    Pool Bar");
        return mapAscii.toString();
    }

    public static String poolDeck(){
        StringBuilder mapAscii = new StringBuilder();
        mapAscii.append("                            ________________________\n" +
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
        return mapAscii.toString();
    }

    public static String poolBar(){
        StringBuilder mapAscii = new StringBuilder();
        mapAscii.append("\t\t              Locker Room\n" +
                "\t\t\t\t    |\n" +
                "\t\t\t\t    |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "\t\t      |\t\tPool Bar       |  ----->   Pool Deck: Upper Level\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
        return mapAscii.toString();
    }

    public static String poolDeckUpperLevel(){
        StringBuilder mapAscii = new StringBuilder();
        mapAscii.append("\t\t\t\tPool Deck\n" +
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
        return mapAscii.toString();
    }

    public static String slotMachines(){
        StringBuilder mapAscii = new StringBuilder();
        mapAscii.append("\t\t\tPool Deck: Upper Level\n" +
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
        return mapAscii.toString();
    }

    public static String pokerTables(){
        StringBuilder mapAscii = new StringBuilder();
        mapAscii.append("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "Slot Machines  <----  |\t    Poker Tables       |\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n" +
                "\t\t\t\t |\n" +
                "\t\t\t\t |\n" +
                "\t\t\t      VIP Room");
        return mapAscii.toString();
    }

    public static String steakhouse(){
        StringBuilder mapAscii = new StringBuilder();
        mapAscii.append("\t                    Slot Machines\n" +
                "\t\t\t\t  |\n" +
                "\t\t\t\t  |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "\t\t      |\t     Steak House       |  ----->   VIP Room\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
        return mapAscii.toString();
    }

    public static String vipRoom(){
        StringBuilder mapAscii = new StringBuilder();
        mapAscii.append("\t\t\t     Poker Tables\n" +
                "\t\t\t\t  |\n" +
                "\t\t\t\t  |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                " Steak House  <-----  |\t      VIP Room\t       |  ----->   Elevator\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|");
        return mapAscii.toString();
    }

    public static String elevator(){
        StringBuilder mapAscii = new StringBuilder();
        mapAscii.append("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                " VIP Room     <-----  |\t       Elevator\t       |  ----->   Hotel Halls\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|");
        return mapAscii.toString();
    }

    public static String hotelHalls(){
        StringBuilder mapAscii = new StringBuilder();
        mapAscii.append("                            ________________________\n" +
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
        return mapAscii.toString();
    }

    public static String balcony(){
        StringBuilder mapAscii = new StringBuilder();
        mapAscii.append("\t\t              Hotel Halls\n" +
                "\t\t\t\t   |\n" +
                "\t\t\t\t   |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "\t\t      |\t       Balcony\t       |  ----->   Rooftop: Final Boss\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
        return mapAscii.toString();
    }

    public static String rooftopFinalBoss(){
        StringBuilder mapAscii = new StringBuilder();
        mapAscii.append("                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "Balcony   <-----      |   Rooftop: Final Boss  |\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n");
        return mapAscii.toString();
    }

    //ASCII Art completed


}
