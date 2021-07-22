package com.replay;

import com.game.Player;
import com.map.Map;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadGame {
    private static Scanner scanner = new Scanner(System.in);
    private static String fileName = "";

//    public static void choosePreviousSaveFile(){
//        System.out.println("Enter the name of your file and file type please.");
//        System.out.println("Example: myFilename.txt");
//        fileName = scanner.nextLine();
//    }


    public static ArrayList<Object> loadAttributesFromSaveGameFile(){
        //Loads attributes from saved file user chooses

        ArrayList<Object> attributes = new ArrayList<>();

        try{
            BufferedReader saveFile = new BufferedReader(new FileReader("savedGame.txt"));
            int playerHP = Integer.parseInt(saveFile.readLine());
            String currentLocation = saveFile.readLine();
            int minDamage = Integer.parseInt(saveFile.readLine());
            int maxDamage = Integer.parseInt(saveFile.readLine());
            int itemCount = 0;
            ArrayList<String> listOfItems = new ArrayList<String>();
            String nextLine = saveFile.readLine();
            while (nextLine != null){
                itemCount += 1;
                listOfItems.add(nextLine);
                nextLine = saveFile.readLine();
            }

            //adding attributes to ArrayList
            attributes.add(playerHP);
            attributes.add(currentLocation);
            attributes.add(minDamage);
            attributes.add(maxDamage);
            if (listOfItems.size() > 0){
                for (String item: listOfItems){
                    attributes.add(item);
                }
            }

            //closing saved file
            saveFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (Exception e){
            System.out.println("Could not load saved game attributes");
        }

        return attributes;

    }


}
