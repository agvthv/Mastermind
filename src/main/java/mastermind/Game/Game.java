package mastermind.Game;

import mastermind.UI.Menu;

import java.util.HashMap;
import java.util.Scanner;

public abstract class Game {

    private int maxGuess;
    private int currentGuess;
    protected HashMap<Integer, Integer> secretPattern;
    protected Menu menu;

    public Game(int maxGuess, Menu menu, int currentGuess) {
        this.maxGuess = maxGuess;
        this.currentGuess = maxGuess;
        this.menu = menu;
    }

    public int getMaxGuess() {
        return maxGuess;
    }

    public int getCurrentGuess() {
        return currentGuess;
    }


    public void useGuess() {
        currentGuess--;
    }

    public boolean isGameOver() {
        return currentGuess <= 0;
    }

    public void provideFeedback(String playerGuess) {
        int correctPosition = 0;
        int correctNumber = 0;

        // First pass: Check for correct positions
        for (int i = 0; i < playerGuess.length(); i++) {
            int guessedNumber = Character.getNumericValue(playerGuess.charAt(i));

            if (secretPattern.containsKey(guessedNumber) && secretPattern.get(guessedNumber) == i) {
                correctPosition++;
            }
        }

        // Second pass: Count all correct numbers (ignoring position)
        for (int i = 0; i < playerGuess.length(); i++) {
            int guessedNumber = Character.getNumericValue(playerGuess.charAt(i));

            if (secretPattern.containsKey(guessedNumber)) {
                correctNumber++;
            }
        }

        // Provide feedback
        System.out.println("Feedback: " + correctNumber + " correct number(s) and " + correctPosition + " correct position(s).");
    }

    public boolean isCorrectGuess(String playerGuess) {
        if (playerGuess.length() != 4) {
            return false;
        }
        for (int i = 0; i < playerGuess.length(); i++) {
            int guessedNumber = Character.getNumericValue(playerGuess.charAt(i));
            if (!secretPattern.containsKey(guessedNumber) || secretPattern.get(guessedNumber) != i) {
                return false;
            }
        }
        return true;
    }

    protected void generateSecretPattern() {
        try {
            secretPattern = RandomApi.generatePattern(4, 0, 7);
        } catch (Exception e) {
            System.err.println("Error generating random pattern: " + e.getMessage());
        }
    }
    protected String promptValidInput(Scanner scanner, String playerName) {
        String guess;
        do {
            guess = scanner.nextLine();
            if (guess.length() != 4 || !guess.matches("\\d+")) {
                System.out.println("Invalid input. Please enter exactly 4 digits.\n");
            }
        } while (guess.length() != 4 || !guess.matches("\\d+"));

        return guess;
    }


    public abstract void startGame();

    public abstract void runGameLoop();

}
