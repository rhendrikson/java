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
        
        for (int i = 0; i < string1.length(); i++) {
            for (int j = 0; j < string1.length(); j++) {                
                char[] string2 = new char[string1.length()];
                
                for (int k = 0; k < j; k++) {
                    int copyFromIndex = k;
                    if (k >= i) copyFromIndex++;
                    string2[k] = string1.charAt(copyFromIndex);
                }
                
                string2[j] = string1.charAt(i);
                
                for (int k = j + 1; k < string1.length(); k++) {
                    int copyFromIndex = k - 1;
                    if (k >= i) copyFromIndex++;
                    string2[k] = string1.charAt(copyFromIndex);
                }
                System.out.println(String.copyValueOf(string2));
            }
        }
        
        System.out.println("Okay");
        for (int i = 0; i < string1.length(); i++) {
            for (int j = i; j < string1.length(); j++) {
                StringBuilder sb = new StringBuilder();
                if (j >= i) {
                    sb.append(string1.substring(0, i));
                    sb.append(string1.substring(i + 1, j + 1));
                    sb.append(string1.charAt(i));
                    sb.append(string1.substring(j + 1, string1.length()));
                } else {
                    sb.append(string1.substring(0, j));
                    sb.append(string1.charAt(i));
                    sb.append(string1.substring(j + 1, i));
                    sb.append(string1.substring(i + 1, string1.length()));
                }
                System.out.println(sb.toString());
                assertTrue(StringPermutation.isPermutation(string1, sb.toString()));
            }
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
