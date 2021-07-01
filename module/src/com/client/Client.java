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
    }
}
