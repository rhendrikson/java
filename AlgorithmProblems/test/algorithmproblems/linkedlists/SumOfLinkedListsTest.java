/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SumOfLinkedListsTest {

    @Test
    public void testCalculateSumBackward() {
        SinglyLinkedListNode<Integer> linkedList1 = new SinglyLinkedListNode<>(7, 1, 6);
        SinglyLinkedListNode<Integer> linkedList2 = new SinglyLinkedListNode<>(5, 9, 2);
        SinglyLinkedListNode<Integer> expected = new SinglyLinkedListNode<>(2, 1, 9);
        assertEquals(expected, SumOfLinkedLists.calculateSumBackward(linkedList1, linkedList2));
    }

    @Test
    public void testCalculateSumForward() {
        SinglyLinkedListNode<Integer> linkedList1 = new SinglyLinkedListNode<>(6, 1, 7);
        SinglyLinkedListNode<Integer> linkedList2 = new SinglyLinkedListNode<>(2, 9, 5);
        SinglyLinkedListNode<Integer> expected = new SinglyLinkedListNode<>(9, 1, 2);
        assertEquals(expected, SumOfLinkedLists.calculateSumForward(linkedList1, linkedList2));
    }

}