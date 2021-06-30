package com.game;
import com.map.map;

public class Player {

    //can't be changed so there's no setter
    private String name = "Jemad";
    private Direction direction;
    private String location;
    private map map = new map();

    //only uses a default constructor

    public String getName() {
        return name;
    }

    public void attack(){
        System.out.println(name + " attacks");

    }

    public void move(Direction direction){
        System.out.println(name + " goes " + direction.toString().toLowerCase());
        System.out.println(name + " is currently in " + map.getRoom(direction.ordinal()));
    }


    //this is a test main
    public static void main(String[] args) {
        Player player = new Player();

        player.move(Direction.NORTH);

    }
}



