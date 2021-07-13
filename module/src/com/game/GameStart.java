package com.game;

import com.combat.PlayerCombatLogic;
import org.json.JSONObject;
import com.client.Client;

import java.util.Scanner;

public class GameStart {



    public static void start(String intro) throws InterruptedException {
        PlayerCombatLogic.clearScreen();
        System.out.println("-----------------------\n");
        Thread.sleep(4000);
        System.out.println("\n");
        System.out.println(",.\n" +
                " \\-'__\n" +
                "/ o.__o____ \n" +
                "\\/_/ /.___/--,  From Osu Gaming Studio...\n" +
                "  ||\\'\n" +
                "  | /\n" +
                "  \\_\\\n" +
                "  -''");
        System.out.println("-----------------------");
        Thread.sleep(2000);
        PlayerCombatLogic.clearScreen();

        System.out.println("\n" + "\n"+ "\n"+ "\n");
        System.out.println(" _________      .__       .__  __            _____    __  .__             ___________.__          __        \n" +
                " /   _____/_____ |__|______|__|/  |_    _____/ ____\\ _/  |_|  |__   ____   \\_   _____/|__| _______/  |_      \n" +
                " \\_____  \\\\____ \\|  \\_  __ \\  \\   __\\  /  _ \\   __\\  \\   __\\  |  \\_/ __ \\   |    __)  |  |/  ___/\\   __\\     \n" +
                " /        \\  |_> >  ||  | \\/  ||  |   (  <_> )  |     |  | |   Y  \\  ___/   |     \\   |  |\\___ \\  |  |       \n" +
                "/_______  /   __/|__||__|  |__||__|    \\____/|__|     |__| |___|  /\\___  >  \\___  /   |__/____  > |__|       \n" +
                "        \\/|__|                                                  \\/     \\/       \\/            \\/             ");

        System.out.println("   _____              .___                                    _____       ____.                          .___\n" +
                "  /     \\ _____     __| _/____   ____   ______ ______   _____/ ____\\     |    | ____   _____ _____     __| _/\n" +
                " /  \\ /  \\\\__  \\   / __ |/    \\_/ __ \\ /  ___//  ___/  /  _ \\   __\\      |    |/ __ \\ /     \\\\__  \\   / __ | \n" +
                "/    Y    \\/ __ \\_/ /_/ |   |  \\  ___/ \\___ \\ \\___ \\  (  <_> )  |    /\\__|    \\  ___/|  Y Y  \\/ __ \\_/ /_/ | \n" +
                "\\____|__  (____  /\\____ |___|  /\\___  >____  >____  >  \\____/|__|    \\________|\\___  >__|_|  (____  /\\____ | \n" +
                "        \\/     \\/      \\/    \\/     \\/     \\/     \\/                               \\/      \\/     \\/      \\/ ");

        System.out.println("\n" + "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n");
        System.out.println("----------------------Press Enter----------------------");
        Scanner scanner = new Scanner(System.in);
        String startInput1 = scanner.nextLine();
        PlayerCombatLogic.clearScreen();

        System.out.println(intro);
        System.out.println("\n" + "\n"+ "\n"+ "\n"+ "\n"+ "\n"+ "\n");
        System.out.println("----------------------Press Enter----------------------");
        Scanner scanner2 = new Scanner(System.in);
        String startInput2 = scanner.nextLine();
        PlayerCombatLogic.clearScreen();
        //Display Legend
        Player.legend();
        System.out.println("you step out of your cab, in front of the entrance to a bar at the casino... ");
        Thread.sleep(3000);
    }
    //Runs when player finishes game
    public static void gameEnd(){
        //Clears screen for player
        PlayerCombatLogic.clearScreen();

        System.out.println("Thank you for playing..\n");
        System.out.println("\n" + "\n"+ "\n"+ "\n");
        System.out.println(" _________      .__       .__  __            _____    __  .__             ___________.__          __        \n" +
                " /   _____/_____ |__|______|__|/  |_    _____/ ____\\ _/  |_|  |__   ____   \\_   _____/|__| _______/  |_      \n" +
                " \\_____  \\\\____ \\|  \\_  __ \\  \\   __\\  /  _ \\   __\\  \\   __\\  |  \\_/ __ \\   |    __)  |  |/  ___/\\   __\\     \n" +
                " /        \\  |_> >  ||  | \\/  ||  |   (  <_> )  |     |  | |   Y  \\  ___/   |     \\   |  |\\___ \\  |  |       \n" +
                "/_______  /   __/|__||__|  |__||__|    \\____/|__|     |__| |___|  /\\___  >  \\___  /   |__/____  > |__|       \n" +
                "        \\/|__|                                                  \\/     \\/       \\/            \\/             ");

        System.out.println("   _____              .___                                    _____       ____.                          .___\n" +
                "  /     \\ _____     __| _/____   ____   ______ ______   _____/ ____\\     |    | ____   _____ _____     __| _/\n" +
                " /  \\ /  \\\\__  \\   / __ |/    \\_/ __ \\ /  ___//  ___/  /  _ \\   __\\      |    |/ __ \\ /     \\\\__  \\   / __ | \n" +
                "/    Y    \\/ __ \\_/ /_/ |   |  \\  ___/ \\___ \\ \\___ \\  (  <_> )  |    /\\__|    \\  ___/|  Y Y  \\/ __ \\_/ /_/ | \n" +
                "\\____|__  (____  /\\____ |___|  /\\___  >____  >____  >  \\____/|__|    \\________|\\___  >__|_|  (____  /\\____ | \n" +
                "        \\/     \\/      \\/    \\/     \\/     \\/     \\/                               \\/      \\/     \\/      \\/ ");

        System.out.println("\n" + "\n"+ "\n");
        System.out.println("Collaboration by Daniel, Mark and Jelani");
    }
}
