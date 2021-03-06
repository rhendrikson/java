/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistproblems;

import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import linkedlist.EmptyListException;
import linkedlist.LinkedList;
import linkedlist.LinkedListPair;

/**
 *
 * @author YeAndNoni
 */
public class LinkedListProblems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String testsToRun = "countUniques,countDuplicates,getByIndex,getByIndexExceedingLength,getByNegativeIndex,"
                + "deleteList,deleteEmptyList,push,pop,popEmptyList,"
                + "insertAtHead,insertAtMiddle,insertAtTail,insertAtNegativeIndex,insertAtIndexExceedingLength,"
                + "splitOneElementList,splitTwoElementList,splitThreeElementList,splitEvenList,splitOddList,"
                + "sortedInsertSmallerHead,sortedInsertSmallerMiddle,sortedInsertLargerMiddle,sortedInsertLargerTail,"
                + "insertSort,removeDuplicates,removeDuplicatesInUniqueList,moveNode,"
                + "alternatingSplit,alternatingSplitEmptyList,alternatingSplitSingleNodeList,shuffleMerge,"
                + "sortedMerge,mergeSort";

        if (args.length > 0) {
            testsToRun = args[0];
        }

        for (StringTokenizer stringTokenizer = new StringTokenizer(testsToRun, ","); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();

            switch (token.toLowerCase()) {
                case "countuniques":
                    countUniqueOccurrences();
                    break;
                case "countduplicates":
                    countDuplicateOccurrences();
                    break;
                case "getbyindex":
                    getByIndex();
                    break;
                case "getbyindexexceedinglength":
                    try {
                        getByIndexExceedingLength();
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
                case "getbynegativeindex":
                    try {
                        getByNegativeIndex();
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
                case "deletelist":
                    deleteList();
                    break;
                case "deleteemptylist":
                    deleteEmptyList();
                    break;
                case "push":
                    push();
                    break;
                case "pop":
                    popList();
                    break;
                case "popemptylist":
                    popEmptyList();
                    break;
                case "insertathead":
                    insertAtHead();
                    break;
                case "insertatmiddle":
                    insertAtMiddle();
                    break;
                case "insertattail":
                    insertAtTail();
                    break;
                case "insertatnegativeindex":
                    insertAtNegativeIndex();
                    break;
                case "insertatindexexceedinglength":
                    insertAtIndexExceedingLength();
                    break;
                case "splitoneelementlist":
                    splitOneElementList();
                    break;
                case "splittwoelementlist":
                    splitTwoElementList();
                    break;
                case "splitthreeelementlist":
                    splitThreeElementList();
                    break;
                case "splitevenlist":
                    splitEvenList();
                    break;
                case "splitoddlist":
                    splitOddList();
                    break;
                case "sortedinsertsmallerhead":
                    sortedInsertSmallerHead();
                    break;
                case "sortedinsertsmallermiddle":
                    sortedInsertSmallerMiddle();
                    break;
                case "sortedinsertlargermiddle":
                    sortedInsertLargerMiddle();
                    break;
                case "sortedinsertlargertail":
                    sortedInsertLargerTail();
                    break;
                case "insertsort":
                    insertSort();
                    break;
                case "removeduplicates":
                    removeDuplicates();
                    break;
                case "removeduplicatesinuniquelist":
                    removeDuplicatesInUniqueList();
                    break;
                case "movenode":
                    moveNode();
                    break;
                case "alternatingsplit":
                    alternatingSplit();
                    break;
                case "alternatingsplitemptylist":
                    alternatingSplitEmptyList();
                    break;
                case "alternatingsplitsinglenodelist":
                    alternatingSplitSingleNodeList();
                    break;
                case "shufflemerge":
                    shuffleMerge();
                    break;
                case "sortedmerge":
                    sortedMerge();
                    break;
                case "mergesort":
                    mergeSort();
                    break;
                default:
                    break;
            }
        }
    }

    private static void countUniqueOccurrences() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        int integer = 2;
        LinkedList<Integer> integers = createIntegerLinkedList();
        integers.print();
        System.out.format("%d occurred %d times.\r\n", integer, integers.countOccurences(integer));
    }

    private static void countDuplicateOccurrences() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        int integer = 2;
        LinkedList<Integer> integers = createIntegerLinkedListWithDuplicates();
        integers.print();
        System.out.format("%d occurred %d times.\r\n", integer, integers.countOccurences(integer));
    }

    private static void getByIndex() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        int index = 2;
        LinkedList<Integer> integers = createIntegerLinkedList();
        integers.print();
        System.out.format("integers[%d] = %d\r\n", index, integers.getByIndex(index));
    }

    private static void getByIndexExceedingLength() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        int index = integers.getLength();
        integers.print();
        System.out.format("integers[%d] = %d\r\n", index, integers.getByIndex(index));
    }

    private static void getByNegativeIndex() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        int index = -1;
        integers.print();
        System.out.format("integers[%d] = %d\r\n", index, integers.getByIndex(index));
    }

    private static void deleteList() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        integers.print();
        try {
            integers.deleteList();
            if (integers.getLength() == 0) {
                System.out.println("List deleted.");
            }
        } catch (EmptyListException e) {
            System.out.println(e);
        }
    }

    private static void deleteEmptyList() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = new LinkedList<>();
        integers.print();
        try {
            integers.deleteList();
            if (integers.getLength() == 0) {
                System.out.println("List deleted.");
            }
        } catch (EmptyListException e) {
            System.out.println(e);
        }
    }

    private static void popList() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        try {
            System.out.format("Popped %d from %s.\r\n", integers.pop(), integers);
        } catch (EmptyListException e) {
            System.out.println(e);
        }
    }

    private static void popEmptyList() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = new LinkedList<>();
        try {
            System.out.format("Popped %d from %s.\r\n", integers.pop(), integers);
        } catch (EmptyListException e) {
            System.out.println(e);
        }
    }

    private static void push() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = new LinkedList<>();
        integers.push(1);
        integers.print();
    }

    private static void insertAtHead() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        integers.insertAt(1, 0);
        integers.print();
    }

    private static void insertAtMiddle() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        integers.insertAt(5, 4);
        integers.print();
    }

    private static void insertAtTail() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        integers.insertAt(10, integers.getLength() - 1);
        integers.print();
    }

    private static void insertAtNegativeIndex() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        try {
            integers.insertAt(1, -1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    private static void insertAtIndexExceedingLength() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        try {
            integers.insertAt(10, integers.getLength());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    private static void splitOneElementList() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = new LinkedList<>();
        integers.append(1);
        try {
            LinkedListPair<Integer> lists = integers.split();
            lists.firstList.print();
            if (lists.secondList != null) {
                lists.secondList.print();
            }
        } catch (EmptyListException e) {
            System.out.println(e);
        }
    }

    private static void splitTwoElementList() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = new LinkedList<>();
        integers.append(1);
        integers.append(2);
        try {
            LinkedListPair<Integer> lists = integers.split();
            lists.firstList.print();
            lists.secondList.print();
        } catch (EmptyListException e) {
            System.out.println(e);
        }
    }

    private static void splitThreeElementList() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = new LinkedList<>();
        integers.append(1);
        integers.append(2);
        integers.append(3);
        try {
            LinkedListPair<Integer> lists = integers.split();
            lists.firstList.print();
            lists.secondList.print();
        } catch (EmptyListException e) {
            System.out.println(e);
        }
    }

    private static void splitEvenList() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        try {
            LinkedListPair<Integer> lists = integers.split();
            lists.firstList.print();
            lists.secondList.print();
        } catch (EmptyListException e) {
            System.out.println(e);
        }
    }

    private static void splitOddList() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        integers.append(11);
        try {
            LinkedListPair<Integer> lists = integers.split();
            lists.firstList.print();
            lists.secondList.print();
        } catch (EmptyListException e) {
            System.out.println(e);
        }
    }

    private static void sortedInsertSmallerHead() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        integers.sortedInsert(0);
        integers.print();
    }
    
    private static void sortedInsertSmallerMiddle() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        integers.sortedInsert(4);
        integers.print();
    }
    
    private static void sortedInsertLargerMiddle() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        integers.sortedInsert(7);
        integers.print();
    }
    
    private static void sortedInsertLargerTail() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        integers.sortedInsert(11);
        integers.print();
    }

    private static void insertSort() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        try {
            integers.insertSort();
            integers.print();
        } catch (EmptyListException e) {
            System.out.println(e);
        }
    }

    private static void removeDuplicates() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        integers.sortedInsert(4);
        integers.print();
        integers.removeDuplicates();
        integers.print();
    }

    private static void removeDuplicatesInUniqueList() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        integers.print();
        integers.removeDuplicates();
        integers.print();
    }

    private static void moveNode() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> source = createIntegerLinkedList();
        LinkedList<Integer> destination = createIntegerLinkedList();
        try {
            source.moveNode(source, destination);
            source.print();
            destination.print();
        } catch (EmptyListException e) {
            System.out.println(e);
        }
    }

    private static void alternatingSplit() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createIntegerLinkedList();
        try {
            LinkedListPair<Integer> lists = integers.alternatingSplit();
            lists.firstList.print();
            lists.secondList.print();
        } catch (EmptyListException e) {
            System.out.println(e);
        }
    }

    private static void alternatingSplitEmptyList() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = new LinkedList<>();
        try {
            LinkedListPair<Integer> lists = integers.alternatingSplit();
        } catch (EmptyListException e) {
            System.out.println(e);
        }
    }

    private static void alternatingSplitSingleNodeList() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = new LinkedList<>();
        integers.append(1);
        try {
            LinkedListPair<Integer> lists = integers.alternatingSplit();
            lists.firstList.print();
            if (lists.secondList != null) {
                lists.secondList.print();
            }
        } catch (EmptyListException e) {
            System.out.println(e);
        }
    }

    private static void shuffleMerge() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers1 = createIntegerLinkedList();
        LinkedList<Integer> integers2 = createIntegerLinkedList();
        LinkedList<Integer> mergedIntegers = new LinkedList<>();
        integers1.print();
        integers2.print();
        mergedIntegers.shuffleMerge(integers1, integers2);
        mergedIntegers.print();
    }

    private static void sortedMerge() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers1 = createIntegerLinkedList();
        LinkedList<Integer> integers2 = createIntegerLinkedList();
        LinkedList<Integer> mergedIntegers = new LinkedList<>();
        integers1.print();
        integers2.print();
        mergedIntegers.sortedMerge(integers1, integers2);
        mergedIntegers.print();
    }

    private static void mergeSort() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        printMethodName(stackTrace);
        LinkedList<Integer> integers = createRandomIntegerLinkedList();
        integers.print();
        LinkedList<Integer> sortedIntegers = new LinkedList<>();
        sortedIntegers.mergeSort(integers);
        sortedIntegers.print();
    }

    private static LinkedList<Integer> createRandomIntegerLinkedList() {
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 10; i > 0; i--) {
            integers.insert((new Random()).nextInt(9) + 1);
        }
        return integers;
    }

    private static LinkedList<Integer> createIntegerLinkedList() {
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 10; i > 0; i--) {
            integers.insert(i);
        }
        return integers;
    }

    private static LinkedList<Integer> createIntegerLinkedListWithDuplicates() {
        LinkedList<Integer> integers1 = createIntegerLinkedList();
        LinkedList<Integer> integers2 = createIntegerLinkedList();
        integers1.appendList(integers2);
        return integers1;
    }

    private static void printMethodName(StackTraceElement[] stackTrace) {
        System.out.println("Executing " + stackTrace[1].getMethodName());
    }
}
