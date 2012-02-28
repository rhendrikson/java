/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings;

import algorithmproblems.arraysandstrings.PermutationCheckStrategy.CharacterCountPermutationCheckStrategy;
import algorithmproblems.arraysandstrings.PermutationCheckStrategy.PermutationCheckStrategy;
import java.util.ArrayList;

public class StringPermutation {
    
    private PermutationCheckStrategy strategy;
    
    public StringPermutation() {
        this.strategy = new CharacterCountPermutationCheckStrategy();
    }

    public boolean isPermutation(String source, String permutation) {
        return this.strategy.isPermutation(source, permutation);
    }
    
    public void setStrategy(PermutationCheckStrategy strategy) {
        this.strategy = strategy;
    }
    
    public static String[] getPermutations(String string) {
        if (string == null || string.isEmpty()) return new String[0];
        
        if (string.length() == 1) {
            return new String[] { string };
        }
             
        if (string.length() <= 2) {
            return new String[]
            {
                string,
                StringHelper.reverse(string)
            };
        }
        
        if (string.length() > 7) {
            throw new IllegalArgumentException();
        }
        
        char firstCharacter = string.charAt(0);
        String remainingString = string.substring(1);
        ArrayList<String> permutations = new ArrayList<>();
        String[] subpermutations;
        if (remainingString.length() == 2) {
            subpermutations = getPermutations(remainingString);
        } else {
            subpermutations = ArrayHelper.concat(getPermutations(remainingString), getPermutations(StringHelper.reverse(remainingString)));
        }
        for (String subpermutation : subpermutations) {
            for (int j = 0; j < string.length(); j++) {
                StringBuilder permutationBuilder = new StringBuilder();
                permutationBuilder.append(subpermutation.substring(0, j));
                permutationBuilder.append(firstCharacter);
                permutationBuilder.append(subpermutation.substring(j, subpermutation.length()));
                String permutation = permutationBuilder.toString();
                if (!permutations.contains(permutation)) {
                    permutations.add(permutation);
                }
            }
        }
        return permutations.toArray(new String[0]);
    }
    
}
