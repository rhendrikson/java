/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmproblems.arraysandstrings;

public class SquareMatrixRotator {

    public void rotate90Degrees(int[][] matrix) {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                int temp = matrix[x][matrix.length - y - 1];
                matrix[y][matrix.length - 1 - x] = matrix[x][y];
                matrix[x][y] = 
                // horizontal: y constant, carry y to x
                // vertical: 
            }
        }
    }
    
}
