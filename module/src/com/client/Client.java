package com.client;

import com.game.Player;
import com.map.Map;

import java.util.Scanner;

public class Client {

    //this is a test main
    public static void main(String[] args) {
        Player player = new Player();

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
            String playerInput = scanner.next();

            //this should return go
            String[] command = commandChecker(playerInput);

            String currentDirection = "";
            if(map.roomParser(currentRoom).containsKey(playerInput)){
               currentRoom = map.roomParser(currentRoom).get(playerInput)[0];
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
