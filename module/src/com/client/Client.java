package com.client;

import com.combat.PlayerCombatLogic;
import com.display.Window;
import com.game.GameStart;
import com.game.Player;
import com.map.Map;
import com.readjson.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Client {
    //this is a test main
    public static void main(String[] args) throws IOException, InterruptedException {

        PlayerCombatLogic combat = new PlayerCombatLogic();


        try{
            Map map = new Map();
            Player player = new Player(map);

            // json for roomContents
            // JSONObject r = new JSONObject(roomContents);
            JSONObject r = (JSONObject) ReadRoomContentJson.getAllRoomContentJSON();
            JSONObject startingRoom = (JSONObject)r.get("Outside Bar");
            JSONArray currentRoomArray = (JSONArray) startingRoom.get("name");
            String currentRoom = (String) currentRoomArray.get(0);

            //json for synonymContents
            // JSONObject s = new JSONObject(synonymContents);
            JSONObject s = ReadSynonymsContentJson.getAllSynonymContentJSON();
            JSONArray goSynonym = (JSONArray) s.get("go");
            JSONArray fightSynonym = (JSONArray) s.get("fight");
            JSONArray getSynonym = (JSONArray) s.get("get");
            JSONArray talkSynonym = (JSONArray) s.get("talk");
            JSONArray inspectSynonym = (JSONArray) s.get("inspect");
            JSONArray direction = (JSONArray) s.get("direction");
            JSONArray legendSynonym = (JSONArray) s.get("legend");
            JSONArray quitSynonym = (JSONArray) s.get("quit");

            //json for storyContents
            // JSONObject sotfStory = new JSONObject(storyContents);
            JSONObject sotfStory = ReadStoryContentJson.getAllStoryContentJSON();
            JSONObject sotfIntro = (JSONObject) sotfStory.get("Game Intro");
            JSONArray storyArray = (JSONArray) sotfIntro.get("Intro");
            // game intro
            String storyIntro = ReadStoryContentJson.trimGameIntro("Game Intro");
//            JSONObject startingRoom = r.getJSONObject("Outside Bar");

            //json for npcContents
            // JSONObject n = new JSONObject(npcContents);
            JSONObject n = ReadNPCContentJson.getAllNPCContentJSON();
            JSONArray listOfNPCs = (JSONArray) n.get("NPCs");

            //json for enemies
            // JSONObject e = new JSONObject(enemyContents);
            JSONObject e = ReadEnemyContentJson.getAllEnemyContentJSON();

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
                JSONObject currRoomJSObj = (JSONObject) r.get(currentRoom);

                // Jun: This data is only being used in these two lines
                // JSONArray des1 = (JSONArray) currRoomJSObj.get("Description");
                // String des2 = (String) des1.get(0);
                String des2 = ReadRoomContentJson.trimRoomDescription(currentRoom);

                //Enemies
                JSONArray currEnemiesJSArr = (JSONArray) currRoomJSObj.get("enemies");

                //Bosses
                JSONArray currBossesJSArr = (JSONArray) currRoomJSObj.get("bosses");

                //NPC's in room_JSON
                JSONArray currNPCJSArr = (JSONArray) currRoomJSObj.get("NPC");

                //Items
                JSONArray currItemsJSArr = (JSONArray) currRoomJSObj.get("items");

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
                System.out.println("Verb: " + verb);
                System.out.println("Noun: " + noun);
                String completeNoun = completeNoun(command);

                //If Statements using methods to validate correct synonyms
                //If Statements for movement, fight, and inspect(look around)

                //this if statement is for movement. go west, east, etc
                if(contains(verb, goSynonym) && currRoomJSObj.containsKey(noun)){
                    if(contains(noun, direction)){
                        Window.clearScreen();
                        currentRoomArray = (JSONArray) currRoomJSObj.get(noun);
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
                    // System.out.println("Items in this room: " + currItemsJSArr);
                    System.out.println("Items in this room: " + displayRemainedItemList(currItemsJSArr, player));

                    System.out.println("People in this room: " + currNPCJSArr);
                    System.out.println("Items in your bag :" + player.getPlayerItems());
                    Player.displayedEnemies.clear();
                    Player.displayedBosses.clear();


                    //this if statement is for talking to one word noun npc
                }else if(contains(verb, talkSynonym) && (contains(noun, currNPCJSArr))){
                    JSONObject npcJSObj = (JSONObject) n.get(noun);
                    String npcSaying1 = String.valueOf(npcJSObj.get("saying1"));
                    String npcName = String.valueOf(npcJSObj.get("name"));
                    //add logic for if user's item causes new interaction with npc, then second voice line
                    
                    System.out.println(npcName + ": " + npcSaying1);
                    Thread.sleep(1000);
                }

                //talking to npc with complete noun
                else if(contains(verb, talkSynonym) && (contains(completeNoun, currNPCJSArr))){
                    JSONObject npcJSObj = (JSONObject) n.get(noun);
                    String npcSaying1 = String.valueOf(npcJSObj.get("saying1"));
                    String npcName = String.valueOf(npcJSObj.get("name"));
                    //add logic for if user's item causes new interaction with npc, then second voice line

                    System.out.println(npcName + ": " + npcSaying1);
                    Thread.sleep(1000);
                }

                //this if statement is for getting/ taking items in the room
                else if( contains(verb, getSynonym) && contains(noun, currItemsJSArr)){
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
                    Window.clearScreen();
                    Player.legend();

                }else if(contains(verb, quitSynonym) || contains(noun, quitSynonym)){
                    Window.clearScreen();
                    System.out.println("Thanks for playing Spirit of the Fist: Madness of Jemad");
                    Thread.sleep(1000);
                    System.exit(0);
                }else{

                    System.out.println("Invalid input");
                    Thread.sleep(1000);
                    Window.clearScreen();
                }
                //then run room??Contents method based on room?? that input direction points to
                if(Player.defeatedBosses.contains("Don Fury")){
                    running = false;
                }
            }


        }catch (InterruptedException e){
            e.printStackTrace();
        }
        GameStart.gameEnd();
    }

    //checks the json array and checks if an element is in the array
    public static boolean contains(String command, JSONArray arr) {
        if(arr == null || arr.size() == 0) return false;
        for(int i = 0; i< arr.size(); i++){
            if(arr.get(i).equals(command)){
                return true;
            }
        }
        return false;
    }

    public static void divider(){
        System.out.println("-----------------------");
    }

    public static String[] commandChecker(String input){

        if(input == null || input.length() == 0) return new String[]{""};

        String[] array = input.split(" ");
        //handles the empty input
        if(array == null || array.length < 2) return new String[] {""};
        //puts words in the array. to access, get first and last index
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

    public static ArrayList<String> onlyDisplayUndefeatedEnemies(JSONArray enemiesJS) {
        for(int i =0; i< enemiesJS.size(); i++){
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
    public static ArrayList<String> onlyDisplayUndefeatedBosses(JSONArray bossesJS) {
        for(int i =0; i< bossesJS.size(); i++){
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

    // method to check the item
    // The new Team 1 added
    public static List<String> displayRemainedItemList(JSONArray currItemsJSArr, Player player) {
        if (currItemsJSArr == null | currItemsJSArr.size() == 0) {
            return new ArrayList<>();
        }
        Set<String> playerItem = player.getPlayerItems();
        ArrayList<String> itemExistInRoom = new ArrayList<>();
        // put all item into itemExistInRoom from json
        for (int i = 0; i < currItemsJSArr.size(); i++) {
            itemExistInRoom.add(String.valueOf(currItemsJSArr.get(i)));
        }
        ArrayList<String> playerItemArrayList = new ArrayList<>(playerItem);
        // remove item
        for (int i = 0; i < playerItemArrayList.size(); i++) {
            if (itemExistInRoom.contains(playerItemArrayList.get(i))) {
                itemExistInRoom.remove(playerItemArrayList.get(i));
            }
        }
        System.out.println(itemExistInRoom);
        return itemExistInRoom;
    }

    public void triggerEndGame(){

    }

    public static void startingRoom() {

    }
}
