/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

import algorithmproblems.linkedlists.DeduplicateLinkedListStrategy.DeduplicateLinkedListStrategy;
import java.util.HashMap;

public class DeduplicateLinkedList {
    
    private DeduplicateLinkedListStrategy strategy;
    
    public void setStrategy(DeduplicateLinkedListStrategy strategy) {
        this.strategy = strategy;
    }
    
    public <E extends Comparable> void deduplicate(SinglyLinkedListNode<E> head) {
        strategy.deduplicate(head);
    }
    
    public <E extends Comparable> boolean hasDuplicate(SinglyLinkedListNode<E> head) {
        HashMap<E, Integer> elementCounts = new HashMap<>();
        for (SinglyLinkedListNode<E> node : head) {
            int elementCount = elementCounts.get(node.data) == null ? 0 : elementCounts.get(node.data);
            elementCounts.put(node.data, ++elementCount);
            if (elementCount > 1) {
                return true;
            }
        }
        
        return false;
    }

}
