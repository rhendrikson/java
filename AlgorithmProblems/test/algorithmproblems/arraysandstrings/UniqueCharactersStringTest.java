/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class UniqueCharactersStringTest {

    @Test
    public void testUniqueCharacterString() {
        String string = "qkibycghre";
        assertTrue(new UniqueCharactersString().areAllCharactersUnique(string));
    }

    @Test
    public void testNonUniqueCharacterString() {
        String string = "qkibycighre";
        assertFalse(new UniqueCharactersString().areAllCharactersUnique(string));
    }

}