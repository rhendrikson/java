/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmproblems.sorting;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class QuickSortTest {

    @Test
    public void testSortingEmptyList() {
        List<Integer> data = Arrays.asList();
        new QuickSort().sort(data);
        Integer[] sortedData = new Integer[data.size()];
        data.toArray(sortedData);
        assertArrayEquals(new Integer[] {}, sortedData);
    }

    @Test
    public void testSortingOneElementList() {
        List<Integer> data = Arrays.asList(5);
        new QuickSort().sort(data);
        Integer[] sortedData = new Integer[data.size()];
        data.toArray(sortedData);
        assertArrayEquals(new Integer[] {5}, sortedData);
    }

    @Test
    public void testSortingTwoElementList() {
        List<Integer> data = Arrays.asList(5, 3);
        new QuickSort().sort(data);
        Integer[] sortedData = new Integer[data.size()];
        data.toArray(sortedData);
        assertArrayEquals(new Integer[] {3, 5}, sortedData);
    }

    @Test
    public void testSortingThreeElementList() {
        List<Integer> data = Arrays.asList(5, 3, 4);
        new QuickSort().sort(data);
        Integer[] sortedData = new Integer[data.size()];
        data.toArray(sortedData);
        assertArrayEquals(new Integer[] {3, 4, 5}, sortedData);
    }

    @Test
    public void testSortingFourElementList() {
        List<Integer> data = Arrays.asList(5, 1, 3, 4);
        new QuickSort().sort(data);
        Integer[] sortedData = new Integer[data.size()];
        data.toArray(sortedData);
        assertArrayEquals(new Integer[] {1, 3, 4, 5}, sortedData);
    }

    @Test
    public void testSortingDuplicateElementList() {
        List<Integer> data = Arrays.asList(5, 2, 1, 3, 1, 4, 5);
        new QuickSort().sort(data);
        Integer[] sortedData = new Integer[data.size()];
        data.toArray(sortedData);
        assertArrayEquals(new Integer[] {1, 1, 2, 3, 4, 5, 5}, sortedData);
    }

    @Test
    public void testSortingIntegers() {
        List<Integer> data = Arrays.asList(5, 4, 2, 1, 3, 7, 9, 10, 6, 8);
        new QuickSort().sort(data);
        Integer[] sortedData = new Integer[data.size()];
        data.toArray(sortedData);
        assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, sortedData);
    }
    
    @Test
    public void testSortingCharacters() {
        List<Character> data = Arrays.asList('c', 'h', 'e', 'b', 'g', 'i', 'd', 'a', 'f');
        new QuickSort().sort(data);
        Character[] sortedData = new Character[data.size()];
        data.toArray(sortedData);
        assertArrayEquals(new Character[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'}, sortedData);
    }
}
