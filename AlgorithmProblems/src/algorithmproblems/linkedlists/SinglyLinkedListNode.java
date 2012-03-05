/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

public class SinglyLinkedListNode<E extends Comparable> {
    
    public E data;
    public SinglyLinkedListNode next;
    
    public SinglyLinkedListNode(E data, SinglyLinkedListNode next) {
        this.data = data;
        this.next = next;
    }
    
    public void append(E data) {
        SinglyLinkedListNode<E> newNode = new SinglyLinkedListNode<>(data, null);
        SinglyLinkedListNode<E> tail = this;
        
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;
    }

}
