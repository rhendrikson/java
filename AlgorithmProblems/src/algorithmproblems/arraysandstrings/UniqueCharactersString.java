/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings;

import java.util.Arrays;

public class UniqueCharactersString {
    
    public boolean areAllCharactersUnique(String string) {
        if (string.isEmpty()) return false;
        
        if (string.length() == 1) return true;
        
        char[] characters = string.toCharArray();
        Arrays.sort(characters);
        for (int i = 1; i < characters.length; i++) {
            if (characters[i] == characters[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
}
