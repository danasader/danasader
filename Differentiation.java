
// Dana Sader

import aud.BinaryTree;
import aud.example.expr.Number;
import aud.example.expr.*;
import aud.util.Graphviz;

public class Differentiation {

    public static ExpressionTree differentiate(BinaryTree<AtomicExpression> t, String var) {

        // calculate the differentiation for the sum
        if (t.getData().getType() == AtomicExpression.Type.OpPlus) {
            t.setData(new Plus());
            if (differentiate1(t.getLeft(), var)) {
                t.setLeft(differentiate(t.getLeft(), var));
                t.setLeft(new BinaryTree<>(new Number(0)));
            }
            if (differentiate1(t.getRight(), var)) {
                t.setRight(differentiate(t.getRight(), var));
                t.setRight(new BinaryTree<>(new Number(1)));
            }
        }

        // calculate the differentiation for the product
        if (t.getData().getType() == AtomicExpression.Type.OpTimes) {
            t.setLeft(new BinaryTree<>(new Times(), differentiate(t.getLeft(), var), t.getRight()));
            t.setRight(new BinaryTree<>(new Times(), differentiate(t.getRight(), var), t.getLeft()));
            t.setData(new Plus());
        }

        // get the Symbols x and y

        if (t.getData().getType() == AtomicExpression.Type.TSymbol) {
            if (t.getData().toString().equals(var)) {
                t.setLeft(new BinaryTree<>(new Symbol("x")));
                t.setRight(new BinaryTree<>(new Symbol("y")));
            }
            return null;
        }

        if (t.getData().getType() == AtomicExpression.Type.TNumber) {
            if (t.getLeft().getData().getValue()==0)
                t.setLeft(differentiate(t.getLeft(), var));
            if (t.getRight().getData().getValue()==1)
                t.setRight(differentiate(t.getRight(), var));
        }
        return null;
    }

    /* this method checks if the value in the root node is equal to a String and
    if it is true then the value in the left child node or the right child node (from the root)
    of the binary tree will be differentiated */

    public static boolean differentiate1 (BinaryTree < AtomicExpression > t, String var){

        if (t.getRoot().toString().equals(var)) {
            return differentiate1(t.getLeft(), var) || differentiate1(t.getRight(), var);
        }
        return false;
    }

    public static void main (String[]args){

        ExpressionTree Tree = new ExpressionTree(new Plus(), new ExpressionTree(new Symbol("x"))
                ,new ExpressionTree(new Times(), new ExpressionTree(new Symbol("x")),
                new ExpressionTree(new Symbol("y"))));
        System.out.println("MyTree:" + Tree);
        Graphviz viewer= new Graphviz();
        viewer.display(differentiate(Tree, "x"));
    }
}
