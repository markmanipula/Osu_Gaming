package com.map;

import com.readjson.ReadRoomContentJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {


    JSONObject r = ReadRoomContentJson.getAllRoomContentJSON();
    JSONObject startingRoom = (JSONObject)r.get("Outside Bar");

    @Test
    public void grabsRoomName() {
        JSONArray currentRoomNameArray = (JSONArray) startingRoom.get("name");
        String expected = "Outside Bar";
        String actual = (String) currentRoomNameArray.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void grabRoomEnemy() {
        JSONArray currentRoomEnemyArray = (JSONArray) startingRoom.get("enemies");
        String expected = "bouncer";
        String actual = (String) currentRoomEnemyArray.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void grabRoomEnemyArrayBlank() {
        JSONObject startingRoom = (JSONObject)r.get("Alley Behind Bar");
        JSONArray currentRoomEnemyArray = (JSONArray) startingRoom.get("enemies");
        String expected = "";
        String actual = (String) currentRoomEnemyArray.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void grabRoomNPC() {
        JSONArray currentRoomNPCArray = (JSONArray) startingRoom.get("NPC");
        String expected = "biker";
        String actual = (String) currentRoomNPCArray.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void grabRoomItem() {
        JSONArray currentRoomItemArray = (JSONArray) startingRoom.get("items");
        String expected = "eight ball";
        String actual = (String) currentRoomItemArray.get(1);
        assertEquals(expected, actual);
    }

    @Test
    public void grabAdjacentRoomName() {
        JSONArray currentRoomEastArray = (JSONArray) startingRoom.get("east");
        String expected = "Inside Bar";
        String actual = (String) currentRoomEastArray.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void grabRoomDescription() {
        JSONArray currentRoomDescriptionArray = (JSONArray) startingRoom.get("Description");
        String expected = "With a amalgam of money, power, and corruption in this city..  so many gather at this bar before enjoying the rest of the Casino.  At the back entrance outside the bar lays a solitary door guarded by three bouncers.  'Three guys at the door and some drunk...maybe I can get in with no trouble'";
        String actual = (String) currentRoomDescriptionArray.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void grabRoomBoss() {
        JSONObject startingRoom = (JSONObject)r.get("Rooftop: Final Boss");
        JSONArray currentRoomBossArray = (JSONArray) startingRoom.get("bosses");
        String expected = "Don Fury";
        String actual = (String) currentRoomBossArray.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void grabRoomBossArrayBlank() {
        JSONArray currentRoomBossArray = (JSONArray) startingRoom.get("bosses");
        String expected = "";
        String actual = (String) currentRoomBossArray.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void outsideBarMap() {
        String expected = " ________________________\n" +
                "|                        |\n" +
                "|                        |\n" +
                "|       Outside Bar      |  ----->   Inside Bar\n" +
                "|                        |\n" +
                "|                        |\n" +
                "|________________________|\n";
        String actual = Room.outsideBar();
        assertEquals(expected, actual);
    }

    @Test
    public void insideBarMap() {
        String expected = "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "Outside Bar   <-----  |         Inside Bar     |\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n" +
                "\n" +
                "                                   |\n" +
                "                                   |\n" +
                "                               Pool Room";
        String actual = Room.insideBar();
        assertEquals(expected, actual);
    }

    @Test
    public void poolRoomMap() {
        String expected = "\t\t              Inside Bar\n" +
                "\t\t\t\t    |\n" +
                "\t\t\t\t    |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "\t\t      |\t\tPool Room      |  ----->   Alley Behind Bar\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n";
        String actual = Room.poolRoom();
        assertEquals(expected, actual);
    }

    @Test
    public void alleyBehindBarMap() {
        String expected = "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                " Pool Room    <-----  |\t    Alley Behind Bar   |  ----->   Locker Room\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n";
        String actual = Room.alleyBehindBar();
        assertEquals(expected, actual);
    }

    @Test
    public void lockerRoomMap() {
        String expected = "                           ________________________\n" +
                "                          |                        |\n" +
                "                          |                        |\n" +
                "Alley Behind Bar  <-----  |\t  Locker Room      |  ----->   Pool Deck\n" +
                "                          |                        |\n" +
                "                          |                        |\n" +
                "                          |________________________|\n" +
                "                                        |\n" +
                "\t\t\t\t        |\n" +
                "                                    Pool Bar";
        String actual = Room.lockerRoom();
        assertEquals(expected, actual);
    }

    @Test
    public void poolDeckMap() {
        String expected = "                            ________________________\n" +
                "                           |                        |\n" +
                "                           |                        |\n" +
                "Locker Room   <-----       |\t  Pool Deck  \t    |\n" +
                "                           |                        |\n" +
                "                           |                        |\n" +
                "                           |________________________|\n" +
                "\n" +
                "\t\t\t                |\n" +
                "\t\t                        |\n" +
                "\t\t\t   Pool Deck: Upper Level";
        String actual = Room.poolDeck();
        assertEquals(expected, actual);
    }

    @Test
    public void poolBarMap() {
        String expected = "\t\t              Locker Room\n" +
                "\t\t\t\t    |\n" +
                "\t\t\t\t    |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "\t\t      |\t\tPool Bar       |  ----->   Pool Deck: Upper Level\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n";
        String actual = Room.poolBar();
        assertEquals(expected, actual);
    }

    @Test
    public void poolDeckUpperLevelMap() {
        String expected = "\t\t\t\tPool Deck\n" +
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
                "\t\t\t      Slot Machines";
        String actual = Room.poolDeckUpperLevel();
        assertEquals(expected, actual);
    }

    @Test
    public void slotMachinesMap() {
        String expected = "\t\t\tPool Deck: Upper Level\n" +
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
                "\t\t\t     Steak House";
        String actual = Room.slotMachines();
        assertEquals(expected, actual);
    }

    @Test
    public void pokerTablesMap() {
        String expected = "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "Slot Machines  <----  |\t    Poker Tables       |\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n" +
                "\t\t\t\t |\n" +
                "\t\t\t\t |\n" +
                "\t\t\t      VIP Room";
        String actual = Room.pokerTables();
        assertEquals(expected, actual);
    }

    @Test
    public void steakHouseMap() {
        String expected = "\t                    Slot Machines\n" +
                "\t\t\t\t  |\n" +
                "\t\t\t\t  |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "\t\t      |\t     Steak House       |  ----->   VIP Room\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n";
        String actual = Room.steakhouse();
        assertEquals(expected, actual);
    }

    @Test
    public void vipRoomMap() {
        String expected = "\t\t\t     Poker Tables\n" +
                "\t\t\t\t  |\n" +
                "\t\t\t\t  |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                " Steak House  <-----  |\t      VIP Room\t       |  ----->   Elevator\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|";
        String actual = Room.vipRoom();
        assertEquals(expected, actual);
    }

    @Test
    public void elevatorMap() {
        String expected = "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                " VIP Room     <-----  |\t       Elevator\t       |  ----->   Hotel Halls\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|";
        String actual = Room.elevator();
        assertEquals(expected, actual);
    }

    @Test
    public void hotelHallsMap() {
        String expected = "                            ________________________\n" +
                "                           |                        |\n" +
                "                           |                        |\n" +
                " \tElevator   <-----  |\t  Hotel Halls  \t    |\n" +
                "                           |                        |\n" +
                "                           |                        |\n" +
                "                           |________________________|\n" +
                "\n" +
                "\t\t\t\t\t|\n" +
                "\t\t\t\t\t|\n" +
                "\t\t\t\t     Balcony\n";
        String actual = Room.hotelHalls();
        assertEquals(expected, actual);
    }

    @Test
    public void balconyMap() {
        String expected = "\t\t              Hotel Halls\n" +
                "\t\t\t\t   |\n" +
                "\t\t\t\t   |\n" +
                "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "\t\t      |\t       Balcony\t       |  ----->   Rooftop: Final Boss\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n";
        String actual = Room.balcony();
        assertEquals(expected, actual);
    }

    @Test
    public void rooftopFinalBossMap() {
        String expected = "                       ________________________\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "Balcony   <-----      |   Rooftop: Final Boss  |\n" +
                "                      |                        |\n" +
                "                      |                        |\n" +
                "                      |________________________|\n";
        String actual = Room.rooftopFinalBoss();
        assertEquals(expected, actual);
    }






}
