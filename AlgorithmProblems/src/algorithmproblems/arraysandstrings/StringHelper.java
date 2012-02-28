/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings;

import java.util.Arrays;

public class StringHelper {
    
    public static String reverse(String string) {
        if (string == null || string.isEmpty()) return string;
        
        if (string.length() == 1) return string;
        
        char[] characters = string.toCharArray();
        for (int start = 0, end = string.length() - 1; start < end; start++, end--) {
            char temp = string.charAt(start);
            characters[start] = characters[end];
            characters[end] = temp;
        }
        
        return String.copyValueOf(characters);
    }
    
    public static String sort(String string) {
        char[] characters = string.toCharArray();
        Arrays.sort(characters);
        return String.copyValueOf(characters);
    }
    
}
