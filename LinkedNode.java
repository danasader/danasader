
// Dana Sader and Isabell Karakas

import java.util.ArrayList;
import java.util.List;

public class LinkedNode<T> {

    T data_ = null;                 // Initialize the date to null
    LinkedNode<T> next_ = null;     // Initializing the next node to null

    LinkedNode(T data) {            // Constructor with data parameter
        data_ = data;                 // Assigning the data parameter to the data attribute
    }
    
    LinkedNode(T data, LinkedNode<T> next) {     // Constructor with data and node parameters

        data_ = data;                              // Assigning the data parameter to the data attribute
        next_ = next;                              // Assigning the node parameter to the node attribute
    }

    LinkedNode() {                 // empty constructor
    }

    // returns the next node if it is defined
    public LinkedNode<T> getNext() {

        if (next_ != null) {
            return next_;
        }
        return null;
    }

    // returns the value of the node
    public T getData() {

        if (data_ != null) {
            return data_;
        }
        return null;
    }

    // sets the next node
    public void setNext(LinkedNode<T>newnode){
        next_ = newnode;
    }

    // sets the value of the node
    public void setData(T newdata){
        data_ = newdata;
    }

    // returns a string representation of the list starting from the current node
    @Override

    public String toString() {

        LinkedNode<T> newnode = next_;       // Initialization of the node to the next node
        String dataresult= data_.toString(); // Converting the current node value to string
        while (newnode != null) {            // Iterate through the list starting from the current node

            dataresult =  dataresult + " " + newnode.data_.toString();
            newnode = newnode.next_;

    // Updating the node to the next node
        }
        return dataresult;       // Return the string representation of the list
    }

    public static void main(String[] args) {

        List<LinkedNode<String>> myArrayList = new ArrayList<>();// Initializing an array list of nodes with string values
        myArrayList.add(new LinkedNode<String>("Buy sweets,", myArrayList.get(0)));
        myArrayList.add(new LinkedNode<String>("Visit Sibel,", myArrayList.get(1)));
        myArrayList.add(new LinkedNode<String>("Do AuD exercises,", myArrayList.get(2)));
        myArrayList.add(new LinkedNode<String>("go to the cafeteria,", myArrayList.get(3)));
        myArrayList.add(new LinkedNode<String>("Attend AUD lecture,", myArrayList.get(4)));
        myArrayList.get(2).setNext(myArrayList.get(5));
        System.out.println(myArrayList.get(2));
    }
}