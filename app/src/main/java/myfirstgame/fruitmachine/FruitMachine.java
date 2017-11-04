package myfirstgame.fruitmachine;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by James on 03/11/2017.
 */

public class FruitMachine {

    private String name;
    private int fundsAvailable;
    private int costToPlay;
    private ArrayList<Symbol> symbols;
    private int rows;
    private Symbol allSymbols;

    public FruitMachine(String name, int fundsAvailable, int costToPlay, int rows) {
        this.name = name;
        this.fundsAvailable = fundsAvailable;
        this.costToPlay = costToPlay;
        this.rows = rows;
        this.symbols = new ArrayList<>();
        for (Symbol symbol : allSymbols.values()) {
            symbols.add(symbol);
        }
    }

    public int getFundsAvailable() {
        return fundsAvailable;
    }

    public ArrayList<Symbol> getSymbols() {
        return symbols;
    }

    public int getRows() {
        return rows;
    }

    public String getName() {
        return name;
    }

    public int getCostToPlay() {
        return costToPlay;
    }

    public void setCostToPlay(int costToPlay) {
        this.costToPlay = costToPlay;
    }

    public void setFundsAvailable(int fundsAvailable) {
        this.fundsAvailable = fundsAvailable;
    }

    public void setSymbols(ArrayList<Symbol> symbols) {
        this.symbols = symbols;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getNumberOfSymbols() {
        return symbols.size();
    }

    public Symbol getSymbolAtIndex(int index) {
        return this.symbols.get(index);
    }

    public int getRandomNumber() {
        Random rand = new Random();
        int listSize = getNumberOfSymbols();
        int random = rand.nextInt(listSize);
        return random;
    }

    public Symbol getAnswer() {
        int index = getRandomNumber();
        Symbol answer = getSymbolAtIndex(index);
        return answer;
    }

    public boolean playerCanAfford(Player player) {
        if (player.getFunds() > costToPlay) {
            return true;
        }
        return false;
    }


    public ArrayList<Symbol> spin() {
        ArrayList<Symbol> spinReturns = new ArrayList<>();
        int counter = 0;
        while (counter < getRows()) {
            spinReturns.add(getSymbolAtIndex(getRandomNumber()));
            counter++;
        }
        for (Symbol symbol : spinReturns)
            System.out.print(" " + symbol.getEmoji() + " ");
        return spinReturns;
    }

    public boolean rowAllTheSame(ArrayList<Symbol> result) {
        boolean matched = true;

        for (int i = 1; i < result.size(); i++) {
            if (!result.get(i).equals(result.get(i - 1))) {
                matched = false;
                break;
            }
        }
        return matched;
    }

    public boolean jackpotChecker(ArrayList<Symbol> result) {
        return rowAllTheSame(result) && (result.get(0).getSymbolName().equals("Clover"));
    }

}
