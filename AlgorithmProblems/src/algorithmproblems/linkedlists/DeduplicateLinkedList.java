/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

import algorithmproblems.linkedlists.DeduplicateLinkedListStrategy.DeduplicateLinkedListStrategy;

public class DeduplicateLinkedList {
    
    private DeduplicateLinkedListStrategy strategy;
    
    public void setStrategy(DeduplicateLinkedListStrategy strategy) {
        this.strategy = strategy;
    }
    
    public <E extends Comparable> void deduplicate(SinglyLinkedListNode<E> head) {
        strategy.deduplicate(head);
    }
    
    public <E extends Comparable> boolean hasDuplicate(SinglyLinkedListNode<E> head) {
        return false;
    }

}
