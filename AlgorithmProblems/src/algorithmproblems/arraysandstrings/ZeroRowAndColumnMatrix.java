/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.arraysandstrings;

import java.util.ArrayList;

public class ZeroRowAndColumnMatrix {

    public static void zeroRowAndColumn(int[][] matrix) {
        ArrayList<Integer> zeroRows = new ArrayList<>();
        ArrayList<Integer> zeroColumns = new ArrayList<>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (!zeroRows.contains(i)) zeroRows.add(i);
                    if (!zeroColumns.contains(j)) zeroColumns.add(j);
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (zeroRows.contains(i) || zeroColumns.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
}
