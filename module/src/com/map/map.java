package com.map;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class map {
    public HashMap<String, HashMap> asdstages = new HashMap<>();


    //map/list: list of stages
    public String[] stages = {"Stage1", "Stage2", "Stage3", "Stage4"};
    //map/list: Stage1: list of room 1, 2, 3, 4
    public static HashMap<String, String[]> roomsCreator(){
        HashMap<String, String[]> rooms = new HashMap<>();
        rooms.put("Stage1", new String[]{"room11", "room12", "room13", "room14"});
        rooms.put("Stage2", new String[]{"room21", "room22", "room23", "room24"});
        rooms.put("Stage3", new String[]{"room31", "room32", "room33", "room34"});
        rooms.put("Stage4", new String[]{"room41", "room42", "room43", "room44"});

        return rooms;
    }

    public String getRoom(int roomNumber){
        String room = "";

        room = roomsCreator().get("Stage1")[roomNumber];

        return room;
    }

    //Below are methods for contents and movement for each room in the game.
    //Each of these methods include all of the contents for each room.

    public static void room11Contents(){
        HashMap<String, String[]> contents11 = new HashMap<>();
        contents11.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents11.put("items", new String[]{"Pool Queue", "eight ball"});
        contents11.put("enemies", new String[]{"Garcia", "Jack"});
        contents11.put("bosses", new String[]{"Big Ben"});
        contents11.put("east", new String[]{"room13"});
        contents11.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});
        for(String[] i: contents11.values()){
            System.out.println(i[0]);
        }

        contents11.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue()));
        });
        System.out.println(contents11);
    }

    public static void room11Movements(){
        HashMap<String, String> movements11 = new HashMap<>();
        movements11.put("east", "room11");
    }

    public static void room12Contents(){
        HashMap<String, String[]> contents12 = new HashMap<>();
        contents12.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents12.put("items", new String[]{"Pool Queue", "eight ball"});
        contents12.put("enemies", new String[]{"Garcia", "Jack"});
        contents12.put("bosses", new String[]{"Big Ben"});
        contents12.put("east", new String[]{"room13"});
        contents12.put("south", new String[]{"room11"});
        contents12.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});
    }

    public static void room13Contents(){
        HashMap<String, String[]> contents13 = new HashMap<>();
        contents13.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents13.put("items", new String[]{"Pool Queue", "eight ball"});
        contents13.put("enemies", new String[]{"Garcia", "Jack"});
        contents13.put("bosses", new String[]{"Big Ben"});
        contents13.put("north", new String[]{"room12"});
        contents13.put("east", new String[]{"room14"});
        contents13.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});
    }


    public static void room14Contents(){
        HashMap<String, String[]> contents14 = new HashMap<>();
        contents14.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents14.put("items", new String[]{"Pool Queue", "eight ball"});
        contents14.put("enemies", new String[]{"Garcia", "Jack"});
        contents14.put("bosses", new String[]{"Big Ben"});
        contents14.put("east", new String[]{"room21"});
        contents14.put("west", new String[]{"room13"});
        contents14.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});
    }

    public static void room21Contents(){
        HashMap<String, String[]> contents21 = new HashMap<>();
        contents21.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents21.put("items", new String[]{"Pool Queue", "eight ball"});
        contents21.put("enemies", new String[]{"Garcia", "Jack"});
        contents21.put("bosses", new String[]{"Big Ben"});
        contents21.put("west", new String[]{"room14"});
        contents21.put("east", new String[]{"room22"});
        contents21.put("south", new String[]{"room23"});
        contents21.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});
    }

    public static void room22Contents(){
        HashMap<String, String[]> contents22 = new HashMap<>();
        contents22.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents22.put("items", new String[]{"Pool Queue", "eight ball"});
        contents22.put("enemies", new String[]{"Garcia", "Jack"});
        contents22.put("bosses", new String[]{"Big Ben"});
        contents22.put("west", new String[]{"room21"});
        contents22.put("south", new String[]{"room24"});
        contents22.put("shortcut", new String[]{"room23"});
        contents22.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});
    }

    public static void room23Contents(){
        HashMap<String, String[]> contents23 = new HashMap<>();
        contents23.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents23.put("items", new String[]{"Pool Queue", "eight ball"});
        contents23.put("enemies", new String[]{"Garcia", "Jack"});
        contents23.put("bosses", new String[]{"Big Ben"});
        contents23.put("north", new String[]{"room21"});
        contents23.put("east", new String[]{"room24"});
        contents23.put("shortcut", new String[]{"room22"});
        contents23.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});
    }

    public static void room24Contents(){
        HashMap<String, String[]> contents24 = new HashMap<>();
        contents24.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents24.put("items", new String[]{"Pool Queue", "eight ball"});
        contents24.put("enemies", new String[]{"Garcia", "Jack"});
        contents24.put("bosses", new String[]{"Big Ben"});
        contents24.put("west", new String[]{"room23"});
        contents24.put("south", new String[]{"room31"});
        contents24.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});
    }

    public static void room31Contents(){
        HashMap<String, String[]> contents31 = new HashMap<>();
        contents31.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents31.put("items", new String[]{"Pool Queue", "eight ball"});
        contents31.put("enemies", new String[]{"Garcia", "Jack"});
        contents31.put("bosses", new String[]{"Big Ben"});
        contents31.put("south", new String[]{"room33"});
        contents31.put("east", new String[]{"room32"});
        contents31.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});
    }

    public static void room32Contents(){
        HashMap<String, String[]> contents33 = new HashMap<>();
        contents33.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents33.put("items", new String[]{"Pool Queue", "eight ball"});
        contents33.put("enemies", new String[]{"Garcia", "Jack"});
        contents33.put("bosses", new String[]{"Big Ben"});
        contents33.put("west", new String[]{"room31"});
        contents33.put("south", new String[]{"room34"});
        contents33.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});
    }

    public static void room33Contents(){
        HashMap<String, String[]> contents34 = new HashMap<>();
        contents34.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents34.put("items", new String[]{"Pool Queue", "eight ball"});
        contents34.put("enemies", new String[]{"Garcia", "Jack"});
        contents34.put("bosses", new String[]{"Big Ben"});
        contents34.put("north", new String[]{"room31"});
        contents34.put("east", new String[]{"room34"});
        contents34.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});
    }

    public static void room34Contents(){
        HashMap<String, String[]> contents41 = new HashMap<>();
        contents41.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents41.put("items", new String[]{"Pool Queue", "eight ball"});
        contents41.put("enemies", new String[]{"Garcia", "Jack"});
        contents41.put("bosses", new String[]{"Big Ben"});
        contents41.put("north", new String[]{"room32"});
        contents41.put("west", new String[]{"room33"});
        contents41.put("east", new String[]{"room41"});
        contents41.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});
    }

    public static void room41Contents(){
        HashMap<String, String[]> contents41 = new HashMap<>();
        contents41.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents41.put("items", new String[]{"Pool Queue", "eight ball"});
        contents41.put("enemies", new String[]{"Garcia", "Jack"});
        contents41.put("bosses", new String[]{"Big Ben"});
        contents41.put("west", new String[]{"room34"});
        contents41.put("east", new String[]{"room42"});
        contents41.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});
    }

    public static void room42Contents(){
        HashMap<String, String[]> contents42 = new HashMap<>();
        contents42.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents42.put("items", new String[]{"Pool Queue", "eight ball"});
        contents42.put("enemies", new String[]{"Garcia", "Jack"});
        contents42.put("bosses", new String[]{"Big Ben"});
        contents42.put("west", new String[]{"room41"});
        contents42.put("south", new String[]{"room43"});
        contents42.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});
    }

    public static void room43Contents(){
        HashMap<String, String[]> contents43 = new HashMap<>();
        contents43.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents43.put("items", new String[]{"Pool Queue", "eight ball"});
        contents43.put("enemies", new String[]{"Garcia", "Jack"});
        contents43.put("bosses", new String[]{"Big Ben"});
        contents43.put("north", new String[]{"room42"});
        contents43.put("east", new String[]{"room44"});
        contents43.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});
    }

    public static void room44Contents(){
        HashMap<String, String[]> contents44 = new HashMap<>();
        contents44.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents44.put("items", new String[]{"Pool Queue", "eight ball"});
        contents44.put("enemies", new String[]{"Garcia", "Jack"});
        contents44.put("bosses", new String[]{"Big Ben"});
        contents44.put("west", new String[]{"room43"});
        contents44.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});
    }







    //map/list: room: Hashmap: key name, value="", key items, value=list of items, key NPC, value=list of NPCs,
    // key AcceptableMoves, value= list
    //list of NPCs
    //list of Bad guys
    //function to provide stats based on Key for bad guy



//    stage:{
//        name:
//        rooms:{
//            1:
//            2:
//            3:
//            4:
//        }
//    }
public static void main(String[] args) {
        roomsCreator();
        room11Contents();

}
}
