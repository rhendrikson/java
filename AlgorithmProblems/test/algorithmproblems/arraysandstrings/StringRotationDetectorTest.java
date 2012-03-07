/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmproblems.arraysandstrings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StringRotationDetectorTest {

    @Test
    public void testIsRotation() {
        String source = "waterbottle";
        String rotated = "erbottlewat";
        assertTrue(StringRotationDetector.isRotation(source, rotated));
    }

    @Test
    public void testIsRotationWithNonRotation() {
        String source = "waterbottle";
        String rotated = "arbottlewat";
        assertFalse(StringRotationDetector.isRotation(source, rotated));
    }

    @Test
    public void testIsSubstring() {
        String source = "waterbottle";
        String substring = "bottle";
        assertTrue(StringRotationDetector.isSubstring(source, substring));
    }

    @Test
    public void testIsSubstringWithFullString() {
        String source = "waterbottle";
        String substring = "waterbottle";
        assertTrue(StringRotationDetector.isSubstring(source, substring));
    }

    @Test
    public void testIsSubstringWithNonSubstring() {
        String source = "waterbottle";
        String substring = "abottle";
        assertFalse(StringRotationDetector.isSubstring(source, substring));
    }

    @Test
    public void testIsSubstringWithNullSubstring() {
        String source = "waterbottle";
        String substring = null;
        assertFalse(StringRotationDetector.isSubstring(source, substring));
    }

    @Test
    public void testIsSubstringWithEmptySubstring() {
        String source = "waterbottle";
        String substring = "";
        assertFalse(StringRotationDetector.isSubstring(source, substring));
    }

    @Test
    public void testIsSubstringWithLongerSubstring() {
        String source = "waterbottle";
        String substring = "waterbottles";
        assertFalse(StringRotationDetector.isSubstring(source, substring));
    }
}
