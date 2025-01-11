package mastermind.Game;

import mastermind.Player.SinglePlayer;
import mastermind.UI.Menu;
import java.util.Scanner;

public class SingleGame extends Game {

    private SinglePlayer player1;

    public SingleGame(Menu menu) {
        super(10, menu, 10);
    }

    @Override
    public void startGame()
    {
        player1 = new SinglePlayer();
        player1.createPlayer();

        generateSecretPattern();
        System.out.println("Starting game for " + player1.getPlayerName() + "...");
        System.out.println("You have " + getMaxGuess() + " attempts to guess the 4-digit pattern (0-7).");
        System.out.println("Good luck!\n");
        runGameLoop();
    }

    @Override
    public void runGameLoop()
    {
        while (!isGameOver()) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter your guess (e.g., 1234):\n");
            String playerGuess = promptValidInput(scanner, player1.getPlayerName());

            provideFeedback(playerGuess);


            if (isCorrectGuess(playerGuess)) {
                System.out.println("Congratulations! You guessed the correct pattern!\n");
                return;
            }
            useGuess();
            System.out.println("Remaining guesses: " + getCurrentGuess() + "\n");
        }

        System.out.println("Game over! The correct pattern was: " + secretPattern.keySet() + "\n");
        System.out.println("Guess the computer still outsmarted you ... for now.\n");
        menu.closing();
    }
}
