package com.game;

import com.map.Map;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PlayerTest {

    Map mapTest = new Map();
    Player playerTest = new Player(mapTest);

    @Test
    public void addItemPositive() {
        Set<String> expectedSet = new HashSet<>();
        expectedSet.add("bag");
        playerTest.addItem("bag");
        assertEquals(expectedSet, playerTest.getPlayerItems());
    }

    @Test
    public void addItemEmptyStringNegative() {
        Set<String> expectedSet = new HashSet<>();
        playerTest.addItem("");
        assertEquals(expectedSet, playerTest.getPlayerItems());
    }

    @Test
    public void addItemNullStringNegative() {
        Set<String> expectedSet = new HashSet<>();
        playerTest.addItem(null);
        assertEquals(expectedSet, playerTest.getPlayerItems());
    }

    @Test
    public void removeItemNullStringNegative() {
        Set<String> expectedSet = new HashSet<>();
        playerTest.removeItem(null);
        assertEquals(expectedSet, playerTest.getPlayerItems());
    }

    @Test
    public void removeItemEmptyStringNegative() {
        Set<String> expectedSet = new HashSet<>();
        playerTest.removeItem("");
        assertEquals(expectedSet, playerTest.getPlayerItems());
    }

    @Test
    public void removeItemPositive() {
        Set<String> expectedSet = new HashSet<>();
        expectedSet.add("bag");
        expectedSet.add("water");
        expectedSet.add("computer");
        expectedSet.remove("water");
        playerTest.addItem("bag");
        playerTest.addItem("water");
        playerTest.addItem("computer");
        playerTest.removeItem("water");
        assertEquals(expectedSet, playerTest.getPlayerItems());
    }
}