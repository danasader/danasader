
 // Dana Sader
 
import java.util.Arrays;
import java.util.Random;

/** simple Hashtable with linear/quadratic probing
 capacity is big enough */

public class HashLinQuad {

    private int[] table_;    // array of buckets or slots
    private int size_;       // current number of elements
    private int capacity_;
    private int key;  // the value which is already in the hash table

    // Constructor
    public HashLinQuad() {

        size_ = 0;
        capacity_ = 1249;
        table_ = new int[1000];
    }

    public int addLin(int obj) {

        // linear probing
        // return number of collisions

        int a = 0;   // counter to count the number of collisions
        int i = 0;

        // if condition is used to check if the hash table is empty then the element will be added to the hash table
        if (table_ == null) {
            table_[i] = obj;
        }

         /* if condition is used to check if the key value in the hash table is equal
         to the value of the new element then
         the new element will be added to the hash table and collision will occur */

        if (key == obj) {
            table_[i] = obj;
            a++;
        }
        i = (i + 1) % capacity_;
        return a;
    }

    public int addQuad(int obj) {

        // quadratic probing
        // return number of collisions

        int b=0;  // counter to count the number of collisions

        // Iterate through the array
        for (int i = 0; i < capacity_; i++) {

            // get the hash value
            int value = table_[i] % capacity_;

            // Insert in the table if there is no collision
            if (table_[value] <= 0)
                table_[value] = obj;

            else {

                // If there is a collision then iterate through all quadratic values
                for (int j = 0; j < capacity_; j++) {

                    //  get the new hash value
                    int k = (value + j * j) % capacity_;
                    if (table_[k] <= 0) {

                        // stop the loop after inserting the element in the table
                        table_[k] = obj;
                        b++;
                        break;
                    }
                }
            }
        }
        return obj;
    }

    public String toString() {
        return Arrays.toString(table_);
    }

    public static void main(String[] args) {

        // TODO: test with hashtable-capacity of 1259 and 1000 random values

        // using random numbers for an Array with 1259 indices and 1000 random values
        Random x = new Random();
        int[] Values = new int[1000];

        for (int i = 0; i < 1000; i++)
            Values[i] = x.nextInt(1259);

        // the hash table to be filled using linear probing
        HashLinQuad Hash = new HashLinQuad();
        int a = 0;
        for (int i = 0; i < 1000; i++)
            a += Hash.addLin(Values[i]);
        System.out.println(Hash);
        System.out.println(a);

        // fill the hash table with quadratic probing
        Hash = new HashLinQuad();
        int b = 0;
        for (int i = 0; i < 1000; ++i)
            b += Hash.addQuad(Values[i]);
        System.out.println(Hash);
        System.out.println(b);
    }
}
