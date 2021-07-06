package com.game;
import com.map.Map;

import java.util.*;

public class Player{

    //can't be changed so there's no setter
    private String name = "Jemad";
    //take out map?
    private Map map = new Map();
    private Items items = new Items();

    //so only unique items will be added on the players bag
    private Set<String> playerItems = new HashSet<>();

    //only uses a constructor with a map
    public Player(Map map){
        this.map = map;
    }

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

    public void addItem(String item){
        playerItems.add(item);
    }

    public void removeItem(String item){
        playerItems.remove(item);
    }

    public Set<String> getPlayerItems() {
        return playerItems;
    }

    public Map map(){
        return map;
    }


    //test client main
    public static void main(String[] args) {

        Map map = new Map();
        Player player = new Player(map);

        player.itemList(player.map().room11Contents());
        String item = player.items.getItem(map.room11Contents(), "Pool Queue");

        player.addItem(item);

        System.out.println(player.getPlayerItems());

        System.out.println(Arrays.toString(player.map().roomItems()));

    }
}



