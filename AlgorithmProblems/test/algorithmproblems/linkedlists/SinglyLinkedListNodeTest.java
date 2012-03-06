/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

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

}