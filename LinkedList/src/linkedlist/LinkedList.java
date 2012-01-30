/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.Iterator;

/**
 *
 * @author YeAndNoni
 */
public class LinkedList<E extends Comparable> implements Iterable<E> {

    private LinkedListNode<E> head;
    private LinkedListNode<E> tail;
    private int length;
    private LinkedListNodeIterable nodesIterator;

    private class LinkedListIterator extends IteratorBase implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return super.hasNext();
        }

        @Override
        public E next() {
            if (!this.hasNext()) {
                return null;
            }

            E data = this.current.data;
            this.current = this.current.next;
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    private class LinkedListNodeIterable implements Iterable<LinkedListNode<E>> {

        @Override
        public Iterator<LinkedListNode<E>> iterator() {
            return new LinkedListNodeIterator();
        }
    }

    private class LinkedListNodeIterator extends IteratorBase implements Iterator<LinkedListNode<E>> {

        @Override
        public boolean hasNext() {
            return super.hasNext();
        }

        @Override
        public LinkedListNode<E> next() {
            if (!this.hasNext()) {
                return null;
            }

            LinkedListNode<E> node = this.current;
            this.current = this.current.next;
            return node;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    private abstract class IteratorBase {

        protected LinkedListNode<E> current;

        public IteratorBase() {
            this.current = head;
        }

        public boolean hasNext() {
            return (this.current != null);
        }
    }

    public LinkedList() {
        this.head = null;
        this.tail = this.head;
        this.length = 0;
        this.nodesIterator = new LinkedListNodeIterable();
    }

    public void push(E data) {
        this.insert(data);
    }

    public void insert(E data) {
        LinkedListNode<E> newNode = new LinkedListNode<>(data, this.head);
        if (this.isEmpty()) {
            this.tail = newNode;
        }
        this.head = newNode;
        this.length++;
    }

    public void insertAt(E data, int index) {
        if (index < 0 || index > this.getLength() - 1) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            this.push(data);
            return;
        }

        int i = 0;
        LinkedListNode<E> previousNode = this.head;
        for (LinkedListNode<E> node : this.nodesIterator) {
            if (i == index) {
                LinkedListNode<E> newNode = new LinkedListNode<>(data, node);
                previousNode.next = newNode;
                ++this.length;
                break;
            }
            previousNode = node;
            i++;
        }
    }

    public void append(E data) {
        LinkedListNode<E> newNode = new LinkedListNode<>(data, null);

        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
            ++this.length;
            return;
        }

        LinkedListNode<E> currentTail = this.tail;
        this.tail = newNode;
        currentTail.next = this.tail;
        ++this.length;
    }

    public void sortedInsert(E data) {
        this.sortedInsert(this, data);
    }

    private void sortedInsert(LinkedList<E> list, E data) {
        /*
         * Assume the list elements are unique. Split list in half. If list
         * length == 1 If data > head insert data at tail else insert data at
         * head If data > head of second half run sortedInsert in second half
         * else run sortedInsert in first half
         */
        if (list.isEmpty()) {
            list.append(data);
            return;
        }
        
        if (list.getLength() == 1) {
            if (data.compareTo(list.head.data) > 0) {
                list.append(data);
                return;
            }
            
            list.push(data);
            return;
        }

        try {
            LinkedListPair<E> lists = this.split(list);
            if (data.compareTo(lists.secondList.head.data) > 0) {
                this.sortedInsert(lists.secondList, data);
            } else {
                this.sortedInsert(lists.firstList, data);
            }
        } catch (EmptyListException e) {
            // Will never happen because empty list case is handled above.
        }
    }

    public LinkedListPair<E> split(LinkedList<E> list) throws EmptyListException {
        if (list.isEmpty()) {
            throw new EmptyListException();
        }

        LinkedList<E> firstList;
        LinkedList<E> secondList;

        LinkedListNode<E> slowPointer = list.head;
        LinkedListNode<E> fastPointer = list.head;

        firstList = new LinkedList<>();
        while (fastPointer != null && fastPointer.next != null) {
            firstList.append(slowPointer.data);
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        if (list.getLength() % 2 == 1) {
            firstList.append(slowPointer.data);
            slowPointer = slowPointer.next;
        }

        secondList = new LinkedList<>();
        while (slowPointer != null) {
            secondList.append(slowPointer.data);
            slowPointer = slowPointer.next;
        }

        return new LinkedListPair<>(firstList, secondList);
    }

    public boolean isEmpty() {
        return (this.head == null);
    }

    public int countOccurences(E data) {
        int occurrences = 0;
        for (E d : this) {
            if (d == data) {
                occurrences++;
            }
        }
        return occurrences;
    }

    public E getByIndex(int index) {
        if (index < 0 || index > this.getLength() - 1) {
            throw new IndexOutOfBoundsException();
        }

        int i = 0;
        for (E data : this) {
            if (i++ == index) {
                return data;
            }
        }

        return null;
    }

    public int getLength() {
        return this.length;
    }

    public void appendList(LinkedList<E> linkedList) {
        this.tail.next = linkedList.head;
        linkedList.head = null;
    }

    public void deleteList() throws EmptyListException {
        while (!this.isEmpty()) {
            this.pop();
        }
    }

    public E pop() throws EmptyListException {
        if (this.isEmpty()) {
            throw new EmptyListException();
        }

        E data = this.head.data;
        this.head = this.head.next;
        --this.length;
        return data;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public String toString() {
        StringBuilder linkedListString = new StringBuilder();
        boolean isFirstData = true;
        for (E data : this) {
            if (!isFirstData) {
                linkedListString.append(", ");
            }
            linkedListString.append(String.format("%d", data));
            isFirstData = false;
        }
        return linkedListString.toString();
    }

    public void print() {
        System.out.println("List: " + this);
    }
}