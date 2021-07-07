package com.client;

import com.json.JsonPath;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class ClientReadsFromExternal {

    public static void main(String[] args) {

        //File src = new File("/Users/marmanip/IdeaProjects/Osu_Gaming/module/src/com/json/Rooms_JSON.txt");
        //String roomJson = "/Users/marmanip/IdeaProjects/Osu_Gaming/module/src/com/json/Rooms_JSON.txt";

        JsonPath path = new JsonPath();

        try {
            String roomContents = new String((Files.readAllBytes(Paths.get(path.roomPath()))));
            String enemyContents = new String((Files.readAllBytes(Paths.get(path.enemyPath()))));
            String moveContents = new String((Files.readAllBytes(Paths.get(path.movesPath()))));
            String synonymContents = new String((Files.readAllBytes(Paths.get(path.synonymsPath()))));

            JSONObject o = new JSONObject(roomContents);

            JSONObject outsideBar = o.getJSONObject("Outside Bar");
            JSONArray outsideBarEnemies = outsideBar.getJSONArray("enemies");

            System.out.println(outsideBar);
            System.out.println(outsideBarEnemies.get(0));

            System.out.println("-----");

            JSONObject a = new JSONObject(enemyContents);

            JSONObject enemies = a.getJSONObject("Bouncer");
            System.out.println(enemies);


            JSONObject b = new JSONObject(moveContents);
            JSONArray jemad = b.getJSONArray("Jemad Attacks");
            System.out.println(jemad);

            JSONObject c = new JSONObject(synonymContents);
            JSONArray synonym = c.getJSONArray("go");
            System.out.println(synonym);
        }
        catch (IOException | JSONException e){
            e.printStackTrace();
        }

    }

}
