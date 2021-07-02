package com.client;

import com.combat.PlayerCombatLogic;
import com.game.Player;
import com.map.Map;

import java.util.Arrays;
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
            System.out.println("where do you want to go");
            //look into moving this to its own class to improve testing. Scanner Class to accept file full of commands.
            String playerInput = scanner.nextLine();

            //this should return go
            String[] command = commandChecker(playerInput);
            System.out.println(command[0]);
            System.out.println(command[command.length -1]);
            String currentDirection = "";

            //Create if Statements for our acceptable commands. First one is "go"
            if(command[0].equals("go") && map.roomParser(currentRoom).containsKey(command[command.length-1])){
                if(isValidDirection(command[command.length-1])){
                    currentRoom = map.roomParser(currentRoom).get(command[command.length-1])[0];
                }
            }else if(command[0].equals("fight")){
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


}
