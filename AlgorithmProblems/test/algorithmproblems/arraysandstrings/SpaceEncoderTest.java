/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmproblems.arraysandstrings;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class SpaceEncoderTest {

    @Test
    public void testEncodeSpace() {
        char[] characters = "I am Superman.    ".toCharArray();
        char[] expected = "I%20am%20Superman.".toCharArray();
        SpaceEncoder.encodeSpace(characters);
        assertArrayEquals(expected, characters);
    }
    
}
