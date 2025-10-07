
// Dana Sader

import aud.BinaryTree;
import aud.Queue;
import aud.util.DotViewer;

//------------------------------------------------------------------//
public class MyBinTree<T> extends BinaryTree<T> {
    //----------------------------------------------------------------//
    public MyBinTree(T data) {
        super(data);
    }

    //----------------------------------------------------------------//
    public MyBinTree(T data, MyBinTree<T> left, MyBinTree<T> right) {
        super(data, left, right);
    }

    //----------------------------------------------------------------//
    public int maxWidth() {

        // returns the maximum width of the binary tree
        if (getRoot() == null)
            return 0;
        
        // result variable to calculate the maximum width
        int result = 0;
        
        // check the number of nodes at every level using Queue with level order traversal
        Queue<BinaryTree<Integer>> q = new Queue<>();
        q.enqueue((BinaryTree<Integer>) getRoot()); // add root from BinaryTree Class to the queue

        while (!q.is_empty()) {

            // Variable count starts with one Root Node in the Queue
            int node = 1;
            
            // Iterate through all the nodes in the queue and add the left and right child nodes
            while (node > 0) {
                BinaryTree<Integer> z=  q.dequeue(); // remove a node from the queue then add the left and right child nodes
                if (z != null) {

                    q.enqueue(z.getLeft());
                    q.enqueue(z.getRight());
                }
                result = Math.max(result, node);
                node--;
            }
        }
        return result;
    }
    //---------------------------------------------------------------//

    public static void main(String[] args) {
        BinaryTree<Integer> m = new BinaryTree<Integer>(50); // m is the root
        BinaryTree<Integer> a = new BinaryTree<Integer>(40);
        BinaryTree<Integer> b = new BinaryTree<Integer>(60);
        BinaryTree<Integer> c = new BinaryTree<Integer>(30);
        BinaryTree<Integer> d = new BinaryTree<Integer>(70);
        BinaryTree<Integer> e = new BinaryTree<Integer>(80);
        BinaryTree<Integer> f = new BinaryTree<Integer>(55);
        m.setLeft(a);
        m.setRight(b);
        a.setLeft(c);
        b.setRight(d);
        d.setRight(e);
        b.setLeft(f);
        BinaryTree<Integer> Tree = new BinaryTree<>(58);
        DotViewer Picture= DotViewer.displayWindow(m, "Tree");
        Picture.setExitOnClose();
    }
}