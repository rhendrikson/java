/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

public class SumOfLinkedLists {
    
    public static SinglyLinkedListNode<Integer> calculateSumBackward(SinglyLinkedListNode<Integer> linkedList1, SinglyLinkedListNode<Integer> linkedList2) {
        if (linkedList1 == null || linkedList2 == null) return null;
        
        int number1 = 0;
        int power = 0;
        while (linkedList1 != null) {
            number1 += linkedList1.data * Math.pow(10, power++);
            linkedList1 = linkedList1.next;
        }
        
        int number2 = 0;
        power = 0;
        while (linkedList2 != null) {
            number2 += linkedList2.data * Math.pow(10, power++);
            linkedList2 = linkedList2.next;
        }
        
        int sum = number1 + number2;
        SinglyLinkedListNode<Integer> sumLinkedList = new SinglyLinkedListNode<>();
        SinglyLinkedListNode<Integer> sumLinkedListTail = sumLinkedList;
        while (sum > 0) {
            sumLinkedListTail.next = new SinglyLinkedListNode<>(sum % 10, null);
            sumLinkedListTail = sumLinkedListTail.next;
            sum /= 10;
        }
        sumLinkedList = sumLinkedList.next;
        
        return sumLinkedList;
    }
    
    public static SinglyLinkedListNode<Integer> calculateSumForward(SinglyLinkedListNode<Integer> linkedList1, SinglyLinkedListNode<Integer> linkedList2) {
        if (linkedList1 == null || linkedList2 == null) return null;
        
        int number1 = 0;
        while (linkedList1 != null) {
            number1 = number1 * 10 + linkedList1.data;
            linkedList1 = linkedList1.next;
        }
        
        int number2 = 0;
        while (linkedList2 != null) {
            number2 = number2 * 10 + linkedList2.data;
            linkedList2 = linkedList2.next;
        }
        
        int sum = number1 + number2;
        SinglyLinkedListNode<Integer> sumLinkedList = null;
        while (sum > 0) {
            sumLinkedList = new SinglyLinkedListNode<>(sum % 10, sumLinkedList == null ? null : sumLinkedList);
            sum /= 10;
        }
        
        return sumLinkedList;
    }

}
