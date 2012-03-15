/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

import algorithmproblems.linkedlists.SumOfLinkedListsStrategy.IterativeSumOfLinkedListsStrategy;
import algorithmproblems.linkedlists.SumOfLinkedListsStrategy.RecursiveSumOfLinkedListsStrategy;
import algorithmproblems.linkedlists.SumOfLinkedListsStrategy.SumOfLinkedListsStrategy;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SumOfLinkedListsTest {

    @Parameterized.Parameters
    public static List<Object[]> strategies() {
        return Arrays.asList(new Object[][]
        {
            { new IterativeSumOfLinkedListsStrategy() },
            { new RecursiveSumOfLinkedListsStrategy() }
        });
    }
    
    private SumOfLinkedLists sumOfLinkedLists;
    
    public SumOfLinkedListsTest(SumOfLinkedListsStrategy strategy) {
        sumOfLinkedLists = new SumOfLinkedLists();
        sumOfLinkedLists.setStrategy(strategy);
    }
    
    @Test
    public void testCalculateSumBackward() {
        SinglyLinkedListNode<Integer> linkedList1 = new SinglyLinkedListNode<>(7, 1, 6);
        SinglyLinkedListNode<Integer> linkedList2 = new SinglyLinkedListNode<>(5, 9, 2);
        SinglyLinkedListNode<Integer> expected = new SinglyLinkedListNode<>(2, 1, 9);
        assertEquals(expected, sumOfLinkedLists.calculateSumBackward(linkedList1, linkedList2));
    }

    @Test
    public void testCalculateSumForward() {
        SinglyLinkedListNode<Integer> linkedList1 = new SinglyLinkedListNode<>(6, 1, 7);
        SinglyLinkedListNode<Integer> linkedList2 = new SinglyLinkedListNode<>(2, 9, 5);
        SinglyLinkedListNode<Integer> expected = new SinglyLinkedListNode<>(9, 1, 2);
        assertEquals(expected, sumOfLinkedLists.calculateSumForward(linkedList1, linkedList2));
    }
    
    @Test
    public void testCalculateSumBackwardWithDifferentLengths() {
        SinglyLinkedListNode<Integer> linkedList1 = new SinglyLinkedListNode<>(7, 1, 6);
        SinglyLinkedListNode<Integer> linkedList2 = new SinglyLinkedListNode<>(5, 9);
        SinglyLinkedListNode<Integer> expected = new SinglyLinkedListNode<>(2, 1, 7);
        assertEquals(expected, sumOfLinkedLists.calculateSumBackward(linkedList1, linkedList2));
    }

    @Test
    public void testCalculateSumForwardWithDifferentLengths() {
        SinglyLinkedListNode<Integer> linkedList1 = new SinglyLinkedListNode<>(6, 1, 7);
        SinglyLinkedListNode<Integer> linkedList2 = new SinglyLinkedListNode<>(9, 5);
        SinglyLinkedListNode<Integer> expected = new SinglyLinkedListNode<>(7, 1, 2);
        assertEquals(expected, sumOfLinkedLists.calculateSumForward(linkedList1, linkedList2));
    }

}