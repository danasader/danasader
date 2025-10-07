
  // Dana Sader

import java.math.BigInteger;

public class AckermannFunction {

    public static BigInteger ackermann(BigInteger x, BigInteger y) {

        if (y.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }

        if (x.equals(BigInteger.ZERO)){
            return y.multiply(BigInteger.TWO);
        }

        if (y.equals(BigInteger.ONE)) {
            return BigInteger.TWO;
        }

        else{
            return ackermann(x.subtract(BigInteger.ONE), ackermann(x, y.subtract(BigInteger.ONE)));
        }
    }

    public static void main(String[] args) {

        System.out.println(ackermann(BigInteger.ONE,BigInteger.TEN));
        System.out.println(ackermann(BigInteger.TWO,BigInteger.valueOf(4)));
        System.out.println(ackermann(BigInteger.valueOf(3),BigInteger.valueOf(3)));
        System.out.println(ackermann(BigInteger.ONE,BigInteger.ZERO));
        System.out.println(ackermann(BigInteger.ZERO,BigInteger.ONE));
        System.out.println(ackermann(BigInteger.ONE,BigInteger.valueOf(3)));
    }
}
