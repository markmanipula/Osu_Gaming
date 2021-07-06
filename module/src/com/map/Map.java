package com.map;

import com.game.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Map {

    private Items items = new Items();
    //keep this for now
    public HashMap<String, String[]> roomsCreator(){
        HashMap<String, String[]> rooms = new HashMap<>();
        rooms.put("Stage1", new String[]{"room11", "room12", "room13", "room14"});
        rooms.put("Stage2", new String[]{"room21", "room22", "room23", "room24"});
        rooms.put("Stage3", new String[]{"room31", "room32", "room33", "room34"});
        rooms.put("Stage4", new String[]{"room41", "room42", "room43", "room44"});

        return rooms;
    }

    public String getCurrentRoom(HashMap<String, String[]> rooms, String name){
        String room = "";
        room = rooms.get(name)[0];
        return room;
    }

    public String getNextRoom(HashMap<String, String[]> rooms, String name){
        String room = "";
        room = rooms.get(name)[0];
        return room;
    }

    public HashMap<String, String[]> roomParser(String roomID){
        if(roomID.equals("room11")){
            return room11Contents();
        }else if(roomID.equals("room12")){
            return room12Contents();
        }else if(roomID.equals("room13")){
            return room13Contents();
        }else if(roomID.equals("room14")){
            return room14Contents();
        }else if(roomID.equals("room21")){
            return room21Contents();
        }else if(roomID.equals("room22")){
            return room22Contents();
        }else if(roomID.equals("room23")){
            return room23Contents();
        }else if(roomID.equals("room24")){
            return room24Contents();
        }else if(roomID.equals("room31")){
            return room31Contents();
        }else if(roomID.equals("room32")){
            return room32Contents();
        }else if(roomID.equals("room33")){
            return room33Contents();
        }else if(roomID.equals("room34")){
            return room34Contents();
        }else if(roomID.equals("room41")){
            return room41Contents();
        }else if(roomID.equals("room42")){
            return room42Contents();
        }else if(roomID.equals("room43")){
            return room43Contents();
        }else if(roomID.equals("room44")){
            return room44Contents();
        }else{
            return room11Contents();
        }
    }

    //Below are methods for contents and movement for each room in the game.
    //Each of these methods include all of the contents for each room.

    public void showContent(HashMap<String, String[]> content){
        content.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + Arrays.toString(entry.getValue()));
        });
    }

    public String[] room11Items(){
        String[] roomItems = {"Pool Queue", "eight ball", "boots"};
        return roomItems;
    }

    public String[] newRoom11Items(String item){
        ArrayList<String> output = new ArrayList<>();
        for(String items: room11Items()){
            if(!items.equals(item)){
                output.add(items);
            }
        }
        return output.toArray(new String[0]);
    }

    public HashMap<String, String[]> room11Contents(){
        HashMap<String, String[]> contents11 = new HashMap<>();
        contents11.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents11.put("items", room11Items());
        contents11.put("enemies", new String[]{"bouncer", "bodyguard"});
        contents11.put("bosses", new String[]{"Big Ben"});
        contents11.put("name", new String[] {"room11"});
        contents11.put("east", new String[]{"room12"});
        contents11.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});

        return contents11;
    }

    public HashMap<String, String[]> room12Contents(){
        HashMap<String, String[]> contents12 = new HashMap<>();
        contents12.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents12.put("items", new String[]{"Pool Queue", "eight ball"});
        contents12.put("enemies", new String[]{"Garcia", "Jack"});
        contents12.put("bosses", new String[]{"Big Ben"});
        contents12.put("east", new String[]{"room13"});
        contents12.put("south", new String[]{"room11"});
        contents12.put("name", new String[] {"room12"});
        contents12.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});

        return contents12;
    }

    public HashMap<String, String[]> room13Contents(){
        HashMap<String, String[]> contents13 = new HashMap<>();
        contents13.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents13.put("items", new String[]{"Pool Queue", "eight ball"});
        contents13.put("enemies", new String[]{"Garcia", "Jack"});
        contents13.put("bosses", new String[]{"Big Ben"});
        contents13.put("north", new String[]{"room12"});
        contents13.put("east", new String[]{"room14"});
        contents13.put("name", new String[] {"room13"});
        contents13.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});

        return contents13;
    }


    public HashMap<String, String[]> room14Contents(){
        HashMap<String, String[]> contents14 = new HashMap<>();
        contents14.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents14.put("items", new String[]{"Pool Queue", "eight ball"});
        contents14.put("enemies", new String[]{"Garcia", "Jack"});
        contents14.put("bosses", new String[]{"Big Ben"});
        contents14.put("east", new String[]{"room21"});
        contents14.put("west", new String[]{"room13"});
        contents14.put("name", new String[] {"room14"});
        contents14.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});

        return contents14;
    }

    public HashMap<String, String[]> room21Contents(){
        HashMap<String, String[]> contents21 = new HashMap<>();
        contents21.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents21.put("items", new String[]{"Pool Queue", "eight ball"});
        contents21.put("enemies", new String[]{"Garcia", "Jack"});
        contents21.put("bosses", new String[]{"Big Ben"});
        contents21.put("west", new String[]{"room14"});
        contents21.put("east", new String[]{"room22"});
        contents21.put("south", new String[]{"room23"});
        contents21.put("name", new String[] {"room21"});
        contents21.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});

        return contents21;
    }

    public HashMap<String, String[]>  room22Contents(){
        HashMap<String, String[]> contents22 = new HashMap<>();
        contents22.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents22.put("items", new String[]{"Pool Queue", "eight ball"});
        contents22.put("enemies", new String[]{"Garcia", "Jack"});
        contents22.put("bosses", new String[]{"Big Ben"});
        contents22.put("west", new String[]{"room21"});
        contents22.put("south", new String[]{"room24"});
        contents22.put("shortcut", new String[]{"room23"});
        contents22.put("name", new String[] {"room22"});
        contents22.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});

        return contents22;
    }

    public HashMap<String, String[]> room23Contents(){
        HashMap<String, String[]> contents23 = new HashMap<>();
        contents23.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents23.put("items", new String[]{"Pool Queue", "eight ball"});
        contents23.put("enemies", new String[]{"Garcia", "Jack"});
        contents23.put("bosses", new String[]{"Big Ben"});
        contents23.put("north", new String[]{"room21"});
        contents23.put("east", new String[]{"room24"});
        contents23.put("shortcut", new String[]{"room22"});
        contents23.put("name", new String[] {"room23"});
        contents23.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});

        return contents23;
    }

    public HashMap<String, String[]> room24Contents(){
        HashMap<String, String[]> contents24 = new HashMap<>();
        contents24.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents24.put("items", new String[]{"Pool Queue", "eight ball"});
        contents24.put("enemies", new String[]{"Garcia", "Jack"});
        contents24.put("bosses", new String[]{"Big Ben"});
        contents24.put("west", new String[]{"room23"});
        contents24.put("south", new String[]{"room31"});
        contents24.put("name", new String[] {"room24"});
        contents24.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});

        return contents24;
    }

    public HashMap<String, String[]> room31Contents(){
        HashMap<String, String[]> contents31 = new HashMap<>();
        contents31.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents31.put("items", new String[]{"Pool Queue", "eight ball"});
        contents31.put("enemies", new String[]{"Garcia", "Jack"});
        contents31.put("bosses", new String[]{"Big Ben"});
        contents31.put("south", new String[]{"room33"});
        contents31.put("east", new String[]{"room32"});
        contents31.put("name", new String[] {"room31"});
        contents31.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});

        return contents31;
    }

    public HashMap<String, String[]> room32Contents(){
        HashMap<String, String[]> contents32 = new HashMap<>();
        contents32.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents32.put("items", new String[]{"Pool Queue", "eight ball"});
        contents32.put("enemies", new String[]{"Garcia", "Jack"});
        contents32.put("bosses", new String[]{"Big Ben"});
        contents32.put("west", new String[]{"room31"});
        contents32.put("south", new String[]{"room34"});
        contents32.put("name", new String[] {"room32"});
        contents32.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});

        return contents32;
    }

    public HashMap<String, String[]> room33Contents(){
        HashMap<String, String[]> contents33 = new HashMap<>();
        contents33.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents33.put("items", new String[]{"Pool Queue", "eight ball"});
        contents33.put("enemies", new String[]{"Garcia", "Jack"});
        contents33.put("bosses", new String[]{"Big Ben"});
        contents33.put("north", new String[]{"room31"});
        contents33.put("east", new String[]{"room34"});
        contents33.put("name", new String[] {"room33"});
        contents33.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});

        return contents33;
    }

    public HashMap<String, String[]> room34Contents(){
        HashMap<String, String[]> contents34 = new HashMap<>();
        contents34.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents34.put("items", new String[]{"Pool Queue", "eight ball"});
        contents34.put("enemies", new String[]{"Garcia", "Jack"});
        contents34.put("bosses", new String[]{"Big Ben"});
        contents34.put("north", new String[]{"room32"});
        contents34.put("west", new String[]{"room33"});
        contents34.put("east", new String[]{"room41"});
        contents34.put("name", new String[] {"room34"});
        contents34.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});

        return contents34;
    }

    public HashMap<String, String[]> room41Contents(){
        HashMap<String, String[]> contents41 = new HashMap<>();
        contents41.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents41.put("items", new String[]{"Pool Queue", "eight ball"});
        contents41.put("enemies", new String[]{"Garcia", "Jack"});
        contents41.put("bosses", new String[]{"Big Ben"});
        contents41.put("west", new String[]{"room34"});
        contents41.put("east", new String[]{"room42"});
        contents41.put("name", new String[] {"room41"});
        contents41.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});

        return contents41;
    }

    public HashMap<String, String[]> room42Contents(){
        HashMap<String, String[]> contents42 = new HashMap<>();
        contents42.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents42.put("items", new String[]{"Pool Queue", "eight ball"});
        contents42.put("enemies", new String[]{"Garcia", "Jack"});
        contents42.put("bosses", new String[]{"Big Ben"});
        contents42.put("west", new String[]{"room41"});
        contents42.put("south", new String[]{"room43"});
        contents42.put("name", new String[] {"room42"});
        contents42.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});

        return contents42;
    }

    public HashMap<String, String[]> room43Contents(){
        HashMap<String, String[]> contents43 = new HashMap<>();
        contents43.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents43.put("items", new String[]{"Pool Queue", "eight ball"});
        contents43.put("enemies", new String[]{"Garcia", "Jack"});
        contents43.put("bosses", new String[]{"Big Ben"});
        contents43.put("north", new String[]{"room42"});
        contents43.put("east", new String[]{"room44"});
        contents43.put("name", new String[] {"room43"});
        contents43.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});

        return contents43;
    }

    public HashMap<String, String[]> room44Contents(){
        HashMap<String, String[]> contents44 = new HashMap<>();
        contents44.put("NPC", new String[]{"Bartender", "Cop", "NPC3"});
        contents44.put("items", new String[]{"Pool Queue", "eight ball"});
        contents44.put("enemies", new String[]{"Garcia", "Jack"});
        contents44.put("bosses", new String[]{"Big Ben"});
        contents44.put("west", new String[]{"room43"});
        contents44.put("name", new String[] {"room44"});
        contents44.put("Description", new String[]{"initial setting", "room change 1", "room change 2"});

        return contents44;
    }
}
