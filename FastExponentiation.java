
  // Dana Sader
  
public class FastExponentiation {

    public static double fastPotRek(double x, int n) {

        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            return fastPotRek(x, n / 2) * fastPotRek(x, n / 2);
        } else {
            return x * fastPotRek(x, n - 1);
        }
    }

    public static double fastPotIter(double x, int n) {

        double a=1;
        for (int i = 0; i < n; i++) {
            a = a * x;
        }
        return a;
    }

    public static void main(String[] args) {
        
        System.out.println(fastPotRek(2,13));
        System.out.println(fastPotIter(2,13));
        System.out.println(fastPotRek(3,5));
        System.out.println(fastPotIter(3,5));
    }
}





