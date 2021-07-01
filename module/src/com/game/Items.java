package com.game;

import java.util.Arrays;
import java.util.HashMap;

public class Items {

    public String[] itemList(HashMap<String, String[]> map){

        String[] itemList = map.get("items");

        System.out.println(Arrays.toString(itemList));
        return itemList;
    }
}
