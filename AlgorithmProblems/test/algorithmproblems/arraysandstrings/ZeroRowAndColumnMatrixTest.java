/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmproblems.arraysandstrings;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class ZeroRowAndColumnMatrixTest {

    @Test
    public void testZeroRowAndColumnWith1x1MatrixAndNoZeros() {
        int[][] matrix = 
        {
            {1}
        };
        int[][] expected =
        {
            {1}
        };
        ZeroRowAndColumnMatrix.zeroRowAndColumn(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testZeroRowAndColumnWith2x2Matrix() {
        int[][] matrix = 
        {
            {1, 2},
            {3, 0}
        };
        int[][] expected =
        {
            {1, 0},
            {0, 0}
        };
        ZeroRowAndColumnMatrix.zeroRowAndColumn(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testZeroRowAndColumnWith3x2Matrix() {
        int[][] matrix = 
        {
            {1, 2},
            {3, 0},
            {6, 7}
        };
        int[][] expected =
        {
            {1, 0},
            {0, 0},
            {6, 0}
        };
        ZeroRowAndColumnMatrix.zeroRowAndColumn(matrix);
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testZeroRowAndColumnWith4x5MatrixAndMultipleZeros() {
        int[][] matrix = 
        {
            {1, 2, 3, 4, 0},
            {6, 7, 0, 9, 0},
            {0, 12, 13, 14, 15},
            {16, 17, 18, 19, 20}
        };
        int[][] expected =
        {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 17, 0, 19, 0}
        };
        ZeroRowAndColumnMatrix.zeroRowAndColumn(matrix);
        assertArrayEquals(expected, matrix);
    }
    
}
