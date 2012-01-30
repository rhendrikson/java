/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author YeAndNoni
 */
public class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;
    
    public LinkedListNode(T data, LinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }
}
