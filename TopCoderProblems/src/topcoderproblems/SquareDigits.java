/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topcoderproblems;

import java.util.ArrayList;

public class SquareDigits {    
    public int smallestResult(int param0) {
        int i = 0;
        while (true) {
            if (sumsOfSquareDigits(i).contains(param0)) {
                return i;
            }
            i++;
        }
    }

    private ArrayList sumsOfSquareDigits(int n) {
        ArrayList sums = new ArrayList();
        int sum = n;
        while (true) {
            sum = this.sumOfSquareDigits(sum);
            if (sums.contains(sum)) break;
            sums.add(sum);
        }
        return sums;
    }

    private int sumOfSquareDigits(int n) {
        int sum = 0;
        int digit = 0;
        while (n > 0) {
            digit = n % 10;
            n /= 10;
            sum += digit * digit;
        }
        return sum;
    }
}
