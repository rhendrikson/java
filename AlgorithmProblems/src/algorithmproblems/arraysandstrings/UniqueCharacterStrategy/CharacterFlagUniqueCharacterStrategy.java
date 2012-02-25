/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings.UniqueCharacterStrategy;

import algorithmproblems.arraysandstrings.UniqueCharactersString;

public class CharacterFlagUniqueCharacterStrategy implements UniqueCharacterStrategy {
    
    @Override
    public boolean areCharactersUnique(String string) {
        boolean[] characterFlags = new boolean[UniqueCharactersString.ASCII_CHARACTER_COUNT];
        for (int i = 0; i < string.length(); i++) {
            int characterAscii = string.charAt(i);
            if (characterFlags[characterAscii]) return false;
            characterFlags[characterAscii] = true;
        }
        return true;
    }

}
