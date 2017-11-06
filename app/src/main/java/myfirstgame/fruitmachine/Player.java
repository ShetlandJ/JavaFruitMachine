package myfirstgame.fruitmachine;

/**
 * Created by James on 03/11/2017.
 */

public class Player {

    private String name;
    private double funds;

    public Player(String name, double funds) {
        this.name = name;
        this.funds = funds;
    }

    public String getName() {
        return name;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds += funds;
    }
}
