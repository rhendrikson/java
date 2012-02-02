/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void appendNode(LinkedListNode<E> node) {
        if (this.isEmpty()) {
            this.head = node;
            this.tail = this.head;
            ++this.length;
            return;
        }

        this.tail.next = node;
        this.tail = node;
        ++this.length;
    }

    public void sortedInsert(E data) {
        if (this.isEmpty()) {
            this.append(data);
            return;
        }

        this.sortedInsert(this.head, this.tail, data);
    }

    public void insertSort() throws EmptyListException {
        LinkedList<E> sortedList = new LinkedList<>();
        for (E data : this) {
            sortedList.sortedInsert(data);
        }
        this.deleteList();
        this.head = sortedList.head;
    }

    private void sortedInsert(LinkedListNode<E> startNode, LinkedListNode<E> endNode, E data) {
        if (startNode == endNode) {
            if (data.compareTo(startNode.data) >= 0) {
                startNode.next = new LinkedListNode<>(data, startNode.next);
                if (this.tail == endNode) {
                    this.tail = startNode.next;
                }
            } else {
                startNode = new LinkedListNode<>(data, startNode);
                this.head = startNode;  // At this point, data is smallest in the list.
            }
            ++this.length;
            return;
        }

        if (startNode.next == endNode) {
            if (data.compareTo(startNode.data) > 0) {
                this.sortedInsert(endNode, endNode, data);
            } else {
                this.sortedInsert(startNode, startNode, data);
            }
            return;
        }

        LinkedListNode<E> middleNode = this.findMiddle(startNode, endNode);
        if (data.compareTo(middleNode.data) > 0) {
            this.sortedInsert(middleNode, endNode, data);
        } else {
            this.sortedInsert(startNode, middleNode, data);
        }
    }

    private LinkedListNode<E> findMiddle(
            LinkedListNode<E> startNode,
            LinkedListNode<E> endNode) {

        LinkedListNode<E> slowPointer = startNode;
        LinkedListNode<E> fastPointer = startNode;
        while (fastPointer != null
                && fastPointer != endNode
                && fastPointer.next != null
                && fastPointer.next != endNode) {

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    public void sortedMerge(LinkedList<E> firstList, LinkedList<E> secondList) {
        if (firstList.isEmpty()) {
            this.appendList(secondList);
            return;
        }

        if (secondList.isEmpty()) {
            this.appendList(firstList);
            return;
        }

        try {
            if (firstList.head.data.compareTo(secondList.head.data) <= 0) {
                this.moveNodeToEnd(firstList, this);
            } else {
                this.moveNodeToEnd(secondList, this);
            }
        } catch (EmptyListException ex) {
            // Will never happen.
        }

        this.sortedMerge(firstList, secondList);
    }

    public void mergeSort(LinkedList<E> list) {
        if (list.isEmpty()) {
            return;
        }

        if (list.getLength() == 1) {
            return;
        }

        try {
            if (list.getLength() == 2) {
                if (list.head.data.compareTo(list.head.next.data) < 0) {
                    list.moveNodeToEnd(list, list);
                }
                return;
            }
        
            LinkedListPair<E> lists = list.split();
            this.mergeSort(lists.firstList);
            this.mergeSort(lists.secondList);

            this.sortedMerge(lists.firstList, lists.secondList);
        } catch (EmptyListException e) {
            // Will never happen.
        }
    }

    public LinkedListPair<E> split() throws EmptyListException {
        if (this.isEmpty()) {
            throw new EmptyListException();
        }

        LinkedList<E> firstList;
        LinkedList<E> secondList;

        LinkedListNode<E> slowPointer = this.head;
        LinkedListNode<E> fastPointer = this.head;

        firstList = new LinkedList<>();
        while (fastPointer != null && fastPointer.next != null) {
            firstList.append(slowPointer.data);
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        if (this.getLength() % 2 == 1) {
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

    public LinkedListPair<E> alternatingSplit() throws EmptyListException {
        if (this.isEmpty()) {
            throw new EmptyListException();
        }

        if (this.getLength() == 1) {
            return new LinkedListPair<>(this, null);
        }

        LinkedList<E> firstList = new LinkedList<>();
        LinkedList<E> secondList = new LinkedList<>();

        LinkedList<E> destination = firstList;
        for (LinkedListNode<E> node : this.nodesIterator) {
            this.moveNode(this, destination);
            destination = (destination == firstList) ? secondList : firstList;
        }

        return new LinkedListPair<>(firstList, secondList);
    }

    public void shuffleMerge(LinkedList<E> firstList, LinkedList<E> secondList) {
        if (firstList.isEmpty()) {
            this.appendList(secondList);
            return;
        }

        if (secondList.isEmpty()) {
            this.appendList(firstList);
            return;
        }

        try {
            this.moveNodeToEnd(firstList, this);
        } catch (EmptyListException e) {
            // Will never happen.
        }

        this.shuffleMerge(secondList, firstList);
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

    public LinkedListNode<E> popNode() throws EmptyListException {
        if (this.isEmpty()) {
            throw new EmptyListException();
        }

        LinkedListNode<E> node = this.head;
        this.head = this.head.next;
        node.next = null;
        --this.length;
        return node;
    }

    public void pushNode(LinkedListNode<E> node) {
        if (this.isEmpty()) {
            this.tail = node;
        }
        node.next = this.head;
        this.head = node;
        this.length++;
    }

    public void removeDuplicates() {
        LinkedListNode<E> currentNode = this.head;
        LinkedListNode<E> previousNode = null;
        while (currentNode != null) {
            if (previousNode != null && currentNode.data.compareTo(previousNode.data) == 0) {
                previousNode.next = currentNode.next;
            } else {
                previousNode = currentNode;
            }
            currentNode = currentNode.next;
        }
    }

    public void moveNode(LinkedList<E> source, LinkedList<E> destination) throws EmptyListException {
        destination.pushNode(source.popNode());
    }

    public void moveNodeToEnd(LinkedList<E> source, LinkedList<E> destination) throws EmptyListException {
        destination.appendNode(source.popNode());
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