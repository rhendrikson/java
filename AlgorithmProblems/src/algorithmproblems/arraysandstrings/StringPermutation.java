/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;

public class StringPermutation {

    public static boolean isPermutation(String string1, String string2) {
        if (string1.isEmpty() || string2.isEmpty()) return false;
        
        if (string1.length() != string2.length()) return false;
        
        HashMap<Character, Integer> characterCounts = new HashMap<>(string1.length());
        for (Character character : string1.toCharArray()) {
            int count = characterCounts.get(character) == null ? 0 : characterCounts.get(character);
            characterCounts.put(character, ++count);
        }
        
        for (Character character : string2.toCharArray()) {
            int count = characterCounts.get(character) == null ? 0 : characterCounts.get(character);
            characterCounts.put(character, --count);
            if (count < 0) return false;
        }
        
        return true;
    }
    
    public static String[] getPermutations(String string) {
        if (string.isEmpty()) return new String[0];
        
        if (string.length() == 1) {
            return new String[] { string };
        }
        
        if (string.length() == 2) {
            return new String[]
            {
                string,
                String.copyValueOf(new char[] { string.charAt(1), string.charAt(0) } )
            };
        }
        
        return concat(getPermutations(string), getPermutations(string));
    }
    
    public static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}
