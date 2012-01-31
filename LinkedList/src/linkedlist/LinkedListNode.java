/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author YeAndNoni
 */
public class LinkedListNode<E extends Comparable> {
    public E data;
    public LinkedListNode<E> next;
    
    public LinkedListNode(E data, LinkedListNode<E> next) {
        this.data = data;
        this.next = next;
    }
}
