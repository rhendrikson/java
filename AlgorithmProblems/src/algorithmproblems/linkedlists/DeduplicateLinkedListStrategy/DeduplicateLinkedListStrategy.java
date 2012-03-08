/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmproblems.linkedlists.DeduplicateLinkedListStrategy;

import algorithmproblems.linkedlists.SinglyLinkedListNode;

public interface DeduplicateLinkedListStrategy {
    <E extends Comparable> void deduplicate(SinglyLinkedListNode<E> head);
}
