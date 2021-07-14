package com.readjson;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadStoryContentJson {
    private static JSONParser parser = null;

    public static JSONObject getAllStoryContentJSON() {
        parser = new JSONParser();
        InputStream synonymsJSON = ReadStoryContentJson.class.getResourceAsStream("/Story_JSON.json");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(synonymsJSON))) {
            JSONObject storyObject = (JSONObject) parser.parse(reader);
            return storyObject;
        } catch (IOException | ParseException ioException) {
            ioException.printStackTrace();
            return null;
        }
    }
}
