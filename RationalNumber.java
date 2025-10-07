
  // Dana Sader

public class RationalNumber implements Comparable<RationalNumber> {

    private int num = 2;
    private int denom = 3;

    public RationalNumber() {
    }

    public RationalNumber(int n, int d) {

        if (d == 0)
            d = 1;
        if (d < 0) {
            n = n * -1;
            d = d * -1;
        }
        num = n;
        denom = d;
    }

    private int gcd(int n, int d) {
        int g = gcd(n, d);
        num = n / g;
        denom = d / g;
        return num;
    }

    public int getNum() {
        return num;
    }

    public int getDenom() {
        return denom;
    }

    public int compareTo(RationalNumber n) {

        RationalNumber c = this;
        int lhs = c.num * n.denom;
        int rhs = c.denom * n.num;
        if (lhs < rhs) {
            return -1;
        }
        if (lhs > rhs) {
            return 1;
        }
        return lhs;
    }

    public RationalNumber add(RationalNumber r) {

        int commonDenominator = denom * r.getDenom();
        int numerator1 = num * r.getDenom();
        int numerator2 = r.getNum() * denom;
        int sum = numerator1 + numerator2;
        return new RationalNumber(sum, commonDenominator);
    }

    public RationalNumber div(RationalNumber r) {

        int n = num / r.getNum();
        int d = denom / r.getDenom();
        return new RationalNumber(n, d);
    }

    public String toString() {

        String result;
        if (num == 0) {
            result = 0;
        } else if (denom == 1) {
            result = num / denom;
        }
        return result;
    }
    
    public static void main(String[] args){
        System.out.println(num);
        System.out.println(denom);
        System.out.println(g);
        System.out.println(RationalNumber(sum, commonDenominator));
        System.out.println(RationalNumber(n, d));
    }
}
