/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings;

import algorithmproblems.arraysandstrings.UniqueCharacterStrategy.BitFlagUniqueCharacterStrategy;
import algorithmproblems.arraysandstrings.UniqueCharacterStrategy.CharacterFlagUniqueCharacterStrategy;
import algorithmproblems.arraysandstrings.UniqueCharacterStrategy.SortUniqueCharacterStrategy;
import algorithmproblems.arraysandstrings.UniqueCharacterStrategy.UniqueCharacterStrategy;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class UniqueCharactersStringTest {

    @Parameters
    public static List<Object[]> strategies() {
        return Arrays.asList(new Object[][]
        {
            { new CharacterFlagUniqueCharacterStrategy() },
            { new SortUniqueCharacterStrategy() },
            { new BitFlagUniqueCharacterStrategy() }
        });
    }
    
    private UniqueCharactersString uniqueCharactersString;
    
    public UniqueCharactersStringTest(UniqueCharacterStrategy strategy) {
        uniqueCharactersString = new UniqueCharactersString();
        uniqueCharactersString.setStrategy(strategy);
    }

    @Test
    public void testEmptyString() {
        String string = "";
        assertFalse(uniqueCharactersString.areAllCharactersUnique(string));
    }

    @Test
    public void testSingleCharacterString() {
        String string = "a";
        assertTrue(uniqueCharactersString.areAllCharactersUnique(string));
    }

    @Test
    public void testUniqueCharacterString() {
        String string = "qkibycghre";
        assertTrue(uniqueCharactersString.areAllCharactersUnique(string));
    }

    @Test
    public void testNonUniqueCharacterString() {
        String string = "qkibycighre";
        assertFalse(uniqueCharactersString.areAllCharactersUnique(string));
    }

}