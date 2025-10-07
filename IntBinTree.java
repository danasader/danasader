
  // Dana Sader

import aud.BinaryTree;
import aud.util.DotViewer;
import aud.util.SingleStepper;

public class IntBinTree extends BinaryTree<Integer> {

    public IntBinTree(int data) {
        super(data);
    }

    public IntBinTree(int data, IntBinTree left, IntBinTree right) {
        super(data, left, right);
    }

    public int height() {

        // return the height of the current (sub-)tree
        if (getRoot() == null)
            return 0;
        else {
            // height starting from left or right subtree
            BinaryTree<Integer> Heightleft = getRoot().getLeft();
            BinaryTree<Integer> Heightright = getRoot().getRight();
            if (Heightleft.getData() > Heightright.getData()) {
                return (Heightleft.getData() + 1);
            }
            else
                return (Heightright.getData() + 1);
        }
    }
    public int maxSum() {
        // return bigger sum of the left/right subtree
        int x = 0;
        if (getRoot() == null) {
            return 0;
        }
        if (getRoot().getLeft() == null && getRoot().getRight() == null) {
            return getRoot().getData();
        }
        // get the sum values of the nodes for the left subtree
        int lsum = getRoot().getLeft().getData();
        // get the sum values of the nodes for the right subtree
        int rsum = getRoot().getRight().getData();
        // sum of the left and right subtrees from the root value
        int RootSum = lsum + rsum + getRoot().getData();
        // maximum value from the left and right sum values of the nodes of the left and right subtrees
        int value = Math.max(lsum, rsum);
        value = Math.max(value, RootSum);
        // store the maximum sum from the left and right subtrees
        x = Math.max(x, value);
        return value;
    }

    public int maxPath () {

        // return the maximum sum of all possible paths
        int Value ;
        if (getRoot() == null)
            return 0;
        // store the starting value from Left Child Node or Right Child Node
        int leftPath = getRoot().getLeft().getData();
        int rightPath = getRoot().getRight().getData();
        // check the maximum path for the right part of the binary tree
        int maxPath1 = Math.max(Math.max(leftPath, rightPath),getRoot().getRight().getData());
        // check the maximum path for the left part of the binary tree
        int  maxPath2 = Math.max(Math.max(leftPath, rightPath),getRoot().getLeft().getData());
        // Store the maximum path
        Value = Math.max(maxPath1, maxPath2);
        return Value;
    }

    public static void main (String[]args){

        BinaryTree<Integer> m = new BinaryTree<Integer>(50); // m is the root
        DotViewer Result = DotViewer.displayWindow(m, "Baum");
        SingleStepper singlestepper=new SingleStepper("Window");
        singlestepper.halt("1");
        BinaryTree<Integer> a = new BinaryTree<Integer>(40);
        BinaryTree<Integer> b = new BinaryTree<Integer>(60);
        BinaryTree<Integer> c = new BinaryTree<Integer>(30);
        BinaryTree<Integer> d = new BinaryTree<Integer>(70);
        BinaryTree<Integer> e = new BinaryTree<Integer>(80);
        BinaryTree<Integer> f = new BinaryTree<Integer>(55);

        m.setLeft(a);
        Result.display(a);
        singlestepper.halt("2");

        m.setRight(b);
        Result.display(b);
        singlestepper.halt("3");

        a.setLeft(c);
        Result.display(c);
        singlestepper.halt("4");

        b.setRight(d);
        Result.display(d);
        singlestepper.halt("5");

        d.setRight(e);
        Result.display(e);
        singlestepper.halt("6");

        b.setLeft(f);
        Result.display(f);
        singlestepper.halt("7");

        Result.setExitOnClose();
        System.exit(0);
    }
}
