package com.example.dotcom;
import java.util.*;

public class DotComBust {

    private int numOfGuesses = 0;
    private chap05.GameHelper helper = new chap05.GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();

    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Onior.nl");
        DotCom two = new DotCom();
        two.setName("Hello.nl");
        DotCom three = new DotCom();
        three.setName("Nu.nl");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Your goal is to sink three dot nls.");
        System.out.println("Onior.nl, Hello.nl, Nu.nl");
        System.out.println("Try to sink them all in the fewest number of guesses.");

        for (DotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess: ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss!";

        for (Dotcom dotcomToTest : dotComsList) {
            result = dotcomToTest.checkYourself(userGuess);
            if (result.equals("hit!")) {
                break;
            }
            if (result.equals("kill")) {
                dotComsList.remove(dotcomToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
            System.out.println("All Dot nls are dead!");
            if (numOfGuesses <= 18) {
                System.out.println("It only took you " + numOfGuesses + " guesses.");
            } else {
                System.out.println("It took you long enough. " + numOfGuesses + " guesses");
            }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();

    }
}
