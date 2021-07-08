package com.client;

import com.combat.PlayerCombatLogic;
import com.game.Player;
import com.map.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Client {

    //this is a test main
    public static void main(String[] args) {

        PlayerCombatLogic combat = new PlayerCombatLogic();

        //for jar file
//        String roomJson = "com/json/Rooms_JSON.txt";
//        String enemiesJson = "com/json/Enemies_JSON.txt";
//        String movesJson = "com/json/Moves_JSON.txt";
//        String synonymsJson = "com/json/Synonyms_JSON.txt";

        String roomJson = "module/src/com/json/Rooms_JSON.txt";
        String enemiesJson = "module/src/com/json/Enemies_JSON.txt";
        String movesJson = "module/src/com/json/Moves_JSON.txt";
        String synonymsJson = "module/src/com/json/Synonyms_JSON.txt";
        String storyJson = "module/src/com/json/Story_JSON.txt";

        try{
            String roomContents = new String((Files.readAllBytes(Paths.get(roomJson))));
            String enemyContents = new String((Files.readAllBytes(Paths.get(enemiesJson))));
            String moveContents = new String((Files.readAllBytes(Paths.get(movesJson))));
            String synonymContents = new String((Files.readAllBytes(Paths.get(synonymsJson))));
            String storyContents = new String((Files.readAllBytes(Paths.get(storyJson))));

            Map map = new Map();
            Player player = new Player(map);

            // json for roomContents
            JSONObject r = new JSONObject(roomContents);
            JSONObject startingRoom = r.getJSONObject("Outside Bar");
            JSONArray currentRoomArray = startingRoom.getJSONArray("name");
            String currentRoom = (String) currentRoomArray.get(0);

            //json for synonymContents
            JSONObject s = new JSONObject(synonymContents);
            JSONArray goSynonym = s.getJSONArray("go");
            JSONArray fightSynonym = s.getJSONArray("fight");
            JSONArray getSynonym = s.getJSONArray("get");
            JSONArray talkSynonym = s.getJSONArray("talk");
            JSONArray inspectSynonym = s.getJSONArray("inspect");
            JSONArray direction = s.getJSONArray("direction");

            //json for storyContents
            JSONObject sotfStory = new JSONObject(storyContents);
            JSONObject sotfIntro = sotfStory.getJSONObject("Game Intro");
            JSONArray storyArray = sotfIntro.getJSONArray("Intro");
            String storyIntro = (String) storyArray.get(0);
//            JSONObject startingRoom = r.getJSONObject("Outside Bar");


            //Display story intro for user
            System.out.println(storyIntro);

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

                //this gets the verb + noun from the player input. ex: go east, move north, fight Garcia, inspect area, etc.
                String[] command = commandChecker(playerInput);

                String verb = command[0];
                String noun = command[command.length -1];

                //If Statements using methods to validate correct synonyms
                //If Statements for movement, fight, and inspect(look around)
                if(contains(verb, goSynonym) && currRoomJSObj.has(noun)){
                    if(contains(noun, direction)){
                        currentRoomArray = currRoomJSObj.getJSONArray(noun);
                        currentRoom = (String) currentRoomArray.get(0);
                    }
                    //if the word is fight or any of its synonym
                    //Arrays.asList(currEnemies).contains(command[command.length-1]
                }else if(contains(verb, fightSynonym) && (contains(noun, currEnemiesJSArr)) ||
                        (contains(noun, currBossesJSArr))){
                    combat.combatStart(noun);
                    //Iterate through enemies array for enemy name
                    String[] test = player.map().roomParser(currentRoom).get("enemies");
                    //test.contains(command[command.length-1]);
                    System.out.println(Arrays.toString(test));
                }else if(contains(verb, inspectSynonym)){
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
    }

    //checks the json array and checks if an element is in the array
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

}
