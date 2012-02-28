/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmproblems.arraysandstrings;

import algorithmproblems.arraysandstrings.PermutationCheckStrategy.CharacterCountPermutationCheckStrategy;
import algorithmproblems.arraysandstrings.PermutationCheckStrategy.PermutationCheckStrategy;
import algorithmproblems.arraysandstrings.PermutationCheckStrategy.SortPermutationCheckStrategy;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class StringPermutationTest {

    @Parameterized.Parameters
    public static List<Object[]> strategies() {
        return Arrays.asList(new Object[][]
        {
            { new CharacterCountPermutationCheckStrategy() },
            { new SortPermutationCheckStrategy() }
        });
    }
    
    private StringPermutation stringPermutation;
    
    public StringPermutationTest(PermutationCheckStrategy strategy) {
        stringPermutation = new StringPermutation();
        stringPermutation.setStrategy(strategy);
    }

    @Test
    public void testIsNullStringPermutation() {
        String string1 = "abc";
        String string2 = null;
        assertFalse(stringPermutation.isPermutation(string1, string2));
    }

    @Test
    public void testIsEmptyStringPermutation() {
        String string1 = "abc";
        String string2 = "";
        assertFalse(stringPermutation.isPermutation(string1, string2));
    }
    
    @Test
    public void testGetPermutations() {
        String[] expected = 
        {
            "abcd",
            "bacd",
            "bcad",
            "bcda",
            "acbd",
            "cabd",
            "cbad",
            "cbda",
            "acdb",
            "cadb",
            "cdab",
            "cdba",
            "abdc",
            "badc",
            "bdac",
            "bdca",
            "adbc",
            "dabc",
            "dbac",
            "dbca",
            "adcb",
            "dacb",
            "dcab",
            "dcba"
        };
        assertArrayEquals(expected, StringPermutation.getPermutations("abcd"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPermutationsExceedingLimit() {
        StringPermutation.getPermutations("abcdefghijk");
    }

    @Test
    public void testGetPermutationsForNullString() {
        assertArrayEquals(new String[0], StringPermutation.getPermutations(null));
    }

    @Test
    public void testValidStringPermutations() {
        String source = "abcdefg";
        for (String permutation : StringPermutation.getPermutations(source)) {
            assertTrue(stringPermutation.isPermutation(source, permutation));
        }
    }

    @Test
    public void testInvalidStringPermutation() {
        String string1 = "abc";
        String string2 = "def";
        assertFalse(stringPermutation.isPermutation(string1, string2));
    }

    @Test
    public void testDifferingLengthsStringPermutation() {
        String string1 = "abc";
        String string2 = "cbaghi";
        assertFalse(stringPermutation.isPermutation(string1, string2));
    }
}
