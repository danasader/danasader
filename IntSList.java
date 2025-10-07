
 // implemented by: Dana Sader and Isabell Karakas

import aud.SList;
import java.util.function.Predicate;

public class IntSList {

    SList<Integer> li;
    public IntSList() {
        li = new SList<>();
    }
    
    public IntSList(int[] list) {
        li = new SList<>();
        for (int i = 0; i < list.length; i++) {
            li.push_back(list[i]);
        }
    }

    // delegate (execute a task as specified) to the SList
    @Override
    public String toString() {
        return li.toString();
    }
    public void push_front(int obj) {
        li.push_front(obj);
    }

    public IntSList filter(Predicate<Integer> p) {

        IntSList new_li = new IntSList();
        int counter = 0;
        for (SList<Integer>.Iterator i = li.iterator(); i.hasNext(); ) {
            if (p.test(li.at(counter))) {
                new_li.push_front(li.at(counter));
            }
            counter++;
            i.next();
        }
        return new_li;
    }

    // Test examples with the given numbers and filter applications
    public static void main(String[] args) {

        int[] test2 = {85, 72, 93, 81, 74, 42};
        IntSList testlist2 = new IntSList(test2);
        testlist2 = testlist2.filter(new PredicateGreater42());
        System.out.println(testlist2);

        int[] test1 = {85, 72, 93, 81, 74, 42};
        IntSList testlist1 = new IntSList(test1);
        testlist1 = testlist1.filter(new PredicateDivisorEven());
        System.out.println(testlist1);
    }
}

// here we want to print all numbers that are greater than 42
 class PredicateGreater42 implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        if (integer > 42) {
            return true;
        } else {
            return false;
        }
    }
}

 // We now want to use the Modulo to see if the remainder is equal to zero to find out which number is even
 class PredicateDivisorEven implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        if (integer % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
