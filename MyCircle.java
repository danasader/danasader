
  // Dana Sader and Isabell Karakas

public class MyCircle<T> {

    // A Node is a single element in the ring
    class Node {
        T data_ = null;
        Node next_ = null;
        Node prev_ = null;

        Node(T obj, Node prv, Node nxt) {
            data_ = obj;
            prev_ = prv;
            next_ = nxt;
        }
    }
    protected Node head_ = null;

    // class methods
    public   MyCircle() { head_ = null; }
    public T front()    { return head_.data_; }
    public String toString() {
        if (empty())
            return "[]";
        String rv = "[";
        Node node = head_;
        do {
            rv += node.data_.toString();
            if (node.next_ != head_)
                rv += ",";
            node = node.next_;
        } while(node != head_);
        rv += "]";
        return rv;
    }

    public int size() {

        // Return value of the number of our ring buffer
        //  if the head node is zero, then there are no nodes

        if (head_ == null) {
            return 0;                           }
        int counter = 1;               // start counting from 1
        Node node = head_;

    // As long as the next node is not the head node, it should count up the number of nodes
        while (node.next_ != head_) {
            node = node.next_;
            ++counter;
        }
        return counter;
    }

    //-----------------------------------------------------------------//
    public boolean empty() {

        // returns the value if ring buffer is empty
        if (head_ == null) {
            return true;
        }
        return false;
    }

    //-----------------------------------------------------------------//
    public void push_back(T obj) {

    /* Here, an element is inserted at the end of the ring (before the head node)
and the ring is closed again */

        MyCircle<T> new_circle = new MyCircle<T>();
        if (size() == 0) {
            head_ = new Node(null, null, null);
            head_.data_ = obj;
            head_.next_ = head_;
            head_.prev_ = head_;
            return;
        }
        new_circle.head_ = new Node(obj, head_.prev_, head_);
        head_.prev_.next_ = new_circle.head_;
        head_.prev_ = new_circle.head_;
    }

    //-----------------------------------------------------------------//
    public void pop_front() {

        // Here a link at the beginning of the ring is removed
        if (size() == 0) {
            return;
        }
        if (size() == 1) {
            head_ = null;
            return;
        }
        head_.data_ = head_.next_.data_;
        head_.next_ = head_.next_.next_;
    }

    //-----------------------------------------------------------------//
    public static void main(String[] args) {

        MyCircle<Integer> circle = new MyCircle<>();
        circle.push_back(4700);
        circle.push_back(6300);
        circle.push_back(2800);
        circle.push_back(3400);
        circle.push_back(1800);
        circle.push_back(3900);
        System.out.println(circle.toString());
        System.out.println(circle.size());

        // Here we remove the first two specified elements from our ring one after the other
        circle.pop_front();
        circle.pop_front();
        System.out.println(circle.toString());
        System.out.println(circle.size());
    }
}
