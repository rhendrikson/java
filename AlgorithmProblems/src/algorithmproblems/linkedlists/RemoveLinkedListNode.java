/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

public class RemoveLinkedListNode {
    
    public static <E extends Comparable> void remove(SinglyLinkedListNode<E> target) {
        if (target == null || target.next == null) {
            throw new UnsupportedOperationException();
        }        
        
        target.data = (E) target.next.data;
        target.next = target.next.next;
    }

}
