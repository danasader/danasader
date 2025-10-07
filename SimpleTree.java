
  // Dana Sader 

public class SimpleTree<T extends Comparable<T>> {

    public class Node {

        Node left ;
        Node right ;
        T key;

        Node(T obj) {
            key = obj;
            left = null;
            right = null;
        }
    }
    private Node root_;
    public SimpleTree() {
    }

    // Inorder Traversal
    public String Inorder (Node root_) {

        if (root_ != null) {
            String left = Inorder(root_.left);
            String curr= root_.key + " ";
            String right=Inorder(root_.right);
            return left+curr+right;
        }
        return "";
    }
    public void add(T obj) {
        root_ = addRecursion(root_, obj);
    }

/* a method to compare the key value to the value of the root if the key value is smaller than the value
 of the root then the key value will be added to the left child node of the root.
  In addition, if the key value is greater than the value of the root then the key value
   will be added to the right child node of the root.
   */

    public Node addRecursion(Node root_,T obj) {

        if (root_ == null) {
            root_ = new Node(obj);
        }
        if (obj.compareTo(root_.key)<0) {
            root_.left = addRecursion(root_.left, obj);
        }
        if (obj.compareTo(root_.key)>0) {
            root_.right = addRecursion(root_.right, obj);
        }
        return root_;
    }

    public boolean contains(T obj) {
        return containsRecursion(root_, obj);
    }

    /* a boolean method to check if the key value is smaller than the value
     of the root it means that the key value exists in the left child node from the root in the binary tree.
     In addition, if the key value is greater than the value of the root it means the key value exists
     in the right child node from the root in the binary tree. */

    public boolean containsRecursion(Node root_, T obj) {

        if (root_ == null) {
            return false;
        }
        if (root_.key == obj) {
            return true;
        }
        if (obj.compareTo(root_.key) < 0) {
            return containsRecursion(root_.left, obj);
        } else {
            return containsRecursion(root_.right, obj);
        }
    }

    public String toString() {
        return Inorder(root_);
    }

    public static void main(String[] args) {
        
        SimpleTree<Integer> Tree = new SimpleTree<>();
        Tree.add(2);
        Tree.add(3);
        Tree.add(4);
        Tree.add(6);
        Tree.add(8);
        Tree.add(19);
        System.out.println("\n");
        System.out.println(Tree.contains(100));
        System.out.println(Tree.contains(2));
        System.out.println(Tree.contains(3));
        System.out.println(Tree.Inorder(Tree.root_));
    }
}
