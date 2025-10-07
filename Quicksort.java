
  // Dana Sader

public class Quicksort {

    public static void quicksort(int[] a) {

        quicksort(a, 0, a.length-1);
        insertionsort(a);
        assert isSorted(a);
    }

    static void quicksort(int[] a, int left, int right) {

        if (right > left) {
            int p = partition(a, left, right);
            quicksort(a, left, p-1);
            quicksort(a, p+1, right);
            assert isSorted(a, left, right);
        }
    }

    static int partition(int[] a, int left, int right) {

        assert left <= right;
        int p = a[right];            // Select a[right] as the pivot element.
        int t;
        int i = left-1, k = right;
        do {
            do ++i; while (a[i] < p);
            do --k; while ((k > 0) && (a[k] > p));
            t = a[i]; a[i] = a[k]; a[k] = t;
        } while (i < k);
        a[k] = a[i]; a[i] = a[right]; a[right] = t;
        return i;
    }

    // Insertion Sort
    public static void insertionsort(int[] a) {

        int n = a.length;
        for (int i=1; i < n; ++i) {
            int t = a[i];
            int k;
            for (k = i; (k > 0) && (a[k - 1] > t); --k) {
                a[k] = a[k - 1];
                a[k] = t;
            }
        }
    }

    // verify order in array a
    public static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length-1);
    }

    public static boolean isSorted(int[] a, int left, int right) {
        for (int i=left; i < right; ++i) {
            if (a[i] > a[i+1]) {
                return false;
            }
        }
        return true;
    }

    //  test examples
    public static void main(String[] args) {

        int[] a = { 0, 1, 6, 4, 5, 8, 9, 3, 7, 2 };
        quicksort(a);
        assert isSorted(a);
    }
}

