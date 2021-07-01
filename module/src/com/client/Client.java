package com.client;

import com.game.Direction;
import com.game.Items;
import com.game.Player;
import com.map.Map;

import java.util.HashMap;
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

        player.move(map.room11Contents());
        player.move(map.room42Contents());

        String currentRoom = map.getCurrentRoom(map.room11Contents(), "name");
        boolean running = true;
        while(running){
            System.out.println("Current room: " + currentRoom);
            Scanner scanner = new Scanner(System.in);
            System.out.println("where do you want to go");
            String playerInput = scanner.next();

            //for the input direction, compare that to directions in current room
            map.showContent(map.roomParser(currentRoom));
            String currentDirection = "";
            if(map.roomParser(currentRoom).containsKey(playerInput) && (playerInput.equals("east") ||
                    playerInput.equals("west") || playerInput.equals("north") || playerInput.equals("south"))){
               currentRoom = map.roomParser(currentRoom).get(playerInput)[0];
            }
            //then run room??Contents method based on room?? that input direction points to

            player.move(map.room11Contents());

        }
    }
}
