/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists.DeduplicateLinkedListStrategy;

import algorithmproblems.linkedlists.SinglyLinkedListNode;

public class DeduplicateLinkedListWithRunnerStrategy implements DeduplicateLinkedListStrategy {

    @Override
    public <E extends Comparable> void deduplicate(SinglyLinkedListNode<E> head) {
        if (head == null) return;
        
        SinglyLinkedListNode<E> current = head;
        SinglyLinkedListNode<E> runner;        
        while (current != null) {
            runner = current;
            while (runner.next != null) {
                if (runner.next.data.compareTo(current.data) == 0) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

}
