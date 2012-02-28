/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings.PermutationCheckStrategy;

import algorithmproblems.arraysandstrings.StringHelper;

public class SortPermutationCheckStrategy implements PermutationCheckStrategy {

    @Override
    public boolean isPermutation(String source, String permutation) {
        if (source == null || permutation == null) return false;
        
        if (source.isEmpty() || permutation.isEmpty()) return false;
        
        if (source.length() != permutation.length()) return false;
        
        if (source.length() == 1) {
            return source.equals(permutation);
        }
        
        return StringHelper.sort(source).equals(StringHelper.sort(permutation));
    }

}
