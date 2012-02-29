/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings.CompressionStrategy;

public class StringBuilderCompressionStrategy implements CompressionStrategy {

    @Override
    public String compress(String source) {
        if (source.length() < 2) return source;
        
        char previous = '\0';
        int previousCount = 0;
        StringBuilder compressedBuilder = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char current = source.charAt(i);
            if (current != previous) {
                if (previousCount > 0) compressedBuilder.append(previousCount);
                compressedBuilder.append(current);
                previous = current;
                previousCount = 0;
            }
            
            previousCount++;
        }
        compressedBuilder.append(previousCount);
        
        String compressed = compressedBuilder.toString();
        if (compressed.length() < source.length()) return compressed;
        
        return source;
    }

}
