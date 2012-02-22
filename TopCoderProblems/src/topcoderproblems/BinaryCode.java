/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package topcoderproblems;

/**
 *
 */
public class BinaryCode {

    public String[] decode(String message) {
        String[] results = new String[2];
        results[0] = this.decodeWithSeed(0, message);
        results[1] = this.decodeWithSeed(1, message);
        return results;
    }

    private String decodeWithSeed(int seed, String message) {
        char[] messageChars = message.toCharArray();
        char[] result = new char[messageChars.length];
        result[0] = Character.forDigit(seed, 10);
        int firstDigit = 0;
        int secondDigit = 0;
        int resultDigit = 0;
        for (int i = 1; i < messageChars.length; i++) {
            if (i > 1) {
                firstDigit = Character.digit(result[i - 2], 10);
            }
            secondDigit = Character.digit(result[i - 1], 10);
            resultDigit = Character.digit(messageChars[i - 1], 10) - secondDigit - firstDigit;
            if (resultDigit > 1) {
                return "NONE";
            }
            

            
            result[i] = Character.forDigit(resultDigit, 2);
        }
        
        if (Character.digit(messageChars[messageChars.length - 1], 10) != resultDigit + secondDigit) {
            return "NONE";
        }
        return String.copyValueOf(result);
    }
    
}
