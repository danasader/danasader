

  // Dana Sader

public class TernarySearch {

    static final int UNDEF = -1;
    static int p=0;
    static int t=0;

    public static int find(int[] a, int x) {
        return _find(a, 0, a.length - 1, x);
    }

    private static int _find(int[] a, int l, int r, int x) {

        p++;
        if (l > r) return UNDEF;
        int m = (l + r) / 2;
        if (x == a[m]) return m;
        else if (x < a[m]) return _find(a, l, m - 1, x);
        else return _find(a, m + 1, r, x);
    }

    public static int ternaryRec(int[] a, int x) {

        t++;
        int l1 = 0;
        int r1 = a.length - 1;

        while (l1 <= r1)
        {
            int l1middle = l1 + (r1 - l1) / 3;
            int r1middle= r1 - (r1 - l1) / 3;

            if (a[l1middle] == x) {
                return l1middle;
            }
            else if (a[r1middle] == x) {
                return r1middle;
            }
            else if (a[l1middle] > x) {
                r1 = l1middle - 1;
            }
            else if (a[r1middle] < x) {
                l1 = r1middle + 1;
            }
            else {
                l1 = l1middle + 1;
                r1 = r1middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7,8,9,10};
        int x=8;
        System.out.println(ternaryRec(a,x));
        System.out.println(find(a,x));
        System.out.println(_find(a, 0, 9, x));
        System.out.println("the number of recursive calls for the binary search is " + " " + p );
        System.out.println("the number of recursive calls for the ternary search is " + " " + t );
        System.out.println(ternaryRec(a,100));
        System.out.println(find(a,100));
    }
}
