/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author YeAndNoni
 */
public class LinkedListPair<E extends Comparable> {

    public LinkedList<E> firstList;
    public LinkedList<E> secondList;

    public LinkedListPair(LinkedList<E> firstList, LinkedList<E> secondList) {
        this.firstList = firstList;
        this.secondList = secondList;
    }
    
}
