package com.client;

import com.combat.PlayerCombatLogic;
import com.game.GameStart;
import com.game.Player;
import com.map.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    //this is a test main
    public static void main(String[] args) throws IOException, JSONException {

        PlayerCombatLogic combat = new PlayerCombatLogic();


        //for jar file
//        String roomJson = "com/json/Rooms_JSON.txt";
//        String enemiesJson = "com/json/Enemies_JSON.txt";
//        String movesJson = "com/json/Moves_JSON.txt";
//        String synonymsJson = "com/json/Synonyms_JSON.txt";
//        String storyJson = "com/json/Story_JSON.txt";
//        String npcJson = "com/json/NPC_JSON.txt";

        String roomJson = "module/src/com/json/Rooms_JSON.txt";
        String enemiesJson = "module/src/com/json/Enemies_JSON.txt";
        String movesJson = "module/src/com/json/Moves_JSON.txt";
        String synonymsJson = "module/src/com/json/Synonyms_JSON.txt";
        String storyJson = "module/src/com/json/Story_JSON.txt";
        String npcJson = "module/src/com/json/NPC_JSON.txt";

        try{
            String roomContents = new String((Files.readAllBytes(Paths.get(roomJson))));
            String enemyContents = new String((Files.readAllBytes(Paths.get(enemiesJson))));
            String moveContents = new String((Files.readAllBytes(Paths.get(movesJson))));
            String synonymContents = new String((Files.readAllBytes(Paths.get(synonymsJson))));
            String storyContents = new String((Files.readAllBytes(Paths.get(storyJson))));
            String npcContents = new String((Files.readAllBytes(Paths.get(npcJson))));

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
            JSONArray legendSynonym = s.getJSONArray("legend");
            JSONArray quitSynonym = s.getJSONArray("quit");

            //json for storyContents
            JSONObject sotfStory = new JSONObject(storyContents);
            JSONObject sotfIntro = sotfStory.getJSONObject("Game Intro");
            JSONArray storyArray = sotfIntro.getJSONArray("Intro");
            String storyIntro = (String) storyArray.get(0);
//            JSONObject startingRoom = r.getJSONObject("Outside Bar");

            //json for npcContents
            JSONObject n = new JSONObject(npcContents);
            JSONArray listOfNPCs = n.getJSONArray("NPCs");

            //json for enemies
            JSONObject e = new JSONObject(enemyContents);


            //Display story intro for user
            GameStart.start(storyIntro);

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

                //NPC's in room_JSON
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

                String verb = command[0].toLowerCase();
                String noun = command[command.length -1].toLowerCase();
                String completeNoun = completeNoun(command);

                //If Statements using methods to validate correct synonyms
                //If Statements for movement, fight, and inspect(look around)

                //this if statement is for movement. go west, east, etc
                if(contains(verb, goSynonym) && currRoomJSObj.has(noun)){
                    if(contains(noun, direction)){
                        PlayerCombatLogic.clearScreen();
                        currentRoomArray = currRoomJSObj.getJSONArray(noun);
                        currentRoom = (String) currentRoomArray.get(0);
                    }
                }

                //this if statement is for fighting boss for one complete noun
                else if((contains(verb, fightSynonym) && (contains(completeNoun, currEnemiesJSArr)))){
                    combat.combatMethod(e, sotfStory, completeNoun);

                    //this if statement is for fighting enemies for one word noun
                } else if (contains(verb, fightSynonym) && (contains(noun, currEnemiesJSArr))){
                    combat.combatMethod(e, sotfStory, noun);
                }

                //this if statement is for fighting boss for one complete noun
                else if((contains(verb, fightSynonym) && (contains(completeNoun, currBossesJSArr)))) {
                    combat.combatMethod(e, sotfStory, completeNoun);

                    //this if statement is for fighting boss for one word noun
                }else if ((contains(verb, fightSynonym) && (contains(noun, currBossesJSArr)))){
                    combat.combatMethod(e, sotfStory, noun);
                }

                //this if statement is for looking around gathering for info. look, inspect
                else if(contains(verb, inspectSynonym)){
                    //Extra information available on request

                    onlyDisplayUndefeatedEnemies(currEnemiesJSArr);
                    onlyDisplayUndefeatedBosses(currBossesJSArr);

                    System.out.println("Enemies in this room: " + Player.displayedEnemies);
                    System.out.println("Bosses in this room: " + Player.displayedBosses);
                    System.out.println("Items in this room: " + currItemsJSArr);
                    System.out.println("People in this room: " + currNPCJSArr);
                    System.out.println("Items in your bag :" + player.getPlayerItems());
                    Player.displayedEnemies.clear();
                    Player.displayedBosses.clear();
                    //this if statement is for talking to npc
                }else if(contains(verb, talkSynonym) && (contains(noun, listOfNPCs))){
                    JSONObject npcJSObj = n.getJSONObject(noun);
                    String npcSaying1 = npcJSObj.getString("saying1");
                    String npcName = npcJSObj.getString("name");
                    //add logic for if user's item causes new interaction with npc, then second voice line
                    
                    System.out.println(npcName + ": " + npcSaying1);
                    Thread.sleep(1000);
                    //this if statement is for getting/ taking items in the room
                }else if( contains(verb, getSynonym) && contains(noun, currItemsJSArr)){
                    System.out.println(noun + " taken");
                    player.addItem(noun);
                    Thread.sleep(1000);
                    //get items
                }else if(contains(verb, getSynonym) && contains(completeNoun, currItemsJSArr)){
                    System.out.println(completeNoun + " taken");
                    player.addItem(completeNoun);
                    Thread.sleep(1000);
                    //Display Legend with command "legend"
                }else if(contains(verb, legendSynonym) || contains(noun, legendSynonym)){
                    PlayerCombatLogic.clearScreen();
                    Player.legend();

                }else if(contains(verb, quitSynonym) || contains(noun, quitSynonym)){
                    PlayerCombatLogic.clearScreen();
                    System.out.println("Thanks for playing Spirit of the Fist: Madness of Jemad");
                    Thread.sleep(1000);
                    System.exit(0);
                }else{
                    System.out.println("Invalid input");
                }
                //then run room??Contents method based on room?? that input direction points to
            }

        }catch (IOException | JSONException | InterruptedException e){
            e.printStackTrace();
        }
    }

    //checks the json array and checks if an element is in the array
    public static boolean contains(String command, JSONArray arr) throws JSONException {
        if(arr == null || arr.length() == 0) return false;

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

        if(input == null) return new String[]{""};

        String[] array = input.split(" ");
        //handles the empty input
        if(array.length == 0) return new String[] {""};
        //puts words in the array. to access, get first and last index
        StringBuilder stringBuilder = new StringBuilder("");
        for(String i : array){
            i.toLowerCase();
        }
        return array;
    }

    public static String completeNoun(String[] input){
        if( input == null || input.length <= 1) return "";
        StringBuilder stringBuilder = new StringBuilder("");
        for(int i = 1; i < input.length; i++){
            stringBuilder.append(input[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        String completeNoun = stringBuilder.toString();

        return completeNoun;
    }

    public static ArrayList<String> onlyDisplayUndefeatedEnemies(JSONArray enemiesJS) throws JSONException {
        for(int i =0; i< enemiesJS.length(); i++){
            boolean addEnemy = true;
            for(int y =0; y < Player.defeatedEnemies.toArray().length; y++){
                if(enemiesJS.get(i).equals(Player.defeatedEnemies.get(y))){
                    addEnemy = false;
                }
            }
            if(addEnemy == true){
                Player.displayedEnemies.add((String) enemiesJS.get(i));
            }
        };
        return Player.displayedEnemies;
    }
    public static ArrayList<String> onlyDisplayUndefeatedBosses(JSONArray bossesJS) throws JSONException {
        for(int i =0; i< bossesJS.length(); i++){
            boolean addBoss = true;
            for(int y =0; y < Player.defeatedBosses.toArray().length; y++){
                if(bossesJS.get(i).equals(Player.defeatedBosses.get(y))){
                    addBoss = false;
                }
            }
            if(addBoss == true){
                Player.displayedBosses.add((String) bossesJS.get(i));
            }
        };
        return Player.displayedBosses;
    }

}
