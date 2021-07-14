//package com.client;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//import static org.junit.Assert.*;
//
//public class ClientTest {
//
//    String roomJson = "module/src/com/json/Rooms_JSON.txt";
//    String enemiesJson = "module/src/com/json/Enemies_JSON.txt";
//    String movesJson = "module/src/com/json/Moves_JSON.txt";
//    String synonymsJson = "module/src/com/json/Synonyms_JSON.txt";
//    String storyJson = "module/src/com/json/Story_JSON.txt";
//    String npcJson = "module/src/com/json/NPC_JSON.txt";
//
//    String roomContents = new String((Files.readAllBytes(Paths.get(roomJson))));
//    String enemyContents = new String((Files.readAllBytes(Paths.get(enemiesJson))));
//    String moveContents = new String((Files.readAllBytes(Paths.get(movesJson))));
//    String synonymContents = new String((Files.readAllBytes(Paths.get(synonymsJson))));
//    String storyContents = new String((Files.readAllBytes(Paths.get(storyJson))));
//    String npcContents = new String((Files.readAllBytes(Paths.get(npcJson))));
//
//    public ClientTest() throws IOException {
//    }
//
//    @org.junit.Test
//    public void containsPositive()  {
//        boolean expected = false;
//        JSONObject j = new JSONObject(roomContents);
//        JSONObject obj = j.get("Outside Bar");
//        JSONArray arr = obj.get("enemies");
//        boolean actual = Client.contains("attack", arr);
//        assertEquals(expected, actual);
//    }
//
//    @org.junit.Test
//    public void containsNegativeNull() throws JSONException {
//        boolean expected = false;
//        boolean actual = Client.contains("attack", null);
//        assertEquals(expected, actual);
//    }
//
//    @org.junit.Test
//    public void commandCheckerPositive() {
//        String[] expected = new String[] {"go", "west"};
//        String[] actual = Client.commandChecker("go west");
//        assertEquals(expected,actual);
//    }
//
//    @org.junit.Test
//    public void commandCheckerEmptyString() {
//        String[] expected = new String[] {""};
//        String[] actual = Client.commandChecker("");
//        assertEquals(actual, expected);
//    }
//
//    @org.junit.Test
//    public void commandCheckerNull() {
//        String[] expected = new String[] {""};
//        String[] actual = Client.commandChecker(null);
//        assertEquals(actual, expected);
//    }
//
//    @org.junit.Test
//    //disregards the first word, since that's the command(verb)
//    public void completeNounPositive() {
//        String expected = "the big ol' watch";
//        String actual = Client.completeNoun(Client.commandChecker("get the big ol' watch"));
//        assertEquals(expected, actual);
//    }
//}