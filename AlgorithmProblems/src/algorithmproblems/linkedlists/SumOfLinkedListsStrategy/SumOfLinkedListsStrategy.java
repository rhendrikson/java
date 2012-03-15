/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists.SumOfLinkedListsStrategy;

import algorithmproblems.linkedlists.SinglyLinkedListNode;

public interface SumOfLinkedListsStrategy {

    SinglyLinkedListNode<Integer> calculateSumForward(SinglyLinkedListNode<Integer> linkedList1, SinglyLinkedListNode<Integer> linkedList2);
    SinglyLinkedListNode<Integer> calculateSumBackward(SinglyLinkedListNode<Integer> linkedList1, SinglyLinkedListNode<Integer> linkedList2);
    
}
