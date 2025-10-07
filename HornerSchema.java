
 // Dana Sader
 
public class HornerSchema {
    //---------------------------------------------------------------------------//
    /**
     * Iteratively evaluates a polynomial by summing up all indices of a multiplied with x to the power of the index value.
     * @param a double[] array
     * @param x double[] array
     * @return double, where the returned value is the evaluated given polynomial.
     */
    public static double evalSimple(double[] a, double x) {
        double result = 0;
        for (int i = 0; i < a.length; i++) {
            result += (a[i] * exponentEval(x, i));
        }
        return result;
    }

    /**
     * Calculates a base to the power of an exponent.
     * Alternative to math.pow()
     * @param base double base
     * @param exponent double exponent
     * @return double, where the returned value is the base to the power of the exponent.
     */
    public static double exponentEval(double base, double exponent) {
        if (exponent == 0) return 1;
        double result = base;
        for (int i = 1; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
    //Number of multiplications: sum (all n between 1 and n) + 1
    //Therefore, for n = 5: (1+2+3+4+5)+1 = 16 multiplications total (including a[0]*x^0).
    //---------------------------------------------------------------------------//

    /**
     * Iteratively evaluates a polynomial according to the Horner's method.
     * @param a double[] array
     * @param x double base
     * @return double, where the returned value is the result of evaluating the given polynomial.
     */
    public static double evalHorner(double[] a, double x) {
        if (a.length == 1) return a[0];
        int i = a.length - 1;
        double result = 0;
        while (i != 0) {
            if (result == 0) result = x * a[i] + a[i - 1];
            else result = (result * x + a[i - 1]);
            i--;
        }
        return result;
    }
    /* Number of multiplications: degree of the polynomial.
     *for degree of polynomial = 5: 5 multiplications total.
     *this is evidently much more efficient in terms of the numbers of multiplications
     *compared to the simple evaluation method.
     */
    //---------------------------------------------------------------------------//

    /**
     * Recursively determines the result of a polynomial using the Horner's method.
     * @param a double[] array
     * @param x double base
     * @param i counter for current array elements (See l. 58)
     * @return double, where the returned value is the result of the polynomial.
     */
    public static double evalHornerRec(double[] a, double x, Integer i) { 
        if (a.length == 1) return a[0];
        if (i == a.length-2) return (a[i]+a[i+1]*x);
        return a[i]+x*(evalHornerRec(a,x, i + 1));
    }
    
    /**
     * Sets default i for evalHornerRec to 0 by overloading the method and calling the first one with param a, x and 0.
     * This is used going by the assumption, that the sample solution does not foresee the default i value of i.
     * Alternatively, a global variable can be used to default Integer i to 0, though that solution is considered bad practice
     * @param a double[] array
     * @param x double base
     * @return returns evalHornerRec(a,x,0)
     */
    public static double evalHornerRec(double[] a, double x) {
        return evalHornerRec(a,x,0);
    }

    //---------------------------------------------------------------------------//
    public static void main(String args[]) {
        double[] input = {-2,-15,-2};
        double x = 12;
        System.out.println("Simple evaluation: "+evalSimple(input, x));
        System.out.println("Iterative Horner evaluation: "+evalHorner(input, x));
        System.out.println("Recursive Horner evaluation: "+evalHornerRec(input, x));
    }
}
