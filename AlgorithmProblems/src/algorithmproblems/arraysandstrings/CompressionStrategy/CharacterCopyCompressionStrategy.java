/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings.CompressionStrategy;

public class CharacterCopyCompressionStrategy implements CompressionStrategy {

    @Override
    public String compress(String source) {
        if (source.length() < 2) return source;
        
        int compressedLength = countCompressedLength(source);
        if (compressedLength > source.length()) return source;
        
        char previous = '\0';
        int previousCount = 0;
        int currentIndex = 0;
        char[] compressed = new char[compressedLength];
        for (int i = 0; i < source.length(); i++) {
            char current = source.charAt(i);
            if (current != previous) {
                if (previousCount > 0) {
                    currentIndex = copyDigitsToCharacterArray(previousCount, compressed, currentIndex);
                }
                compressed[currentIndex++] = current;
                previous = current;
                previousCount = 0;
            }
            
            previousCount++;
        }
        copyDigitsToCharacterArray(previousCount, compressed, currentIndex);
        return String.valueOf(compressed);
    }

    private int copyDigitsToCharacterArray(int previousCount, char[] compressed, int currentIndex) {
        char[] previousCountCharacters = String.valueOf(previousCount).toCharArray();
        System.arraycopy(previousCountCharacters, 0, compressed, currentIndex, previousCountCharacters.length);
        currentIndex += previousCountCharacters.length;
        return currentIndex;
    }

    private int countCompressedLength(String source) {
        char previous = '\0';
        int previousCount = 0;
        int compressedLength = 0;
        for (int i = 0; i < source.length(); i++) {
            char current = source.charAt(i);
            if (current != previous) {
//                if (previousCount > 0) compressedLength += String.valueOf(previousCount).toCharArray().length;
                if (previousCount > 0) compressedLength += countDigits(previousCount);
                compressedLength++;
                previous = current;
                previousCount = 0;
            }
            
            previousCount++;
        }
        
        compressedLength += countDigits(previousCount);
        return compressedLength;
    }
    
    private int countDigits(int number) {
        return (int) Math.log10((double) number) + 1;
    }

}
