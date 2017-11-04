package myfirstgame.fruitmachine;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by James on 03/11/2017.
 */

public class TestFruitMachine {


    FruitMachine fruity;
    FruitMachine spyFruity;
    Symbol allSymbols;
    Player player;

    @Before
    public void before() {
        ArrayList<Symbol> fruitySymbols = new ArrayList<>();
        for (Symbol symbol : allSymbols.values()) {
            fruitySymbols.add(symbol);
        }
        fruity = new FruitMachine("Jumpin' Jack's Jackpot Jackstraveganza", 1000, 5, 3);
        player = new Player("James", 100);
    }

    @Test
    public void fruityHasSymbols() {
        assertEquals(9, fruity.getSymbols().size());
    }

    @Test
    public void canChangeRowNumber() {
        fruity.setRows(5);
        assertEquals(5, fruity.getRows());
    }

    @Test
    public void canGetSymbolAtIndex() {
        Symbol result = fruity.getSymbolAtIndex(1);
        assertEquals(Symbol.GRAPES, result);
    }


    @Test
    public void getRandomAnswer() {
        FruitMachine spy = Mockito.spy(new FruitMachine("Jumpin' Jack's Jackpot Jackstraveganza", 1000, 1, 3));
        Mockito.when(spy.getRandomNumber()).thenReturn(1);
        Symbol result = spy.getAnswer();
        Assert.assertEquals(Symbol.GRAPES, result);
    }


    @Test
    public void canGetThreeInARow(){
        FruitMachine spy = Mockito.spy(new FruitMachine("Jumpin' Jack's Jackpot Jackstraveganza", 1000, 1, 3));
        ArrayList<Symbol> spyArray = new ArrayList<>();
        spyArray.add(Symbol.BELL);
        spyArray.add(Symbol.BELL);
        spyArray.add(Symbol.BELL);

        Mockito.when(spy.spin(player)).thenReturn(spyArray);
        assertEquals(true, spy.rowAllTheSame( spy.spin(player) ));
    }

    @Test
    public void canGetThreeInARow__fail(){
        FruitMachine spy = Mockito.spy(new FruitMachine("Jumpin' Jack's Jackpot Jackstraveganza", 1000, 1, 3));
        ArrayList<Symbol> spyArray = new ArrayList<>();
        spyArray.add(Symbol.PEAR);
        spyArray.add(Symbol.BELL);
        spyArray.add(Symbol.BELL);

        Mockito.when(spy.spin(player)).thenReturn(spyArray);

        assertEquals(false, spy.rowAllTheSame( spy.spin(player) ));
    }

    @Test
    public void canGetJackpot(){
        FruitMachine spy = Mockito.spy(new FruitMachine("Jumpin' Jack's Jackpot Jackstraveganza", 1000, 1, 3));
        ArrayList<Symbol> spyArray = new ArrayList<>();
        spyArray.add(Symbol.CLOVER);
        spyArray.add(Symbol.CLOVER);
        spyArray.add(Symbol.CLOVER);

        Mockito.when(spy.spin(player)).thenReturn(spyArray);
//        spy.rowAllTheSame( spy.spin(player) );
        assertEquals(true, spy.jackpotChecker(player));
    }
}
