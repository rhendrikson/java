/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topcoderproblems;

public class TopCoderProblems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestSquareDigits();
        TestPrerequisites();
    }
    
    private static void TestSquareDigits() {
        SquareDigits sd = new SquareDigits();
        System.out.println(sd.smallestResult(2));
        System.out.println(sd.smallestResult(10));
        System.out.println(sd.smallestResult(19));
        System.out.println(sd.smallestResult(85));
        System.out.println(sd.smallestResult(112));
    }
    
    private static void TestPrerequisites() {
        Prerequisites prerequisites = new Prerequisites();
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
            String[] schedule = prerequisites.orderClasses(testCase);
            for (String className : schedule) {
                System.out.print(className + " ");
            }
            System.out.println();
        }
    }
}
