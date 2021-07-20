package com.readjson;

import org.json.simple.JSONArray;
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

    public static JSONObject getSpecificGameStory(String gameLocation) {
        JSONObject allStoryObject = ReadStoryContentJson.getAllStoryContentJSON();
        JSONObject storyObject = (JSONObject) allStoryObject.get(gameLocation);
        return storyObject;
    }

    public static String trimGameIntro(String gameLocation) {
        StringBuilder strBuilder = new StringBuilder();
        JSONObject storyData = getSpecificGameStory(gameLocation);
        JSONArray introArray = (JSONArray) storyData.get("Intro");
        String longDescriptionData = String.valueOf(introArray.get(0));
        String shortDescriptionArr[] = longDescriptionData.split("  ");
        for (int i = 0; i < shortDescriptionArr.length; i++) {
            strBuilder.append(shortDescriptionArr[i] + "\n");
            // System.out.println(shortDescriptionArr[i]);
        }
        return strBuilder.toString();
    }

    public static String trimGameScenePrintHelper(String gameLocation, String specificScene ,String scene) {
        StringBuilder strBuilder = new StringBuilder();
        try {
            JSONObject storyData = getSpecificGameStory(gameLocation);
            JSONObject buildingData = (JSONObject) storyData.get(specificScene);
            // System.out.println(buildingData.get(scene));
            String longDescriptionData= String.valueOf(buildingData.get(scene));
            // String longDescriptionData = String.valueOf(introArray.get(0));
            String shortDescriptionArr[] = longDescriptionData.split("  ");
            for (int i = 0; i < shortDescriptionArr.length; i++) {
                strBuilder.append(shortDescriptionArr[i] + "\n");
                // strBuilder.append(shortDescriptionArr[i]);
                // System.out.println(shortDescriptionArr[i]);
            }
            return strBuilder.toString();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return "";
        }
    }

    // utilize method overloading for 4th params
    public static String trimGameScenePrintHelper(String gameLocation, String specificScene ,String scene, String finalScene) {
        StringBuilder strBuilder = new StringBuilder();
        try {
            JSONObject storyData = getSpecificGameStory(gameLocation);
            JSONObject buildingData = (JSONObject) storyData.get(specificScene);
            // System.out.println(buildingData.get(scene));
            JSONObject gameOutro = (JSONObject) buildingData.get(scene);
            String longDescriptionData = String.valueOf(gameOutro.get(finalScene));
            String shortDescriptionArr[] = longDescriptionData.split("  ");
            for (int i = 0; i < shortDescriptionArr.length; i++) {
                strBuilder.append(shortDescriptionArr[i] + "\n");
                // System.out.println(shortDescriptionArr[i]);
            }
            return strBuilder.toString();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return "";
        }
    }

}
