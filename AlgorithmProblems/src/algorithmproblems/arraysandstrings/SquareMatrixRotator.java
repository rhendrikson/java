/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmproblems.arraysandstrings;

public class SquareMatrixRotator {

    public void rotate90Degrees(int[][] matrix) {
        this.rotate90Degrees(matrix, 0, matrix.length - 1);
    }

    private void rotate90Degrees(int[][] matrix, int startIndex, int endIndex) {
        if (startIndex >= endIndex) return;
        
        for (int i = startIndex; i < endIndex; i++) {
            int temp = matrix[startIndex][i];
            matrix[startIndex][i] = matrix[endIndex - i + startIndex][startIndex];
            matrix[endIndex - i + startIndex][startIndex] = matrix[endIndex][endIndex - i + startIndex];
            matrix[endIndex][endIndex - i + startIndex] = matrix[i][endIndex];
            matrix[i][endIndex] = temp;
        }
        
        this.rotate90Degrees(matrix, ++startIndex, --endIndex);
    }
    
}
