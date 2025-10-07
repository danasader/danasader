
 // Dana Sader

import java.util.Arrays;

public class MedianOfThree {
    
    public static int median(int a, int b, int c) {

        int[] ArrayNumbers = {a, b, c};
        int x = ArrayNumbers.length;
        Arrays.sort(ArrayNumbers);    // the array should be sorted first

        /*
       The median of a sorted array of length x is defined as the middle element if x is odd,
and as the average of the middle two elements if x is even
         */

         /*
                   if (x % 2 == 0) {
  return (ArrayNumbers[(x - 1) / 2] + ArrayNumbers[x / 2]) / 2;
        }
          */
        return ArrayNumbers[x / 2];
    }
    //---------------------------------------------------------------------------//
    public static int median2(int a, int b, int c) {

        // compare element b with elements a and c
        if (( b > a && b < c) || ( b > c && b < a))
            return b;

            // compare element a with elements b and c
        else if (( a > b && a < c) || ( a > c && a < b))
            return a;
        else
            return c;
    }

    //---------------------------------------------------------------------------//
    public static void main(String[] args) {

        System.out.println(median2(14, 2, 9));
        System.out.println(median2(300, 90, 76));
        System.out.println(median2(3, 50, 82));
        System.out.println(median2(12, 13, 19));
        System.out.println(median(0,1,2));
        System.out.println(median(4,10,52));
        System.out.println(median(10,52,4));
        System.out.println(median(5,1,30));
        System.out.println(median(30,1,5));
        System.out.println(median(1,5,30));
    }
}

