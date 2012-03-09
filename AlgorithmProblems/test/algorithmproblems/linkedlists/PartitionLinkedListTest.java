/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PartitionLinkedListTest {

    @Test
    public void testPartition() {
        SinglyLinkedListNode<Integer> linkedList = new SinglyLinkedListNode<>(5, 2, 3, 1, 4);
        SinglyLinkedListNode<Integer> expected = new SinglyLinkedListNode<>(2, 1, 4, 3, 5);
        SinglyLinkedListNode<Integer> actual = PartitionLinkedList.partition(linkedList, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void testPartitionWithNonExistingElement() {
        SinglyLinkedListNode<Integer> linkedList = new SinglyLinkedListNode<>(6, 2, 5, 1, 4);
        SinglyLinkedListNode<Integer> expected = new SinglyLinkedListNode<>(2, 1, 4, 5, 6);
        SinglyLinkedListNode<Integer> actual = PartitionLinkedList.partition(linkedList, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void testPartitionWithLargestPivot() {
        SinglyLinkedListNode<Integer> linkedList = new SinglyLinkedListNode<>(5, 2, 3, 1, 4);
        SinglyLinkedListNode<Integer> expected = new SinglyLinkedListNode<>(2, 3, 1, 4, 5);
        SinglyLinkedListNode<Integer> actual = PartitionLinkedList.partition(linkedList, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void testPartitionWithSmallestPivot() {
        SinglyLinkedListNode<Integer> linkedList = new SinglyLinkedListNode<>(5, 2, 3, 1, 4);
        SinglyLinkedListNode<Integer> expected = new SinglyLinkedListNode<>(4, 1, 3, 2, 5);
        SinglyLinkedListNode<Integer> actual = PartitionLinkedList.partition(linkedList, 1);
        assertEquals(expected, actual);
    }

}