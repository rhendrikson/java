/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings;

import algorithmproblems.arraysandstrings.CompressionStrategy.CompressionStrategy;
import algorithmproblems.arraysandstrings.CompressionStrategy.StringBuilderCompressionStrategy;

public class StringCompressor {
    
    private CompressionStrategy strategy;
    
    public StringCompressor() {
        this.strategy = new StringBuilderCompressionStrategy();
    }
    
    public void setStrategy(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public String compress(String source) {
        return strategy.compress(source);
    }
    
}
