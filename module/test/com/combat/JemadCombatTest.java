package com.combat;

import org.junit.Test;

import static org.junit.Assert.*;

public class JemadCombatTest {

    JemadCombat test = new JemadCombat("jemad");

    @Test
    public void attackPositive() {
        String expected = "Jemad plants his feet and throws a straight punch!";
        String actual = test.attack("straight punch");
        assertEquals(expected, actual);
    }

    @Test
    public void attackNegative() {
        String expected = "not a valid move";
        String actual = test.attack("suuuuper kick");
        assertEquals(expected, actual);
    }

    @Test
    public void attackNullNegative() {
        String expected = "not a valid move";
        String actual = test.attack(null);
        assertEquals(expected, actual);
    }
}
