package mastermind.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class SinglePlayerTest {

    private SinglePlayer player;

    @BeforeEach
    void setUp() {
        // Simulate user input for player name
        InputStream originalSystemIn = System.in; // Backup original System.in
        System.setIn(new ByteArrayInputStream("Player1\n".getBytes())); // Mock input stream

        player = new SinglePlayer();
        player.createPlayer(); // Create player using the mocked input

        System.setIn(originalSystemIn); // Restore original System.in after the setup
    }

    @Test
    void testSinglePlayerCreation() {
        assertEquals("Player1", player.getPlayerName(), "Player name should match the input name.");
    }

    @Test
    void testSetPlayerName() {
        player.setPlayerName("UpdatedName");
        assertEquals("UpdatedName", player.getPlayerName(), "Player name should be updated correctly.");
    }
}
