/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmproblems.arraysandstrings;

import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class SquareMatrixRotatorTest {

    @Test
    public void testRotate90DegreesWith0x0Matrix() {
        int[][] matrix =
        {
            {}
        };
        int[][] expected =
        {
            {}
        };
        
        new SquareMatrixRotator().rotate90Degrees(matrix);
        System.out.println(Arrays.deepToString(matrix));
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testRotate90DegreesWith1x1Matrix() {
        int[][] matrix =
        {
            {0}
        };
        int[][] expected =
        {
            {0}
        };
        
        new SquareMatrixRotator().rotate90Degrees(matrix);
        System.out.println(Arrays.deepToString(matrix));
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testRotate90DegreesWith2x2Matrix() {
        int[][] matrix =
        {
            {0, 1},
            {2, 3}
        };
        int[][] expected =
        {
            {2, 0},
            {3, 1}
        };
        
        new SquareMatrixRotator().rotate90Degrees(matrix);
        System.out.println(Arrays.deepToString(matrix));
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testRotate90DegreesWith4x4Matrix() {
        int[][] matrix =
        {
            {0, 1, 2, 3},
            {4, 5, 6, 7},
            {8, 9, 10, 11},
            {12, 13, 14, 15}
        };
        int[][] expected =
        {
            {12, 8, 4, 0},
            {13, 9, 5, 1},
            {14, 10, 6, 2},
            {15, 11, 7, 3}
        };
        
        new SquareMatrixRotator().rotate90Degrees(matrix);
        System.out.println(Arrays.deepToString(matrix));
        assertArrayEquals(expected, matrix);
    }

    @Test
    public void testRotate90DegreesWith5x5Matrix() {
        int[][] matrix =
        {
            {0, 1, 2, 3, 4},
            {5, 6, 7, 8, 9},
            {10, 11, 12, 13, 14},
            {15, 16, 17, 18, 19},
            {20, 21, 22, 23, 24}
        };
        int[][] expected =
        {
            {20, 15, 10, 5, 0},
            {21, 16, 11, 6, 1},
            {22, 17, 12, 7, 2},
            {23, 18, 13, 8, 3},
            {24, 19, 14, 9, 4}
        };
        
        new SquareMatrixRotator().rotate90Degrees(matrix);
        System.out.println(Arrays.deepToString(matrix));
        assertArrayEquals(expected, matrix);
    }
    
}
