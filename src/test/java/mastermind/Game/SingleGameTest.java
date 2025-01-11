package mastermind.Game;

import mastermind.UI.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SingleGameTest {

    private SingleGame singleGame;

    @BeforeEach
    void setUp() {

        singleGame = new SingleGame(new Menu());

        singleGame.secretPattern = new HashMap<>();
        singleGame.secretPattern.put(1, 0);
        singleGame.secretPattern.put(2, 1);
        singleGame.secretPattern.put(3, 2);
        singleGame.secretPattern.put(4, 3);
    }

    @Test
    void testGameRequiresMinimumFourDigitsForGuess() {

        InputStream originalSystemIn = System.in; // Backup original System.in
        try {
            // Mock input for guesses
            System.setIn(new ByteArrayInputStream("123\n1234\n".getBytes()));

            // Validate guess lengths
            assertFalse(singleGame.isCorrectGuess("123"), "Guess with fewer than 4 digits should not be accepted.");
            assertTrue(singleGame.isCorrectGuess("1234"), "Valid guess with 4 digits should be processed.");
        } finally {
            // Restore original System.in
            System.setIn(originalSystemIn);
        }
    }
}
