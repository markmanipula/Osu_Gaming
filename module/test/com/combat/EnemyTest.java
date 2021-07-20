package com.combat;

import com.character.Enemy;
import com.client.Client;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class EnemyTest {

    @Test
    public void validateEnemyName(){
        Enemy bouncer = new Enemy("bouncer");
        String expected = "bouncer";
        String actual = bouncer.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void validateEnemyHP(){
        Enemy bouncer = new Enemy("bouncer");
        int expected = 30;
        int actual = bouncer.getHp();
        assertEquals(expected, actual);
    }

    @Test
    public void validateEnemyMinDamage(){
        Enemy bouncer = new Enemy("bouncer");
        int expected = 5;
        int actual = bouncer.getMinDamage();
        assertEquals(expected, actual);
    }

    @Test
    public void validateEnemyMaxDamage(){
        Enemy bouncer = new Enemy("bouncer");
        int expected = 10;
        int actual = bouncer.getMaxDamage();
        assertEquals(expected, actual);
    }

   


}
