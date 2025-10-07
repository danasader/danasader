
 // Dana Sader and Isabell Karakas

public class JosephusProblem {

/* Solve the Josephus problem for a list of people and a
number of people to be skipped. The solution should
"simulate" the counting and return a queue containing all
people in the order they were counted. */

    public static Queue<String> solve(String[] persons, int k) {

        // a variable that should tell me the number of people
        int peroflen = persons.length;

    /* Create two new queues, one for those that remain and one for those that are removed.
enqueue is a method in the Queue data structure that adds an element to the end of the queue.
The added element is also called the last element.
In contrast, the dequeue method removes the first element from the queue and returns it,
which is also called the first element.*/

        Queue<String> a = new Queue<>();
        Queue<String> b = new Queue<>();

        for (int i = 0; i < peroflen; i++)
            a.enqueue(persons[i]);
        for (int i = 0; i < peroflen; i++) {
            for (int j = 0; j < k - 1; j++)
                a.enqueue(a.dequeue());
                b.enqueue(a.dequeue());
        }

        // returns the result of all persons in the order in which they were counted
        return b;
    }
    public static void main(String[] args) {

        System.out.println("a test for the Multicultural-Squad");
        String[] persons = {"Sibel", "Rama", "Samina", "Dilara", "Isabell", "Dana"};
        solve(persons, 3);
    }
}