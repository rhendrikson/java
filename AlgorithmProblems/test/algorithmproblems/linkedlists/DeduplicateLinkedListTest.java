/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class DeduplicateLinkedListTest {

    @Test
    public void testDeduplicate() {
        SinglyLinkedListNode<Character> linkedList = new SinglyLinkedListNode<>('F', 'O', 'L', 'L', 'O', 'W', ' ', 'U', 'P');
        DeduplicateLinkedList.deduplicate(linkedList);
        
        char[] actual = new char[linkedList.length()];
        int i = 0;
        for (SinglyLinkedListNode<Character> node : linkedList) {
            actual[i++] = node.data;
        }
        char[] expected = {'F', 'O', 'L', 'W', ' ', 'U', 'P'};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHasDuplicate() {
    }

}