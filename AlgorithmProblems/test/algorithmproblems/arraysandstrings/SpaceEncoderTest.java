/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmproblems.arraysandstrings;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class SpaceEncoderTest {

    @Test
    public void testEncodeSpace() {
        char[] characters = "I am Superman.    ".toCharArray();
        char[] expected = "I%20am%20Superman.".toCharArray();
        SpaceEncoder.encodeSpace(characters);
        assertArrayEquals(expected, characters);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEncodeSpaceWithInadequateString() {
        char[] characters = "I am Superman. ".toCharArray();
        SpaceEncoder.encodeSpace(characters);
    }
    
}
