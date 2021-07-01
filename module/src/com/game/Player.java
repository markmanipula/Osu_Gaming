package com.game;
import com.map.Map;

public class Player {

    //can't be changed so there's no setter
    private String name = "Jemad";
    private Direction direction;
    private String location;
    private Map map = new Map();
    private String playerCurrentRoom;

    //only uses a default constructor

    public String getName() {
        return name;
    }

    public void attack(){
        System.out.println(name + " attacks");

    }

    public void getPlayerCurrentRoom(){

    }

    public void move(Direction direction){
        System.out.println(name + " goes " + direction.toString().toLowerCase());
    }

}



