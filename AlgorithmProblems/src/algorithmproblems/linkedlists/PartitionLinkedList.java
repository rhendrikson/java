/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

public class PartitionLinkedList {

    public static <E extends Comparable> SinglyLinkedListNode<E> partition(SinglyLinkedListNode<E> head, E pivot) {
        if (head == null) return head;
        if (head.next == null) return head;        

        SinglyLinkedListNode<E> current = head;
        SinglyLinkedListNode<E> leftHead = null;
        SinglyLinkedListNode<E> leftTail = null;
        SinglyLinkedListNode<E> rightHead = null;
        while (current != null) {
            SinglyLinkedListNode<E> nextNode = current.next;
            current.next = null;
            if (current.data.compareTo(pivot) < 0) {
                if (leftHead == null) {
                    leftHead = current;
                }
                if (leftTail != null) {
                    leftTail.next = current;
                }
                leftTail = current;
            } else {
                if (rightHead != null) {
                    current.next = rightHead;
                }
                rightHead = current;
            }
            current = nextNode;
        }
        
        if (leftHead == null) return rightHead;
        
        leftTail.next = rightHead;
        return leftHead;
    }
    
}
