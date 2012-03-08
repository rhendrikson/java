/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

public class KthLastElementOfLinkedList {
    
    public static <E extends Comparable> E findKthLastElement(SinglyLinkedListNode<E> head, int k) {
        if (k < 0) return null;
        
        SinglyLinkedListNode<E> current = head;
        SinglyLinkedListNode<E> runner = current;
        int currentIndex = 1;
        int length = 0;
        while (current != null) {
            if (runner == null) {
                if (k > length) {
                    return null;
                }
                
                if (currentIndex == length - k + 1) {
                    return current.data;
                }
            } else {
                if (runner.next != null) {
                    runner = runner.next.next;
                    length += 2;
                } else {
                    runner = runner.next;
                    length += 1;
                }
            }
            
            current = current.next;
            currentIndex++;
        }
        
        return null;
    }

}
