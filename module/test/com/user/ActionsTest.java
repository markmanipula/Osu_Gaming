package com.user;

import com.client.Client;
import com.game.Player;
import com.map.Map;
import com.readjson.ReadRoomContentJson;
import com.readjson.ReadSynonymsContentJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ActionsTest {


    @Test
    public void displayLastActionTakenFail() {
       String expected = "No instruction";
       String actual = Client.getLastValidInstruction();
       assertEquals(expected, actual);
    }

    @Test
    public void displayLastActionTakenSuccess() {
        Client.instructionSet.add("go east");
        String expected = "go east";
        String actual = Client.getLastValidInstruction();
        assertEquals(expected, actual);
    }





}
