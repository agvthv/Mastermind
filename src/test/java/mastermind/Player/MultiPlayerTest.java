package mastermind.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class MultiPlayerTest {

    private MultiPlayer player1;
    private MultiPlayer player2;

    @BeforeEach
    void setUp() {

    // Simulate user input for player name
        InputStream originalSystemIn = System.in; // Backup original System.in
        System.setIn(new ByteArrayInputStream("Player1\n".getBytes())); // Mock input stream

        player1 = new MultiPlayer();
        player1.createPlayer();

        InputStream originalSystemIn2 = System.in; // Backup original System.in
        System.setIn(new ByteArrayInputStream("Player2\n".getBytes())); // Mock input stream

        player2 = new MultiPlayer();
        player2.createPlayer();

        System.setIn(originalSystemIn);// Restore original System.in after the setup
        System.setIn(originalSystemIn2);

    }

    @Test
    void testMultiPlayerCreation() {
        assertEquals("Player1", player1.getPlayerName(), "Player 1 name should match the input.");
        assertEquals("Player2", player2.getPlayerName(), "Player 2 name should match the input.");
    }

    @Test
    void testPlayerTurnAlternation() {
        String currentPlayer = player1.getPlayerName();
        currentPlayer = currentPlayer.equals(player1.getPlayerName()) ? player2.getPlayerName() : player1.getPlayerName();

        assertEquals("Player2", currentPlayer, "After Player1's turn, it should be Player2's turn.");
    }
}
