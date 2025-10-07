

  // Dana Sader and Isabell Karakas

public class TailRecursion {

  /* Method "pow2" calculates the power of 2 2^n recursively
The recursion must be performed in tail recursion!
Note: This requires implementing another recursive method with tail recursion
that is called by "pow2()".*/

    public static int pow2(int n) {
        return _pow2(n, 1); // Calling the helper method "_pow2()"
    }

  /* Helper method "_pow2()"
This method is called by the "pow2()" method and calculates
the power of 2 2^n recursively in tail recursion*/

    private static int _pow2(int n, int x) {

        // Base case: n is 0, result is returned
        if (n == 0) {
            return x;
        }
        else {

      /* Recursive call to "_pow2()", n is reduced by 1,
x is doubled and passed as an argument to "_pow2()"*/
            return _pow2(n - 1, x * 2);
        }
    }

  /* Method "sumFactors()"
Calculates the sum of all factors of a number n recursively*/

    public static int sumFactors(int n) {

        // Special cases: n is 0 or 1, sum is returned directly
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        // Recursive call of the helper method "findFactors()"
        return findFactors(n, 0, 1);
    }

  /* Auxiliary method "findFactors()"
This method is called by the "sumFactors()" method and
recursively calculates the sum of all factors of a number n*/

    private static int findFactors(int n, int x, int counter) {

        // Base case: counter is equal to n, sum is returned
        if (n == counter) {
            return x;
        }

        else {

            // If counter is a factor of n, it is added to the sum x
            if (n % counter == 0) {
                x = x + counter;
            }
            
            // counter is increased by 1 and the method "findFactors()" is called recursively
            return findFactors(n, x, counter + 1);
        }
    }

    // Main method for testing the functions "pow2()" and "sumFactors()"
    public static void main(String[] args) {

        System.out.println(pow2(3));        // expected 8 = 2^3
        System.out.println(sumFactors(6));  // expected 12 = 1 + 2 + 3 + 6
        System.out.println(pow2(9));        // expected 512 = 2^9
        System.out.println(sumFactors(12)); // expected 28 = 1 + 2 + 3 + 4 + 6 + 12
    }
}
