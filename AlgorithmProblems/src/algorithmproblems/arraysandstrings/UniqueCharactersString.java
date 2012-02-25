/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings;

import algorithmproblems.arraysandstrings.UniqueCharacterStrategy.CharacterFlagUniqueCharacterStrategy;
import algorithmproblems.arraysandstrings.UniqueCharacterStrategy.UniqueCharacterStrategy;

public class UniqueCharactersString {
    
    public static final int ASCII_CHARACTER_COUNT = 256;
    private UniqueCharacterStrategy strategy = new CharacterFlagUniqueCharacterStrategy();
        
    public boolean areAllCharactersUnique(String string) {
        if (string.isEmpty()) return false;
        
        if (string.length() == 1) return true;
        
        if (string.length() > ASCII_CHARACTER_COUNT) return false;

        return this.strategy.areCharactersUnique(string);
    }
    
    public void setStrategy(UniqueCharacterStrategy strategy) {
        this.strategy = strategy;
    }
    
}
