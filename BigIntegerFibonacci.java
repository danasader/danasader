
// Dana Sader

import java.math.*;

public class BigIntegerFibonacci {

    public static BigInteger fib1(int n) {

        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        } else {
            return fib1(n - 2).add(fib1(n - 1));
        }
    }

    public static BigInteger fib2(int n) {

        BigInteger t = BigInteger.ZERO;
        BigInteger k = BigInteger.ONE;
        BigInteger TotalValue = BigInteger.ZERO;
        for (int i = 0; i <= n; i++) {

            TotalValue = t.add(k);
            t = k;
            k = TotalValue;
        }
        return TotalValue;
    }

    public static void main (String[]args){

        for (int i = 0; i < 25; i++)
            System.out.println(fib2(i));

        for (int i = 0; i < 15; i++) {
            System.out.println(fib1(i));
        }

        System.out.println("\n");
        System.out.println("\n");

        for (int i = 0; i <  15; i++) {
            System.out.println(fib2(i));
        }

        System.out.println("\n");
        System.out.println("\n");

        for (int i = 0; i < 23; i++) {
            System.out.println(fib1(i));
        }

        System.out.println("\n");
        System.out.println("\n");

        for (int i = 0; i < 23; i++) {
            System.out.println(fib2(i));
        }

        System.out.println("\n");
        System.out.println(fib1(5));
        System.out.println(fib2(5));
    }
}
