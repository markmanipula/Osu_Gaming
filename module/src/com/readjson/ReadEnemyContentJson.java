package com.readjson;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadEnemyContentJson {
    private static JSONParser parser = null;

    public static JSONObject getAllEnemyContentJSON() {
        parser = new JSONParser();
        InputStream enemyContentJSON = ReadEnemyContentJson.class.getResourceAsStream("/Enemies_JSON.json");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(enemyContentJSON))) {
            JSONObject enemyObject = (JSONObject) parser.parse(reader);
            return enemyObject;
        } catch (IOException | ParseException ioException) {
            ioException.printStackTrace();
            return null;
        }
    }

    // method to get enemy health using enemy name
    public static JSONObject getSelectedEnemyJSON(String enemyName) {
        JSONObject allEnemyObj = ReadEnemyContentJson.getAllEnemyContentJSON();
        JSONObject enemyObj = (JSONObject) allEnemyObj.get(enemyName);
        return enemyObj;
    }

//    public static void main(String[] args) {
//        JSONObject allEnemyObj = ReadEnemyContentJson.getAllEnemyContentJSON();
//        System.out.println(allEnemyObj.containsKey("bouncer"))
//    }
}
