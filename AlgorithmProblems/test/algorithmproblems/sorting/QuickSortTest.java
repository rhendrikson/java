/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmproblems.sorting;

import java.util.Arrays;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

public class QuickSortTest {
    
    public QuickSortTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
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
        List<Character> data = Arrays.asList('c', 'e', 'b', 'd', 'a');
        new QuickSort().sort(data);
        Character[] sortedData = new Character[data.size()];
        data.toArray(sortedData);
        assertArrayEquals(new Character[] {'a', 'b', 'c', 'd', 'e'}, sortedData);
    }
}
