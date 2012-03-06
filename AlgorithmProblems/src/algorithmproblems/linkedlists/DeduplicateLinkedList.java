/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

import java.util.HashMap;

public class DeduplicateLinkedList {
    
    public static <E extends Comparable> void deduplicate(SinglyLinkedListNode<E> head) {
        HashMap<E, Integer> nodeCounts = new HashMap<>();
        SinglyLinkedListNode<E> current = head;
        SinglyLinkedListNode<E> previous = current;
        while (current != null) {
            if (nodeCounts.get(current.data) != null &&
                nodeCounts.get(current.data).compareTo(1) == 0) {
                previous.next = current.next;
            } else {
                nodeCounts.put(current.data, 1);
                previous = current;
            }
            current = current.next;
        }
    }
    
    public static <E extends Comparable> boolean hasDuplicate(SinglyLinkedListNode<E> head) {
        return false;
    }

}
