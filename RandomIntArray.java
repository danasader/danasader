

// Dana Sader

import java.util.Arrays;

public class RandomIntArray {
    //---------------------------------------------------------------------------//
    public static int[] createRandom(int n) {

        int maxrand = 10;
        int z = (int)(maxrand*Math.random());
        int []array = new int[z];
        return array;
    }

    //---------------------------------------------------------------------------//
    public static String toString(int[] a) {
        String k = a.toString();
        return k;
    }

    //---------------------------------------------------------------------------//
    public static int posMin(int[] a) {

        if (a.length == 0)
            return -1;

        int index = 0;
        int min = a[index];

        for (int i = 1; i < a.length; i++){
            if (a[i] <= min){
                min = a[i];
                index = i;
            }
        }
        return index;
    }

    //---------------------------------------------------------------------------//
    public static int[] swap(int[] a) {

        int p = a.length-1;
        int y= a[0];
        a[0]=a[p] ;
        a[p]=y;
        y=a[0];
        return a;
    }

    public static void main (String[]args){

        int[] a = {100,400,1,4,5,3};
        System.out.println(Arrays.toString(createRandom(2)));
        System.out.println(posMin(a));
        System.out.println(Arrays.toString(swap(a)));
    }
}
