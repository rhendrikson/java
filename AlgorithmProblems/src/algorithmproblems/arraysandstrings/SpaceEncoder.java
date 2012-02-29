/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings;

public class SpaceEncoder {
    
    private final static char[] SPACE_ENCODED = "%20".toCharArray();
    
    public static void encodeSpace(char[] characters) {
        int spaces = 0;
        int endIndex = characters.length;
        for (int i = 0; i < characters.length - 1; i++) {
            if (characters[i] == ' ' && 
                characters[i + 1] == ' ') {
                endIndex = i - 1;
                break;
            }
            
            if (characters[i] == ' ') spaces++;
        }
        
        int spacesReplaced = 0;
        int extension = spaces * 2;
        int encodedLength = endIndex + extension + 1;
        if (encodedLength > characters.length) {
            throw new IllegalArgumentException(String.format("Inadequate length to accommodate encoded spaces. %1 characters required.", encodedLength));
        }
        
        for (int i = endIndex + extension; i >= extension; i--) {
            int copyFromIndex = i - extension;
            int copyToIndex = i - spacesReplaced * 2;
            if (characters[copyFromIndex] != ' ') {
                characters[copyToIndex] = characters[copyFromIndex];
            } else {
                System.arraycopy(SPACE_ENCODED, 0, characters, copyToIndex - SPACE_ENCODED.length + 1, SPACE_ENCODED.length);
                spacesReplaced++;
            }
        }
    }

}