package mastermind.Game;

import mastermind.UI.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class MultiGameTest {

    private MultiGame multiGame;

    @BeforeEach
    void setUp() {
        // Initialize MultiGame with a mock Menu
        multiGame = new MultiGame(new Menu());

        // Mock secretPattern
        multiGame.secretPattern = new HashMap<>();
        multiGame.secretPattern.put(1, 0);
        multiGame.secretPattern.put(2, 1);
        multiGame.secretPattern.put(3, 2);
        multiGame.secretPattern.put(4, 3);
    }

    @Test
    void testGameRequiresMinimumFourDigitsForGuess() {
        InputStream originalSystemIn = System.in; // Backup original System.in

        try {
            // Mock input for guesses
            System.setIn(new ByteArrayInputStream("123\n1234\n".getBytes()));

            // Validate guess lengths
            assertFalse(multiGame.isCorrectGuess("123"), "Guess with fewer than 4 digits should not be accepted.");
            assertTrue(multiGame.isCorrectGuess("1234"), "Valid guess with 4 digits should be processed.");
        } finally {
            // Restore original System.in
            System.setIn(originalSystemIn);
        }
    }

}
