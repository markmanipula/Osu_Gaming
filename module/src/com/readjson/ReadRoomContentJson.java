package com.readjson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReadRoomContentJson {
    private static JSONParser parser = null;

    public static JSONObject getAllRoomContentJSON() {
        parser = new JSONParser();
        InputStream roomContent = ReadRoomContentJson.class.getResourceAsStream("/Rooms_JSON.json");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(roomContent))) {
            JSONObject roomContentObj = (JSONObject) parser.parse(reader);
            return roomContentObj;
        } catch (IOException | ParseException ioException) {
            ioException.printStackTrace();
            return null;
        }
    }

    // public helper method to retrieve particular room current
    public static JSONObject getCurrentRoomContentJSON(String currentRoom) {
        parser = new JSONParser();
        InputStream roomContent = ReadRoomContentJson.class.getResourceAsStream("/Rooms_JSON.json");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(roomContent))) {
            JSONObject roomContentObj = (JSONObject) parser.parse(reader);
            JSONObject particularRoomObj = (JSONObject) roomContentObj.get(currentRoom);
            return particularRoomObj;
        } catch (IOException | ParseException ioException) {
            ioException.printStackTrace();
            return null;
        }
    }

    // method to retrieve current room name
    public static String getCurrentRoomName(String currentRoom) {
        JSONObject currentRoomContent = ReadRoomContentJson.getCurrentRoomContentJSON(currentRoom);
        JSONArray roomName = (JSONArray) currentRoomContent.get("name");
        if (roomName != null) {
            return String.valueOf(roomName.get(0));
        } else {
            return null;
        }
    }

    // method to retrieve enemies at current room
    public static void printCurrentRoomDescription(String currentRoom) {
        JSONObject currentRoomContent = ReadRoomContentJson.getCurrentRoomContentJSON(currentRoom);
        JSONArray description = (JSONArray) currentRoomContent.get("Description");
        System.out.println(description.get(0));
        // print room information
        String roomInformation = String.valueOf(description.get(0));
        System.out.println(roomInformation);
    }

    // method to retrieve enemies
    public static JSONArray retrieveEnemiesOnCurrentRoom(String currentRoom) {
        JSONObject currentRoomContent = ReadRoomContentJson.getCurrentRoomContentJSON(currentRoom);
        JSONArray currentRoomEnemy = (JSONArray) currentRoomContent.get("enemies");
        return currentRoomEnemy;
    }

    // method to get NPC from room
    public static JSONArray retrieveNPCOnCurrentRoom(String currentRoom) {
        JSONObject currentRoomContent = ReadRoomContentJson.getCurrentRoomContentJSON(currentRoom);
        JSONArray currentRoomNPC = (JSONArray) currentRoomContent.get("NPC");
        return currentRoomNPC;
    }

    // method to get possible items
    public static JSONArray retrieveItemInCurrentRoom(String currentRoom) {
        JSONObject currentRoomContent = ReadRoomContentJson.getCurrentRoomContentJSON(currentRoom);
        JSONArray currentRoomItems = (JSONArray) currentRoomContent.get("items");
        return currentRoomItems;
    }

    public static String trimRoomDescription(String currentRoom) {
        StringBuilder strBuilder = new StringBuilder();
        JSONObject roomData = getCurrentRoomContentJSON(currentRoom);
        JSONArray roomArray = (JSONArray) roomData.get("Description");
        String longDescriptionData = String.valueOf(roomArray.get(0));
        String shortDescriptionArr[] = longDescriptionData.split("  ");
        for (int i = 0; i < shortDescriptionArr.length; i++) {
            strBuilder.append(shortDescriptionArr[i] + "\n");
            // System.out.println(shortDescriptionArr[i]);
        }
        return strBuilder.toString();
    }
}
