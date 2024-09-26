package com.readjson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadMoveContentJson {
    private static JSONParser parser = null;

    public static JSONObject getAllUserFightContentJSON() {
        parser = new JSONParser();
        InputStream synonymsJSON = ReadStoryContentJson.class.getResourceAsStream("/Moves_JSON.json");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(synonymsJSON))) {
            JSONObject movesObject = (JSONObject) parser.parse(reader);
            return movesObject;
        } catch (IOException | ParseException ioException) {
            ioException.printStackTrace();
            return null;
        }
    }

    // method to retrieve all possible jemad's attack
    public static JSONArray getAllPossibleAttackMoves() {
        JSONObject allUserFightContent = ReadMoveContentJson.getAllUserFightContentJSON();
        JSONArray attackMoves = (JSONArray) allUserFightContent.get("Jemad Attacks");
        return attackMoves;
    }
}
