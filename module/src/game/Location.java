package game;

import java.util.ArrayList;
import java.util.Arrays;

public class Location {

    private ArrayList<String> locations = new ArrayList<>(Arrays.asList("bar", "hideout"));


    public void displayLocations (){
        System.out.println(locations.toString());
    }

}
