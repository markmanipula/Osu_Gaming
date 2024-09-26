package com.game;
import com.combat.PlayerCombatLogic;
import com.display.Window;
import com.map.Map;

import java.util.*;

public class Player{

    //can't be changed so there's no setter
    private static String name = "Jemad";
    private Map map = new Map();
    private Items items = new Items();
    // another test July 21, 2021
    private static ArrayList<Item> inventory = new ArrayList<>();
    // my test
    private static int hp = 100;
    private static String currentLocation = "Outside Bar";
    private static int minDamage = 7;
    private static int maxDamage = 12;
    private final int DEFAULT_MIN_DAMAGE = 7;
    private final int DEFAULT_MAX_DAMAGE = 12;

    private static String equippedWeapon;
    // just an empty constructor
    public Player() {}

    public int getFullHp() {
        return 100;
    }

    public int getMinDamage() {
        return this.minDamage;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getCurrentLocation() {
        return this.currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
    // end of my test

    //so only unique items will be added on the players bag
    private Set<String> playerItems = new HashSet<>();

    //Defeated Enemies ArrayList
    public static ArrayList<String> defeatedEnemies = new ArrayList<>();

    //Display enemies in room
    public static ArrayList<String> displayedEnemies = new ArrayList<>();

    //Defeated Enemies ArrayList
    public static ArrayList<String> defeatedBosses = new ArrayList<>();

    //Display enemies in room
    public static ArrayList<String> displayedBosses = new ArrayList<>();

    //Rooms already visited
    public static ArrayList<String> roomsVisited = new ArrayList<>();

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
        if(item == null || item == "") return;
        playerItems.add(item);
    }

    // my test
    public boolean addItemJson(Item item) {
        System.out.println("From addItemJSON: " + item);
        // inventory = new ArrayList<>();
        if (inventory.contains(item)) {
            System.out.println("Item already exist");
            return false;
        }
        inventory.add(item);
        System.out.println("From addItemJSON: " + inventory);
        return true;
    }

    public String useItemJson(Item item) {
        if (inventory.contains(item)) {
            Item selectedItem = item;
            String type = selectedItem.getItemType();
            switch (type) {
                case "Consumable":
                    int healHPAmount = selectedItem.getItemAffect();
                    if (this.getHp() >= 100) {
                        return "Your hp is full already";
                    }
                    // if it add up and then it is greater than 100 then
                    else if (this.getHp() + healHPAmount >= 100) {
                        this.setHp(100);
                        // remove item
                        inventory.remove(selectedItem);
                        return "Restore your hp";
                    } else if (this.getHp() + healHPAmount < 100) {
                        this.setHp(this.getHp() + healHPAmount);
                        // remove item
                        inventory.remove(selectedItem);
                        return "Restore your hp";
                    } else {
                        System.out.println("Consume: I do not know what happened in use item: return false");
                        return "Consume: I do not know what happened in use item: return false";
                    }
                case "Weapon":
                    int increaseDamageAmount = selectedItem.getItemAffect();
                    setEquippedWeapon(selectedItem.getItemName());
                    this.setMinDamage( DEFAULT_MIN_DAMAGE + increaseDamageAmount );
                    this.setMaxDamage( DEFAULT_MAX_DAMAGE + increaseDamageAmount );
                    inventory.remove(selectedItem);
                    return "Your damage increased by " + increaseDamageAmount;
            }
        }
        return "";
    }

    public String getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(String weaponName) {
        equippedWeapon = weaponName;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
    // end of my test

    public void removeItem(String item){
        if(item == null || item == "") return;
        playerItems.remove(item);
    }

    public Set<String> getPlayerItems() {
        return playerItems;
    }

    public static void legend() throws InterruptedException {
        System.out.println("--------------------------Legend--------------------------");
        System.out.println("go + north/east/south/west: move around to different rooms\n");
        System.out.println("map: display map\n");
        System.out.println("fight + enemy: fight an opponent!\n");
        System.out.println("inspect: look around at your surroundings. also displays your items\n");
        System.out.println("talk + name: talk to friendly characters\n");
        System.out.println("get + item: add an item to your inventory\n");
        System.out.println("legend: display legend\n");
        System.out.println("quit: quit game\n");
        System.out.println("If you don't remember a command, try a synonym. It might just work!\n");
        System.out.println("----------------------Enter to Close----------------------");
        Scanner scanner = new Scanner(System.in);
        String startInput1 = scanner.nextLine();
        Window.clearScreen();
    }

    //add defeated enemies
    public String[] showDefeatedEnemiesList(HashMap<String, String[]> map){
        String[] itemList = map.get("enemies");
        System.out.println(Arrays.toString(itemList));
        return itemList;
    }

    public static void addDefeatedEnemy(String enemy){
        defeatedEnemies.add(enemy);
    }

    public static void addDefeatedBoss(String boss){
        defeatedBosses.add(boss);
    }
}



