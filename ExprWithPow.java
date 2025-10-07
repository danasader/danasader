
// Dana Sader

import aud.example.expr.*;

public class ExprWithPow extends ExpressionParser2 {
    
    // Sum Method to calculate the Addition and Subtraction for numbers in a String 

   /* public ExpressionTree sum(int level) {

        ExpressionTree left = this.product(level + 1);
        ExpressionTree right;

        if (lookahead() == Tokenizer.PLUS) {
            nextToken();
            right = sum(level + 1);
            return new ExpressionTree(new Plus(), left, right);
        }
        if (lookahead() == Tokenizer.MINUS) {
            nextToken();
            right = sum(level + 1);
            return new ExpressionTree(new Minus(), left, right);
        }
            return left;
        }

*/
    // Product Method to calculate the Division and Multiplication for numbers in a String

    public ExpressionTree product(int level) {

        ExpressionTree left = this.pow(level + 1);
        ExpressionTree right;

        if (lookahead() == Tokenizer.DIVIDE) {
            nextToken();
            right = product(level + 1);
            return new ExpressionTree(new Divide(), left, right);
        }
        if (lookahead() == Tokenizer.TIMES) {
            nextToken();
            right = product(level + 1);
            return new ExpressionTree(new Times(), left, right);
        }
        return left;
    }
    
    public ExpressionTree pow(int level) {  // Pow Method to calculate the number with an exponent

        ExpressionTree left = this.factor(level + 1);
        ExpressionTree right;

        if (lookahead() == Tokenizer.POWER) {
            nextToken();
            right=this.pow(level + 1);
            return new ExpressionTree(new Power(), left, right);
        }
        return left;
    }

    public static void main(String[] args) {

        // Test Outputs with addition, division, multiplication and subtraction

        ExprWithPow Test = new ExprWithPow();
        System.out.println();
        System.out.println("Result:"+" "+Test.parse("(2**2)+(3^3)").getValue());
        System.out.println("Result:"+" "+Test.parse("(2^2)+(3**3)").getValue());
        System.out.println("Result:"+" "+Test.parse("(2^2)+(3^3)").getValue());
        System.out.println("Result:"+" "+Test.parse("(2**2)+(3**3)").getValue());
        System.out.println("Result:"+" "+Test.parse("(2^2)/(3^3)").getValue());
        System.out.println("Result:"+" "+Test.parse("(2^2)*(3^3)").getValue());
        System.out.println("Result:"+" "+Test.parse("(2^2)-(3^3)").getValue());
    }
}
