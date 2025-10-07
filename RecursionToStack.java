

  // Isabell Karakas and Dana Sader

import aud.Stack;

public class RecursionToStack {
   
    /* The following applies: As long as n is less than 10, no digit sum needs to be calculated.
Otherwise, n is divided by 10 and then added to the remainder (modulo 10). */

    public static int whatRec(int n) {

        // recursive calculation of the digit sum
        if (n < 10)
            return n;
        else
            return whatRec(n / 10) + n % 10;
    }

    // Method whatStack is iterative variant, whatRec the recursive variant
    public static int whatStack(int n) {

        // Calculating the digit sum with Stack
        int digitsum = 0;
        Stack<Integer> newStack = new Stack<>();
        while (n > 0) {
            newStack.push(n % 10);
            n /= 10;
        }
        while (!newStack.is_empty()) {
            digitsum += newStack.pop();
        }
        return digitsum;
    }

    public static void main(String[] args) {

        // Testing with numbers from 0 to 30
        for (int n = 0; n <= 30; n++) {
            System.out.println("The digit sum from the whatStack method is:" + whatStack(n));
            System.out.println("The digit sum from the whatRec method is:" + whatRec(n));
        }

        // Further examples for checking the methods

        // System.out.println(whatRec(10));    // 1
        // System.out.println(whatRec(12));    // 3
        // System.out.println(whatStack(10));  // 1
        // System.out.println(whatStack(12));  // 3
    }
}

