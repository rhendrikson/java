/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings.UniqueCharacterStrategy;

public class BitFlagUniqueCharacterStrategy implements UniqueCharacterStrategy {

    @Override
    public boolean areCharactersUnique(String string) {
        char bitFlag = Character.MIN_VALUE;
        for (int i = 0; i < string.length(); i++) {
            int value = string.charAt(i);
            if ((bitFlag & (1 << value)) > Character.MIN_VALUE) {
                return false;
            }
            bitFlag |= (1 << value);
        }
        return true;
    }

}
