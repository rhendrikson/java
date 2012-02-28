/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings;

public class SpaceEncoder {
    
    private final static char[] SPACE_ENCODED = "%20".toCharArray();
    
    public static void encodeSpace(char[] characters) {
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == ' ') {
                shiftRight(characters, i, SPACE_ENCODED.length);
                System.arraycopy(SPACE_ENCODED, 0, characters, i, SPACE_ENCODED.length);
            }
        }
    }

    private static void shiftRight(char[] characters, int startIndex, int length) {
        for (int i = characters.length - 1; i > startIndex + length - 1; i--) {
            characters[i] = characters[i - length + 1];
        }
    }

}
