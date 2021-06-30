package com.map;

import game.Direction;

import java.util.Arrays;
import java.util.HashMap;

public class map {
    public HashMap<String, HashMap> asdstages = new HashMap<>();
    Direction direction;


    //map/list: list of stages
    public String[] stages = {"Stage1", "Stage2", "Stage3", "Stage4"};
    //map/list: Stage1: list of room 1, 2, 3, 4


    public HashMap<String, String[]> roomsCreator(){
        HashMap<String, String[]> rooms = new HashMap<>();
        rooms.put("Stage1", new String[]{"room1", "room2", "room3", "room4"});
        rooms.put("Stage2", new String[]{"room1", "room2", "room3", "room4"});
        rooms.put("Stage3", new String[]{"room1", "room2", "room3", "room4"});
        rooms.put("Stage4", new String[]{"room1", "room2", "room3", "room4"});

        //prints the map
        rooms.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue()));
        });

        //System.out.println(Arrays.toString(rooms.get("Stage1")));

        //System.out.println(rooms.get("Stage1")[2]);
        return rooms;
    }

    public String getRoom(int roomNumber){
        String room = "";

        room = roomsCreator().get("Stage1")[roomNumber];

        return room;
    }

    //map/list: room: Hashmap: key name, value="", key items, value=list of items, key NPC, value=list of NPCs,
    // key AcceptableMoves, value= list
    //list of NPCs
    //list of Bad guys



//    stage:{
//        name:
//        rooms:{
//            1:
//            2:
//            3:
//            4:
//        }
//    }

}
