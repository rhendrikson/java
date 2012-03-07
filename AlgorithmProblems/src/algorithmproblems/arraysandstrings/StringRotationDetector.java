/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings;

public class StringRotationDetector {
    
    public static boolean isRotation(String source, String rotated) {
        if (source == null || rotated == null) return false;
        if (source.isEmpty() || rotated.isEmpty()) return false;
        if (source.length() != rotated.length()) return false;
        
        return StringRotationDetector.isSubstring(source + source, rotated);
    }

    public static boolean isSubstring(String source, String substring) {
        if (source == null || substring == null) return false;
        if (source.isEmpty() || substring.isEmpty()) return false;
        if (source.length() < substring.length()) return false;        
        
        for (int sourceIndex = 0, substringIndex = 0; sourceIndex < source.length(); sourceIndex++) {
            if (source.charAt(sourceIndex) == substring.charAt(substringIndex)) {
                if (substringIndex == substring.length() - 1) {
                    return true;
                }
                substringIndex++;
            } else {
                if (substringIndex > 0) {
                    return false;
                }
            }
        }
        
        return false;
    }
    
}
