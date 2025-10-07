

  // Dana Sader
  
import java.util.Arrays;

public class PrimeTwins {

    public static boolean isPrime(int n) {

        // 1 and all numbers less than 1 are not prime numbers
        if (n <= 1) {
            return false;
        }

        // 2 is a prime number
        if (n == 2) {
            return true;
        }

        // All even numbers > 2 are not prime numbers
        if (n % 2 == 0) {
            return false;
        }

       /* Only odd numbers need to be tested as divisors,
                so we start at 3 and increase in steps of two.
        Furthermore, we only need to test up to root(s), since of a
        divisor pair (a,b) with a*b = n, one of the two numbers a,b
must always be less than or equal to root(s). */

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) { // n is divisible by i without a remainder, so it is not prime
                return false;
            }
        }
        // If we got this far, we have not found any divisors for n
        return true;
    }

    public static int[][] primeTwins(int amount) {

        int x = 0;   // x is the row in the two-dimensional array int[][]a
        int p = 5;   // because p<q and 5<7
        int q = 7;
        int[][] a = new int[amount][2];

        while (x < amount) {

            if ((isPrime(p)) && (isPrime(q))) {
                // if p and q are prime numbers, p is entered in column 0 and q in column 1
                a[x][0] = p;
                a[x][1] = q;
                x++;
                p++;// Increment p++ is used to generate different prime numbers other than 5 in column 0
                q++;// q++ is used to generate different prime numbers other than 7 in column 1
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(24));// 24 is not a prime number
        System.out.println(isPrime(7));// 7 is a prime number
        System.out.println(isPrime(13));
        System.out.println(isPrime(52));
        System.out.println(Arrays.deepToString(primeTwins(40)));
        System.out.println(Arrays.deepToString(primeTwins(60)));
    }
}