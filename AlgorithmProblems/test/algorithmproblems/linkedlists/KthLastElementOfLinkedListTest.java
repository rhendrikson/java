/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class KthLastElementOfLinkedListTest {

    @Test
    public void testFindSecondLastElement() {
        SinglyLinkedListNode<Integer> linkedList = new SinglyLinkedListNode<>(1, 2, 3, 4, 5);
        assertEquals(Integer.valueOf(4), KthLastElementOfLinkedList.findKthLastElement(linkedList, 2));
    }

    @Test
    public void testFindKthLastElementWithKExceedingLength() {
        SinglyLinkedListNode<Integer> linkedList = new SinglyLinkedListNode<>(1, 2, 3, 4, 5);
        assertNull(KthLastElementOfLinkedList.findKthLastElement(linkedList, 6));
    }

    @Test
    public void testFindKthLastElementWithNegativeK() {
        SinglyLinkedListNode<Integer> linkedList = new SinglyLinkedListNode<>(1, 2, 3, 4, 5);
        assertNull(KthLastElementOfLinkedList.findKthLastElement(linkedList, -1));
    }

}