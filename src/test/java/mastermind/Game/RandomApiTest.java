package mastermind.Game;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class RandomApiTest {

    @Test
    void testSecretPatternWithinRange() {
        try {
            // Generate the secret pattern
            HashMap<Integer, Integer> secretPattern = RandomApi.generatePattern(4, 0, 7);

            // Check that no keys are outside the range [0, 7]
            for (int key : secretPattern.keySet()) {
                assertTrue(key >= 0 && key <= 7, "Key " + key + " is outside the range [0, 7].");
            }
        } catch (Exception e) {
            fail("Exception occurred while generating the secret pattern: " + e.getMessage());
        }
    }
}
