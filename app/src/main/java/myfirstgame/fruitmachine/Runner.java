package myfirstgame.fruitmachine;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by James on 03/11/2017.
 */

public class Runner {

    public static void main(String[] args) {

        FruitMachine fruity = new FruitMachine("Jumpin' Jack's Jackpot Jackstraveganza", 1000, 1, 3);
        Player player = new Player("James", 100);

        boolean gameWon = true;

        System.out.println("Welcome to " + fruity.getName() + "!");
        System.out.println("It costs £1 to play. Off you go!");


        int counter = 0;
        while (gameWon) {
            ArrayList<Symbol>result = fruity.spin();
            System.out.println("");
            if (fruity.rowAllTheSame(result)) {
                counter++;
                System.out.println("YOU WIN!");
                double payOut = ((result.get(0).getSymbolValue() * 3) * (counter * 0.02));
                System.out.println("Your payout is " + "£" + Math.round(payOut));
                System.exit(0);
            } else {
                counter++;
                System.out.println("YOU LOSE!");
//            }
//            System.out.println("Play again? Press Y + enter to have another go, or Q + enter to quit.");
//            Scanner sc = new Scanner(System.in);
//            String input = sc.nextLine();
//            if (input.toLowerCase().equals("y")){
//                gameWon = true;
//            } else {
//                gameWon = false;
            }
            System.out.println("");
            System.out.println("You've spent £" + counter);
            System.out.println("");

        }

    }



}
