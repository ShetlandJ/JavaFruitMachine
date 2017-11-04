package myfirstgame.fruitmachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by James on 03/11/2017.
 */

public class TestPlayer {

    Player player;

    @Before
    public void setUp(){
        player = new Player("James", 100);
    }

    @Test
    public void canSetFunds(){
        player.setFunds(-50);
        assertEquals(50, player.getFunds());
    }

}
