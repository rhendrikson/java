/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmproblems.arraysandstrings;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringHelperTest {
    
    @Test
    public void testReverseNullString() {
        assertEquals(null, StringHelper.reverse(null));
    }
    
    @Test
    public void testReverseEmptyString() {
        assertEquals("", StringHelper.reverse(""));
    }
    
    @Test
    public void testReverseOneCharacterString() {
        assertEquals("a", StringHelper.reverse("a"));
    }
    
    @Test
    public void testReverseString() {
        assertEquals("dlroW olleH", StringHelper.reverse("Hello World"));
    }
    
    @Test
    public void testSortString() {
        assertEquals("abcde", StringHelper.sort("cabed"));
    }
    
}
