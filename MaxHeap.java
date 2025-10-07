

// Dana Sader 

import java.util.*;

//-----------------------------------------------------------------//
public class MaxHeap<T extends Comparable<T>> {
    //-----------------------------------------------------------------//
    //------------- !!Do not change the following lines!! -------------//

    T[] arr;

    public String toString() {
        return heap_.toString();  // don't change because of backend
    }

    //---------------------------------------------------------------//
    //--------------- !!Insert your solution below!! ----------------//
    private final ArrayList<T> heap_ = new ArrayList<>(); // or Vector

    //---------------------------------------------------------------//
    public MaxHeap() {
    }

    //---------------------------------------------------------------//
    public MaxHeap(T[] arr) {

        // constructs a heap from array
        for (int i = 0; i < arr.length; i++) {
            heap_.add(arr[i]);
            upHeap(i);
        }
        // downHeap Method
        int n = 15;
        while(!heap_.isEmpty()) {
            downHeap(n);
            n--;
        }
    }

    //---------------------------------------------------------------//
    public ArrayList<T> getHeap () {
        return heap_;
    }

    //---------------------------------------------------------------//

    public int getSize () {
        return heap_.size();
    }

    //---------------------------------------------------------------//

    public boolean isEmpty () {
        return heap_.isEmpty();
    }

    //---------------------------------------------------------------//
    
    // downHeap Method is used below
    public void downHeap (int n) {
        
        T x = arr[n];
        while (n <= n / 2) {
            int j = 2 * n;
            if (j < n && (arr[j].compareTo(arr[j + 1]) > 0)) {
                j = j + 1;
            }
            if (x.compareTo(arr[j]) < 0) {
                break;
            }
            arr[n] = arr[j];
            n = j;
        }
        arr[n] = x;
    }
    //---------------------------------------------------------------//

    public void insert(T obj) {

        int n=0;
        n=n+1;
        arr[n]=obj;
        upHeap(n);
    }

    //---------------------------------------------------------------//
    
    // upHeap Method is used below
    private void upHeap(int n) {
        
        T x = arr[n];
        while (n > 1 && x.compareTo(arr[n / 2]) < 0) {
            arr[n] = arr[n / 2];
            n = n / 2;
        }
        arr[n] = x;
    }
    
    public static void main(String[] args) {
        
        MaxHeap<String> MaxHeap = new MaxHeap<>();
        MaxHeap.insert("X");
        MaxHeap.insert("T");
        MaxHeap.insert("O");
        MaxHeap.insert("G");
        MaxHeap.insert("S");
        MaxHeap.insert("M");
        MaxHeap.insert("N");
        MaxHeap.insert("A");
        MaxHeap.insert("E");
        MaxHeap.insert("R");
        MaxHeap.insert("A");
        MaxHeap.insert("I");
        System.out.println(MaxHeap.toString());
    }
}
