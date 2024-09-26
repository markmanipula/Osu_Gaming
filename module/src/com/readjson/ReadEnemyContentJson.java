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

    // method to get enemy minimum attack damage
    // returns -1 if not valid
    public static int getEnemyMinimumDamageJson(String enemyName) {
        JSONObject selectedEnemy = ReadEnemyContentJson.getSelectedEnemyJSON(enemyName);
        if (selectedEnemy == null) {
            return -1;
        }
        String minDamageString = String.valueOf(selectedEnemy.get("Min Attack"));
        int minDamage = Integer.parseInt(minDamageString);
        return minDamage;
    }

    // method to get enemy maximum attack damage
    // returns -1 if not valid
    public static int getEnemyMaximumDamageJson(String enemyName) {
        JSONObject selectedEnemy = ReadEnemyContentJson.getSelectedEnemyJSON(enemyName);
        if (selectedEnemy == null) {
            return -1;
        }
        String maxDamageString = String.valueOf(selectedEnemy.get("Max Attack"));
        int maxDamage = Integer.parseInt(maxDamageString);
        return maxDamage;
    }

    // method to get enemy health
    // returns -1 if not valid
    public static int getSelectedEnemyHeathJson(String enemyName) {
        JSONObject selectedEnemy = ReadEnemyContentJson.getSelectedEnemyJSON(enemyName);
        if (selectedEnemy == null) {
            return -1;
        }
        String enemyHealthString = String.valueOf(selectedEnemy.get("Max Health"));
        int enemyMaxHealth = Integer.valueOf(enemyHealthString);
        return enemyMaxHealth;
    }
}
