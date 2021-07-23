package com.readjson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;

public class ReadItemContentJson {
    private static JSONParser parser = null;

    public static JSONObject getAllItemContentJSON() {
        parser = new JSONParser();
        InputStream itemJSON = ReadItemContentJson.class.getResourceAsStream("/Item_JSON.json");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(itemJSON))){
            JSONObject itemObject = (JSONObject) parser.parse(reader);
            return itemObject;
        } catch (IOException | ParseException ioException) {
            ioException.printStackTrace();
            return null;
        }
    }

    // helper method to retrieve all items existing in the current location
    public static JSONArray getItemBasedOnLocation(String currentLocation) {
        JSONObject allItem = ReadItemContentJson.getAllItemContentJSON();
        JSONObject itemJSON = (JSONObject) allItem.get(currentLocation);
        JSONArray itemArray = (JSONArray) itemJSON.get("item");
        return  itemArray;
    }

    public static JSONObject getItemBasedOnItemName(String itemName) {
        JSONObject allItem  = ReadItemContentJson.getAllItemContentJSON();
        // System.out.println(allItem.size());
        // need to retrieve all keys
        Set<String> allPossibleKeys = allItem.keySet();
        ArrayList<String> listKeys = new ArrayList<>(allPossibleKeys);
        // System.out.println(listKeys.size());

        for (int i = 0; i < listKeys.size(); i++) {
            JSONObject eachLocation = (JSONObject) allItem.get(listKeys.get(i));
            // System.out.println(eachLocation);
            if (eachLocation == null || eachLocation.size() == 0) {
                continue;
            }
            JSONArray eachItemArray = (JSONArray) eachLocation.get("item");

            for (int j = 0; j < eachItemArray.size(); j++) {
                JSONObject eachItem = (JSONObject) eachItemArray.get(j);
                String eachItemName = String.valueOf(eachItem.get("name"));
                if (eachItemName.equals(itemName)) {
                    return eachItem;
                }
                // System.out.println(eachItem);
            }
        }
        return null;
    }
}
