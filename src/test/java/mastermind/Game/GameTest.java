package mastermind.Game;

import mastermind.UI.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        Menu mockMenu = new Menu();
        game = new SingleGame(mockMenu);
    }

    @Test
    void testIsGameOver() {
        assertFalse(game.isGameOver());
        game.useGuess();
        assertFalse(game.isGameOver());
        for (int i = 0; i < 10; i++) {
            game.useGuess();
        }
        assertTrue(game.isGameOver());
    }

    @Test
    void testProvideFeedback() {

        game.generateSecretPattern();
        String validGuess = "1234";
        assertDoesNotThrow(() -> game.provideFeedback(validGuess));
    }
}
