package com.readjson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadWeaponMovementContent {
    private static JSONParser parser = null;

    public static JSONObject getAllWeaponMovementsJSON() {
        parser = new JSONParser();
        InputStream weaponMovementJSON = ReadWeaponMovementContent.class.getResourceAsStream("/WeaponMovements.json");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(weaponMovementJSON))) {
            JSONObject weaponObj = (JSONObject) parser.parse(reader);
            return weaponObj;
        } catch (IOException | ParseException ioException) {
            ioException.printStackTrace();
            return null;
        }
    }

    // method to get possibleMovement based on weapon name
    public static JSONArray getSpecificWeaponMovementJSON(String weaponName) {
        JSONObject specificWeaponMovement = ReadWeaponMovementContent.getAllWeaponMovementsJSON();
        try {
            JSONObject weaponObj = (JSONObject) specificWeaponMovement.get(weaponName);
            return (JSONArray) weaponObj.get("movements");
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
