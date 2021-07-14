package com.readjson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadSynonymsContentJson {
    private static JSONParser parser = null;

    public static JSONObject getAllSynonymContentJSON() {
        parser = new JSONParser();
        InputStream synonymsJSON = ReadSynonymsContentJson.class.getResourceAsStream("/Synonyms_JSON.json");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(synonymsJSON))) {
            JSONObject synonym = (JSONObject) parser.parse(reader);
            return synonym;
        } catch (IOException | ParseException ioException) {
            ioException.printStackTrace();
            return null;
        }
    }

    // method to get each commands
//    public static JSONObject getMovementSynonym(String move) {
//        JSONObject synonym= getAllSynonymContentJSON();
//        JSONArray movementArray =
//    }
}
