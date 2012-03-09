/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

import static org.junit.Assert.*;
import org.junit.Test;

public class SinglyLinkedListNodeTest {

    @Test
    public void testAppend() {
        SinglyLinkedListNode<Integer> linkedList = new SinglyLinkedListNode<>(1, null);
        linkedList.append(2);
        assertEquals(2, linkedList.length());
    }
    
    @Test
    public void testIterator() {
        SinglyLinkedListNode<Integer> linkedList = new SinglyLinkedListNode<>(1, 2, 3, 4, 5);
        int[] actual = new int[linkedList.length()];
        int i = 0;
        for (SinglyLinkedListNode<Integer> node : linkedList) {
            actual[i++] = node.data;
        }
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testEquals() {
        SinglyLinkedListNode<Integer> linkedList1 = new SinglyLinkedListNode<>(1, 2, 3, 4, 5);
        SinglyLinkedListNode<Integer> linkedList2 = new SinglyLinkedListNode<>(1, 2, 3, 4, 5);
        assertEquals(linkedList2, linkedList1);
    }
    
    @Test
    public void testNotEquals() {
        SinglyLinkedListNode<Integer> linkedList1 = new SinglyLinkedListNode<>(1, 2, 3, 4, 5);
        SinglyLinkedListNode<Integer> linkedList2 = new SinglyLinkedListNode<>(5, 4, 3, 2, 1);
        assertFalse(linkedList2.equals(linkedList1));
    }

}