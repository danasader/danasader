
// Isabell Karakas and Dana Sader

import java.util.Stack;

/**
 * ForwardList represents a list with single linked nodes, that do have
 * a next-pointer.
 */
public class ForwardList<T> implements Iterable<T> {
    //-----------------------------------------------------------------//
    //------------- !!Do not change the following lines!! -------------//
    public String toString() {
        if (is_empty())
            return "[]";
        String rv = "[";
        Node node = head_;
        do {
            rv += node.data_.toString();
            if (node.next_ != head_)
                rv += ",";
            node = node.next_;
        } while (node != null);
        rv += "]";
        return rv;
    }

    //-----------------------------------------------------------------//
    //---------------- !!Insert your solution below!! -----------------//
    // A Node is a single element in the list
    public class Node {
        //---------------------------------------------------------------//
        //    !!! Do not change the existing lines in class Node!!!      //
        //            !!! It is allowed to add new content !!!           //
        //       !!! It is not allowed to add a previous pointer !!!     //
        //---------------------------------------------------------------//
        public T data_;
        public Node next_ = null;

        public Node(T data, Node next) {
            data_ = data;
            next_ = next;
        }
    }

    //-----------------------------------------------------------------//
    public Node head_ = null;

    //-----------------------------------------------------------------//
    public ForwardList() {
    }
    //-----------------------------------------------------------------//
    public void push_front(T obj) {

        // elements are added to the front of the list
        Node tempNode = new Node(obj, head_);
        head_ = tempNode;
    }

    // count number of elements in the list
    public int counter() {

        // if list is empty, return zero
        if (head_ == null) {
            return 0;
        }

        // initialize myCounter to zero and set tempNode as head_
        int myCounter = 0;
        Node tempNode = head_;

        while (tempNode == head_) {
            myCounter++;

            // set tempNode to the next element in the list
            tempNode = tempNode.next_;
        }
        return myCounter;
    }

    public boolean is_empty() {

        // If head_ = null, list empty, therefore true, otherwise false
        return head_ == null;
    }

    // Method to output elements in reverse order
    public void backTraverse() {
        Stack<Node> randomStack = new Stack<Node>();
        // check if the list is empty, if so, push the list into randomStack in reverse order
        if (is_empty()) {
            Node tempNode = head_;
            while (tempNode != null) {
                randomStack.push(tempNode);
                tempNode = tempNode.next_;
            }

            /* Here, each node in the random stack is popped
            and outputed to print the list in reverse order. */
            while (!randomStack.empty()) {
                System.out.println(randomStack.pop());
            }
        }
        // if the list is not empty, then we exit the method without outputting anything
    }

    public class BackIterator implements java.util.Iterator<T> {

        // iterator that provides a reveres iteration is implemented below
        Stack<Node> randomStack = new Stack<Node>();
        int myCounter = 0;

        public BackIterator() {
            if (!is_empty()) {
                Node tempNode = head_;
                while (tempNode != null) {
                    randomStack.push(tempNode);
                    tempNode = tempNode.next_;
                    myCounter++;
                }
            } else {
            }
        }
        public boolean hasNext() {
            if (myCounter != 0) {
                return true;
            }
            return false;
        }
        public T next() {
            myCounter--;
            Node tempNode = randomStack.pop();
            return tempNode.data_;
        }
    }
    public BackIterator iterator() {

        // return an instance of the iterator
        return new BackIterator();
    }
    public static void main(String[] args) {

        ForwardList<Integer> myTestlist = new ForwardList<Integer>();
        myTestlist.push_front(101);
        myTestlist.push_front(202);
        myTestlist.push_front(303);
        myTestlist.push_front(404);
        myTestlist.iterator();
        System.out.println(myTestlist);
    }
}
