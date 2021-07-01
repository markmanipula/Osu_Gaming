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
        Items items = new Items();

        Map map = new Map();
        map.room11Contents();

        //how Jemad moves around is buy accessing data

        Scanner scanner = new Scanner(System.in);
        System.out.println("where do you want to go");
        String playerInput = scanner.next();

        String currentRoom = map.getRoom(map.room12Contents(), playerInput);
        System.out.println("Current room: " + currentRoom);

        player.itemList(map.room12Contents());

    }
}
