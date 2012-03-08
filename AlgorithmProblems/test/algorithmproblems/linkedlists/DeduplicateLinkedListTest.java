/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmproblems.linkedlists;

import algorithmproblems.linkedlists.DeduplicateLinkedListStrategy.DeduplicateLinkedListStrategy;
import algorithmproblems.linkedlists.DeduplicateLinkedListStrategy.DeduplicateLinkedListWithHashStrategy;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DeduplicateLinkedListTest {

    @Parameterized.Parameters
    public static List<Object[]> strategies() {
        return Arrays.asList(new Object[][]
        {
            { new DeduplicateLinkedListWithHashStrategy() },
            { new DeduplicateLinkedListWithHashStrategy() }
        });
    }
    
    private DeduplicateLinkedList deduplicateLinkedList;
    
    public DeduplicateLinkedListTest(DeduplicateLinkedListStrategy strategy) {
        deduplicateLinkedList = new DeduplicateLinkedList();
        deduplicateLinkedList.setStrategy(strategy);
    }

    @Test
    public void testDeduplicate() {
        SinglyLinkedListNode<Character> linkedList = new SinglyLinkedListNode<>('F', 'O', 'L', 'L', 'O', 'W', ' ', 'U', 'P');
        deduplicateLinkedList.deduplicate(linkedList);
        
        char[] actual = new char[linkedList.length()];
        int i = 0;
        for (SinglyLinkedListNode<Character> node : linkedList) {
            actual[i++] = node.data;
        }
        char[] expected = {'F', 'O', 'L', 'W', ' ', 'U', 'P'};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testHasDuplicate() {
    }

}