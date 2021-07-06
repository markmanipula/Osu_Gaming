package com.client;

import com.combat.PlayerCombatLogic;
import com.game.Player;
import com.map.Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Client {

    //this is a test main
    public static void main(String[] args) {
        Player player = new Player();
        PlayerCombatLogic combat = new PlayerCombatLogic();

        Map map = new Map();

//        //how Jemad moves around is buy accessing data
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("where do you want to go");
//        String playerInput = scanner.next();
//
//
//        String currentRoom = map.getCurrentRoom(map.room11Contents(), "name");
//        System.out.println("Current room: " + currentRoom);
//        player.itemList(map.room11Contents());

        String currentRoom = map.getCurrentRoom(map.room11Contents(), "name");
        boolean running = true;
        while(running){
            divider();
            System.out.println("Current room: " + currentRoom);
            //for the input direction, compare that to directions in current room
            map.showContent(map.roomParser(currentRoom));
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

            //Create if Statements for our acceptable commands. First one is "go"
            //if the word is go or any of its synonym
            if(goSynonym(command[0]) && map.roomParser(currentRoom).containsKey(command[command.length-1])){
                if(isValidDirection(command[command.length-1])){
                    currentRoom = map.roomParser(currentRoom).get(command[command.length-1])[0];
                }
            //if the word is fight or any of its synonym
            }else if(fightSynonym(command[0])){
                combat.combatStart();
                //Iterate through enemies array for enemy name
                String[] test = map.roomParser(currentRoom).get("enemies");
                //test.contains(command[command.length-1]);
                System.out.println(Arrays.toString(test));
            }

            //then run room??Contents method based on room?? that input direction points to
        }
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

}
