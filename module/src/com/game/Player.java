package com.game;
import com.map.Map;

import java.util.HashMap;

public class Player {

    //can't be changed so there's no setter
    private String name = "Jemad";
    private Map map = new Map();
    private Items items = new Items();

    //only uses a default constructor

    public String getName() {
        return name;
    }

    public void attack(){
        System.out.println(name + " attacks");
    }

    //return list of items
    public String[] itemList(HashMap<String, String[]> map){
        String[] item = items.itemList(map);
        return item;
    }

    public void move(HashMap<String, String[]> direction){
        System.out.println(name + " goes " + direction.get("name")[0]);
    }

}



