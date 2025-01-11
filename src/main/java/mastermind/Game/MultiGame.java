package mastermind.Game;

import mastermind.Player.MultiPlayer;
import mastermind.UI.Menu;

import java.util.HashMap;
import java.util.Scanner;

public class MultiGame extends Game {

    private MultiPlayer player1;
    private MultiPlayer player2;
    private HashMap<String, Integer> playerGuesses; // Track remaining guesses for each player

    public MultiGame(Menu menu) {
        super(10, menu, 10);
        playerGuesses = new HashMap<>();
    }

    @Override
    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        player1 = new MultiPlayer();
        player2 = new MultiPlayer();
        player1.createPlayer();
        player2.createPlayer();

        // Initialize remaining guesses for each player
        playerGuesses.put(player1.getPlayerName(), getMaxGuess());
        playerGuesses.put(player2.getPlayerName(), getMaxGuess());

        generateSecretPattern();
        System.out.println("Starting game between " + player1.getPlayerName() + " and " + player2.getPlayerName() + "...");
        System.out.println("You each have " + getMaxGuess() + " attempts to guess the 4-digit pattern (0-7).");
        System.out.println("Good luck!\n");
        runGameLoop();
    }

    @Override
    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);

        while (playerGuesses.get(player1.getPlayerName()) > 0 || playerGuesses.get(player2.getPlayerName()) > 0) {
            // Player 1's turn
            if (playerGuesses.get(player1.getPlayerName()) > 0) {
                System.out.println(player1.getPlayerName() + ", enter your guess:");
                String guess1 = promptValidInput(scanner, player1.getPlayerName());
                provideFeedback(guess1);
                if (guess1.length() != 4) {
                    System.out.println("Invalid input. Please enter exactly 4 digits.\n");
                }
                System.out.println();

                provideFeedback(guess1);

                if (isCorrectGuess(guess1)) {
                    System.out.println("Congratulations " + player1.getPlayerName() + "! You guessed the correct pattern!\n");
                    return;
                }

                decrementGuesses(player1.getPlayerName());
                System.out.println("Remaining guesses for " + player1.getPlayerName() + ": " + playerGuesses.get(player1.getPlayerName()) + "\n");
            }

            // Player 2's turn
            if (playerGuesses.get(player2.getPlayerName()) > 0) {
                System.out.println(player2.getPlayerName() + ", enter your guess:");
                String guess2 = promptValidInput(scanner, player1.getPlayerName());
                provideFeedback(guess2);
                if (guess2.length() != 4) {
                    System.out.println("Invalid input. Please enter exactly 4 digits.\n");
                }
                System.out.println();

                provideFeedback(guess2);

                if (isCorrectGuess(guess2)) {
                    System.out.println("Congratulations " + player2.getPlayerName() + "! You guessed the correct pattern!");
                    return;
                }

                decrementGuesses(player2.getPlayerName());
                System.out.println("Remaining guesses for " + player2.getPlayerName() + ": " + playerGuesses.get(player2.getPlayerName()) + "\n");
            }
        }

        System.out.println("Game over! The correct pattern was: " + secretPattern.keySet() + "\n");
        System.out.println("Guess the computer still outsmarted you ... for now.\n");
        menu.closing();
    }

    private void decrementGuesses(String playerName) {
        int guessesLeft = playerGuesses.get(playerName);
        playerGuesses.put(playerName, guessesLeft - 1);
    }
}
