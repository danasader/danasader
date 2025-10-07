
  // Dana Sader

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class MergeSort {

    public static <T> void mergeSort(T[] a, Comparator<T> c) {
        T[] copy = (T[]) new Object[a.length];
        _mergeSort(a, c, copy,0, a.length-1);
    }
    
    private static <T> void _mergeSort(T[] a, Comparator<T> c, T[] copy, int start, int end) {
        if (start < end) {
            int mid = (start+end)/2;
            _mergeSort(a, c, copy, start, mid);
            _mergeSort(a, c, copy, mid+1, end);
            merge(a, c, copy, start, mid, end);
        }
    }

    private static <T> void merge (T[] a, Comparator<T> c, T[] copy, int start, int mid, int end) {

        int i = 0, j = start, k;
        while (j <= mid)
            copy[i++] = a[j++];
        i = 0;
        k = start;
        while (k < j && j <= end) {
            if (c.compare(copy[i], a[j]) <= 0)
                a[k++] = copy[i++];
            else
                a[k++] = a[j++];
        }
        while (k < j)
            a[k++] = copy[i++];
    }

    public static void main(String[] args) {

        Comparator<String> c = new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if (Objects.equals(o1, o2)) 
                    return 0;
                if (o1 == null) 
                    return -1;
                if (o2 == null) 
                    return 1;
                return o1.compareTo(o2);
            }
        };
        String[] a = {"baa", "aaa", "abc", "aac", "bba", "acc"};
        mergeSort(a, c);
        System.out.println(Arrays.toString(a));
        mergeSort(a, c.reversed());
        System.out.println(Arrays.toString(a));
    }
}