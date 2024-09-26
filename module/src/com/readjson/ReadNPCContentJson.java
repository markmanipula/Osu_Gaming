package com.readjson;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadNPCContentJson {
    private static JSONParser parser = null;

    public static JSONObject getAllNPCContentJSON() {
        parser = new JSONParser();
        InputStream synonymsJSON = ReadStoryContentJson.class.getResourceAsStream("/NPC_JSON.json");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(synonymsJSON))) {
            JSONObject npcObject = (JSONObject) parser.parse(reader);
            return npcObject;
        } catch (IOException | ParseException ioException) {
            ioException.printStackTrace();
            return null;
        }
    }
}
