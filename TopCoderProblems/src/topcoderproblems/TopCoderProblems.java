/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topcoderproblems;

import java.util.Arrays;

public class TopCoderProblems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestSquareDigits();
        TestPrerequisites();
        TestBinaryCode();
    }
    
    private static void TestSquareDigits() {
        SquareDigits sd = new SquareDigits();
        for (int number : new int[] { 2, 10, 19, 85, 112 }) {
            System.out.format("Smallest result of square digits of %d: %d\r\n", number, sd.smallestResult(number));
        }
    }
    
    private static void TestPrerequisites() {
        String[][] testCases = new String[][]
        {
            { "CS117:" },
            { "cs117:" },
            { "CS9E11:" },
            { "CSE110: " },
            { "CSE110: CSE101 " },
            { "MATH211: MAM2222" },
            { "MATH211: MAM22" },
            { "ENGIN517: MATH211" },
            { "CSE200: CSE100 CSE105", "CSE100:", "CSE105: CSE100" },
            { "CSE121: CSE110", "CSE110:", "MATH122:" },
            { "ENGL111: ENGL110", "ENGL110: ENGL111" },
            { "ENGL111: ENGL110" },
            { "CSE258: CSE244 CSE243 INTR100", "CSE221: CSE254 INTR100",
              "CSE254: CSE111 MATH210 INTR100", "CSE244: CSE243 MATH210 INTR100",
              "MATH210: INTR100", "CSE101: INTR100", "CSE111: INTR100",
              "ECE201: CSE111 INTR100", "ECE111: INTR100", "CSE243: CSE254",
              "INTR100:" }
        };
        for (String[] testCase : testCases) {
            System.out.println("Test case: " + Arrays.deepToString(testCase));
            System.out.println("Schedule: " + Arrays.deepToString(new Prerequisites().orderClasses(testCase)));
        }
    }

    private static void TestBinaryCode() {
        String[] testCases = new String[]
        { 
            "123210122", 
            "11", 
            "22111", 
            "123210120", 
            "3", 
            "12221112222221112221111111112221111" 
        };
        
        for (String testCase : testCases) {
            System.out.println("Test case: " + testCase);
            System.out.println("Decoded values: " + Arrays.deepToString(new BinaryCode().decode(testCase)));
        }
    }
}
