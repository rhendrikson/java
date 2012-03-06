/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

import java.util.Iterator;

public class SinglyLinkedListNode<E extends Comparable> implements Iterable<SinglyLinkedListNode<E>> {
    
    public E data;
    public SinglyLinkedListNode next;
    
    public SinglyLinkedListNode() {}
    
    public SinglyLinkedListNode(E data, SinglyLinkedListNode next) {
        this.data = data;
        this.next = next;
    }
    
    public SinglyLinkedListNode(E... data) {
        SinglyLinkedListNode<E> current = this;
        for (int i = 0; i < data.length; i++) {
            current.data = data[i];
            if (i == data.length - 1) break;
            current.next = new SinglyLinkedListNode<>();
            current = current.next;
        }
    }
    
    public void append(E data) {
        SinglyLinkedListNode<E> newNode = new SinglyLinkedListNode<>(data, null);
        SinglyLinkedListNode<E> tail = this;
        
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;
    }
    
    public int length() {
        int length = 0;
        SinglyLinkedListNode<E> current = this;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
    
    private SinglyLinkedListNode<E> self() {
        return this;
    }

    @Override
    public Iterator<SinglyLinkedListNode<E>> iterator() {
        return new Iterator<SinglyLinkedListNode<E>>() {
            
            private SinglyLinkedListNode<E> current = self();

            @Override
            public boolean hasNext() {
                return (current != null);
            }

            @Override
            public SinglyLinkedListNode<E> next() {
                SinglyLinkedListNode<E> previous = current;
                current = current.next;
                return previous;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }

}
