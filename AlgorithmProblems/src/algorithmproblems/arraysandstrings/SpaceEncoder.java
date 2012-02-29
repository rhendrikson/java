/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings;

public class SpaceEncoder {
    
    private final static char[] SPACE_ENCODED = "%20".toCharArray();
    
    public static void encodeSpace(char[] characters) {
        int numberOfSpaces = 0;
        for (int i = characters.length - 2; i >= 0; i--) {
            if (characters[i] == ' ' && 
                characters[i + 1] != ' ') numberOfSpaces++;
        }
        // from the end
        //     if character != ' '
        //          copy char from index - (num of spaces * 2) to char[index]
        //     else
        //          copy encoded space chars
        //          decrement num of spaces to copy by 1
        
        int numberOfSpacesCopied = 0;
        for (int i = characters.length - 1; i >= 0; i--) {
            int copyFromIndex = i - numberOfSpaces * 2;
            int copyToIndex = i - numberOfSpacesCopied * 2;
            if (characters[copyFromIndex] != ' ') {
                characters[copyToIndex] = characters[copyFromIndex];
            } else {
                System.arraycopy(SPACE_ENCODED, 0, characters, i - SPACE_ENCODED.length + 1, SPACE_ENCODED.length);
//                numberOfSpaces--;
                numberOfSpacesCopied++;
            }
        }
        
//        for (int i = 0; i < characters.length; i++) {
//            if (characters[i] == ' ') {
//                shiftRight(characters, i, SPACE_ENCODED.length);
//                System.arraycopy(SPACE_ENCODED, 0, characters, i, SPACE_ENCODED.length);
//            }
//        }
    }

    private static void shiftRight(char[] characters, int startIndex, int length) {
        for (int i = characters.length - 1; i > startIndex + length - 1; i--) {
            characters[i] = characters[i - length + 1];
        }
    }

}
