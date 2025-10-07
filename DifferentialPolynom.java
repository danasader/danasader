
// Dana Sader

import java.util.Arrays;

public class DifferentialPolynom {
    
    public static double[] diffPoly(double[] coeffs) {

        // one time differentiation
        // y=x^n, y'=n*x^(n-1)
        int n= coeffs.length-1;

        double[] k = new double[n];
        for (int i = 0; i < n; i++) {
            k[i] = coeffs[i + 1] * (i + 1);
        }
        return k;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(diffPoly(new double []{1,2,4,6,8,9,10})));
        System.out.println("\n");
        System.out.println(Arrays.toString(diffPoly(new double[]{0})));
        System.out.println(Arrays.toString(diffPoly(new double[]{7})));
    }
}