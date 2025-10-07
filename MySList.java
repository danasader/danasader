  
  // Dana Sader and Isabell Karakas

public class MySList implements Iterable<Integer> {

    public String toString() {

        if (empty()) return "[]";
        String rv = "[";
        Node node = head_;
        do {
            rv += node.data_;
            if (node.next_ != null) rv += ",";
            node = node.next_;
        } while (node != null);
        rv += "]";
        return rv;
    }

    // Class for a node in the linked list
    class Node {

        int data_;                                          // data in the node
        Node next_;                                         // Reference to the next node

        // Constructor with data as parameter
        Node(int data_) {
            this.data_ = data_;
            next_ = null;
        }

        // Constructor with data and next node as parameter
        Node(int data_, Node nextelement) {
            this.data_ = data_;
            this.next_ = nextelement;
        }
    }

    Node head_ = null;                                      // Head node of the list, first element
    public MySList() {
    }

    // Method to add an item to the end of the list
    public void push_back(int obj) {
        if (empty()) {
            head_ = new Node(obj);
        } else {
            Node last = getlast();
            last.next_ = new Node(obj);
        }
    }

    // Method to add an element to the beginning of the list
    public void push_front(int obj) {

        if (empty()) {                                      // if the list is empty
            head_ = new Node(obj);
        } else {
            Node currentnode = new Node(obj, head_);    // create a new node and set it as the new head node
            head_ = currentnode;
        }
    }

    // Method that returns the last node of the list
    public Node getlast() {
        Node currentnode = head_;                       // Start with the head node of the list
        if (head_ == null) {
            return null;
        }

    // as long as there are still nodes and if the current node is the last one, then return this node
        while (currentnode != null) {
            if (currentnode.next_ == null) {
                return currentnode;
            }

   // move on to the next node when we get back to the head node (after one cycle), then finish and exit the loop
            currentnode = currentnode.next_;
            if (head_ == currentnode) {
                break;
            }
        }
        return null;                                        // if no nodes are found, return null
    }

    // Method that returns the number of nodes in the list
    public int size() {

        Node currentnode = head_;                       // start with the head node
        int counter = 0;
        if (head_ == null) {                                // if the list is empty
            return 0;
        }

    // as long as there are still nodes, go to the next node and count the nodes
        while (currentnode != null) {
            currentnode = currentnode.next_;
            counter++;
        }
        return counter;                                     // return the number of nodes
    }

    // Method that checks whether the list is empty
    public boolean empty() {
        if (head_ == null) {
            return true;
        }
        return false;
    }

    // Implementation of the iterator
    public Iterator iterator() {
        return new Iterator();
    }

    public class Iterator implements java.util.Iterator<Integer> {

        Node currentnode = head_;
        public boolean hasNext() {

            // check if the current node is null
            if (currentnode == null) {
                return false;
            }

            // traverse the list to find the next odd element
            Node tempnode = currentnode;
            while (tempnode != null) {

                // note that there are positive and negative values that can be odd
                if (tempnode.data_ % 2 == 1 || tempnode.data_ % 2 == -1) {
                    return true;
                }
                tempnode = tempnode.next_;
            }
            return false;
        }

        public Integer next() {

            // iterate through the list to find and return the next odd element
            while (hasNext()) {

                // note again that there are positive and negative values that can be odd
                if (currentnode.data_ % 2 == 1 || currentnode.data_ % 2 == -1) {
                    int returndata = currentnode.data_;
                    currentnode = currentnode.next_;
                    return returndata;
                }
                currentnode = currentnode.next_;
            }
            return null;
        }
        public void remove(int obj) {
        }
    }


    //----------------------------------------------------------------//
    public static void main(String[] args) {

        // Creating the list and inserting elements
        MySList list1 = new MySList();
        int[] listint = {85, 72, 93, 81, 74, 42};
        for (int i = 0; i < listint.length; i++) {
            list1.push_back(listint[i]);
        }

        // Output of the list and the odd elements
        System.out.println(list1);
        System.out.println();
        for (MySList.Iterator it = list1.iterator(); it.hasNext(); ) {
            System.out.print(it.next() + " ");
        }

        // Creating the list and inserting elements
        MySList myTest = new MySList();
        int[] testint = {-85, -72, -93, -81, -74, -42};
        for (int i = 0; i < testint.length; i++) {
            myTest.push_back(testint[i]);
        }

        // Output of the list and the odd elements
        System.out.println(myTest);
        System.out.println();
        for (MySList.Iterator it = myTest.iterator(); it.hasNext(); ) {
            System.out.print(it.next() + " ");
        }
    }
}
