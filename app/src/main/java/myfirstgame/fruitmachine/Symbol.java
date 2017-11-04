package myfirstgame.fruitmachine;

/**
 * Created by James on 03/11/2017.
 */

public enum Symbol {
    APPLE("Apple", 1, "🍎"),
    GRAPES("Grapes", 2, "🍇"),
    STRAWBERRY("Strawberry", 3, "🍓"),
    PEAR("Pear", 4, "🍐"),
    BELL("Bell", 5, "🔔"),
    HORSESHOE("Horseshoe", 7, "🐎"),
    EIGHT("Eight", 8, "🎱"),
    DIAMOND("Diamond", 10, "💎"),
    CLOVER("Clover", 15, "🍀");

    protected String symbolName;
    private int symbolValue;
    private String emoji;

    Symbol(String symbolName, int symbolValue, String emoji) {
        this.symbolName = symbolName;
        this.symbolValue = symbolValue;
        this.emoji = emoji;


    }

    public String getSymbolName() {
        return symbolName;
    }

    public int getSymbolValue() {
        return symbolValue;
    }

    public String getEmoji() {
        return emoji;
    }
}
