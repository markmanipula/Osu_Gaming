package com.client;

import com.combat.PlayerCombatLogic;
import com.game.Player;
import com.map.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Client {

    //this is a test main
    public static void main(String[] args) {
        PlayerCombatLogic combat = new PlayerCombatLogic();

        String roomJson = "module/src/com/json/Rooms_JSON.txt";
        String enemiesJson = "module/src/com/json/Enemies_JSON.txt";
        String movesJson = "module/src/com/json/Moves_JSON.txt";
        String synonymsJson = "module/src/com/json/Synonyms_JSON.txt";

        try{
            String roomContents = new String((Files.readAllBytes(Paths.get(roomJson))));
            String enemyContents = new String((Files.readAllBytes(Paths.get(enemiesJson))));
            String moveContents = new String((Files.readAllBytes(Paths.get(movesJson))));
            String synonymContents = new String((Files.readAllBytes(Paths.get(synonymsJson))));

            JSONObject r = new JSONObject(roomContents);

            Map map = new Map();
            Player player = new Player(map);

           // String currentRoom = player.map().getCurrentRoom(player.map().room11Contents(), "name");
            JSONObject startingRoom = r.getJSONObject("Outside Bar");

            JSONArray currentRoomArray = startingRoom.getJSONArray("name");
            String currentRoom = (String) currentRoomArray.get(0);
            System.out.println(currentRoom);
            boolean running = true;
            while(running){
                divider();
            //Create If statements. Starts false, then after you visit once it is true for the rest of the game.


                //for the input direction, compare that to direc
                // tions in current room

                //Current Variables
                //Description
                JSONObject currRoomJSObj = r.getJSONObject(currentRoom);
                JSONArray des1 = currRoomJSObj.getJSONArray("Description");
                String des2 = (String) des1.get(0);
                //Enemies
                JSONArray currEnemiesJSArr = currRoomJSObj.getJSONArray("enemies");



                //Bosses
                JSONArray currBossesJSArr = currRoomJSObj.getJSONArray("bosses");

                //NPC's
                JSONArray currNPCJSArr = currRoomJSObj.getJSONArray("NPC");

                //Items
                JSONArray currItemsJSArr = currRoomJSObj.getJSONArray("items");

                //Display Basic Room information
                System.out.println(currentRoom);
                System.out.println(des2);

                Scanner scanner = new Scanner(System.in);
                divider();
                System.out.println("What do you want to do?");
                //look into moving this to its own class to improve testing. Scanner Class to accept file full of commands.
                String playerInput = scanner.nextLine();

                //this should return go
                String[] command = commandChecker(playerInput);
                System.out.println(command[0]);
                System.out.println(command[command.length -1]);
                String currentDirection = "";

                //If Statements using methods to validate correct synonyms
                //If Statements for movement, fight, and inspect(look around)
                if(goSynonym(command[0]) && currRoomJSObj.has(command[command.length-1])){
                    if(isValidDirection(command[command.length-1])){
                        currentRoomArray = startingRoom.getJSONArray(command[command.length-1]);
                        currentRoom = (String) currentRoomArray.get(0);


                        //currentRoom = (String) currRoomJSObj.getJSONObject(command[command.length-1][0])    ;
                    }
                    //if the word is fight or any of its synonym
                    //Arrays.asList(currEnemies).contains(command[command.length-1]
                }else if(fightSynonym(command[0]) && (contains(command[command.length-1], currEnemiesJSArr)) ||
                        (contains(command[command.length-1], currBossesJSArr))){
                    combat.combatStart(command[command.length-1]);
                    //Iterate through enemies array for enemy name
                    String[] test = player.map().roomParser(currentRoom).get("enemies");
                    //test.contains(command[command.length-1]);
                    System.out.println(Arrays.toString(test));
                }else if(inspectSynonym(command[0])){
                    //Extra information available on request
                    System.out.println("Enemies in this room: " + currEnemiesJSArr);
                    System.out.println("Bosses in this room: " + currBossesJSArr);
                    System.out.println("Items in this room: " + currItemsJSArr);
                    System.out.println("People in this room: " + currNPCJSArr);
                }

                //then run room??Contents method based on room?? that input direction points to
            }


        }catch (IOException | JSONException e){
            e.printStackTrace();
        }



//        //how Jemad moves around is buy accessing data
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("where do you want to go");
//        String playerInput = scanner.next();
//
//        String currentRoom = map.getCurrentRoom(map.room11Contents(), "name");
//        System.out.println("Current room: " + currentRoom);
//        player.itemList(map.room11Contents());


    }

    public static boolean contains(String command, JSONArray arr) throws JSONException {
        for(int i = 0; i< arr.length(); i++){
            if(arr.getString(i).equals(command)){
                return true;
            }
        }
        return false;
    }

    public static void divider(){
        System.out.println("-----------------------");
    }

    public static String[] commandChecker(String input){
        //puts words in the array. to access, get first and last index
        StringBuilder stringBuilder = new StringBuilder("");

        String[] array = input.split(" ");
        for(String i : array){
            i.toLowerCase();
        }

        return array;
    }

    public static boolean isValidDirection(String direction){
         if(direction.equals("east") ||
                 direction.equals("west") || direction.equals("north") || direction.equals("south")){
             return true;
         }
         return false;
    }

    public static boolean goSynonym(String direction){
        String[] synonyms = new String[] {"go", "move", "proceed", "advance", "walk", "run", "jump", "travel"};

        for(String word : synonyms){
            if(direction.equals(word)) return true;
        }
        return false;
    }

    public static boolean fightSynonym(String fight){
        String[] synonyms = new String[] {"fight", "attack", "tackle", "hit", "charge", "strike", "rush", "push", "storm", "punch", "kick"};

        for(String word : synonyms){
            if(fight.equals(word)) return true;
        }
        return false;
    }

    public static boolean getSynonym(String get){
        String[] synonyms = new String[] {"get", "grab", "obtain", "pick", "acquire"};

        for(String word : synonyms){
            if(get.equals(word)) return true;
        }
        return false;
    }

    public static boolean talkSynonym(String talk){
        String[] synonyms = new String[] {"talk", "speak", "chat"};

        for(String word : synonyms){
            if(talk.equals(word)) return true;
        }
        return false;
    }

    public static boolean inspectSynonym(String talk){
        String[] synonyms = new String[] {"inspect", "look", "investigate", "glance", "examine", "explore", "inquire", "delve", "dig",
        };

        for(String word : synonyms){
            if(talk.equals(word)) return true;
        }
        return false;
    }

}
