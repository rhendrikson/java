/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmproblems.arraysandstrings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StringPermutationTest {
    
    @Test
    public void testEmptyString() {
        String string1 = "abc";
        String string2 = "";
        assertFalse(StringPermutation.isPermutation(string1, string2));
    }
    
    @Test
    public void testValidStringPermutations() {
        String string1 = "abc";
       
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string1.length(); i++) {
            sb.append(string1.substring(0, i));
            sb.append(string1.charAt(i));
            sb.append(string1.substring(i + 1, string1.length() - 1));
            assertTrue(StringPermutation.isPermutation(string1, sb.toString()));
        }
    }
    
    @Test
    public void testInvalidStringPermutation() {
        String string1 = "abc";
        String string2 = "def";
        assertFalse(StringPermutation.isPermutation(string1, string2));
    }
    
    @Test
    public void testDifferingLengthsStringPermutation() {
        String string1 = "abc";
        String string2 = "cbaghi";
        assertFalse(StringPermutation.isPermutation(string1, string2));
    }
}
