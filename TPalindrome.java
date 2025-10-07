
   // Dana Sader and Isabell Karakas

import aud.Stack;

public class TPalindrome {

    // Method for checking whether a string is a T-palindrome
    public static boolean isTPalindrome(String text) {

        int bracketchecker = 0;
        // Loop to check the number of brackets
        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == '(') {
                bracketchecker++;
            }
            if (text.charAt(i) == ')') {
                bracketchecker--;
            }
        }

        // If the number of brackets is not 0, the string is not a T-palindrome
        if (bracketchecker != 0) {
            return false;
        }

        // Return the result of the myPalindromeHelp method
        return myPalindromeHelp(text);
    }

    // Method for checking whether a string is a palindrome
    public static boolean myPalindromeHelp(String text) {

        int openedbracket = -1;
        int closedbracket = -1;
        boolean checker = true;
        boolean checkopen = false;

        // Creating a new stack
        Stack<Character> Stacki = new Stack<>();
        // Loop to loop through the string
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '(') {
                openedbracket = i;
                checkopen = true;
            } else if (text.charAt(i) == ')') {
                closedbracket = i;
                break;
            }

            /* If the first opening parenthesis is found and the character is not an opening parenthesis,
the character is placed on the stack*/
            if (checkopen) {
                if (text.charAt(i) != '(') {
                    Stacki.push(text.charAt(i));
                }
            }
        }

        // If no opening bracket is found, the string is reversed and placed on the stack
        if (openedbracket == -1) {
            checker = false;
            openedbracket = -1;
            closedbracket = text.length() - 1;
            for (int i = 0; i < text.length(); i++) {
                Stacki.push(text.charAt(i));
            }
        }

        // Loop to check if it is a T-palindrome
        for (int i = openedbracket + 1; i < closedbracket; i++) {
            if (text.charAt(i) != Stacki.pop()) {
                return false;
            }
        }

        // If no T-palindrome is found, the text is modified and the method is called recursively
        if (!checker) {
            return true;
        }

        StringBuilder textnew = new StringBuilder();   // Initialize an empty string textnew
        for (int i = 0; i < text.length(); i++) {     // Iterate over all characters of the text
            if (i == openedbracket) {                 // If the index is equal to open bracket
                textnew.append("*");              // add an asterisk to the string textnew
            }

            // If the index is between open bracket and closed bracket, do nothing
            else if (i >= openedbracket && i <= closedbracket) {
            }
            else {

    /* If the index is neither equal to open bracket nor between open bracket and
    closed bracket, add the current character to the string textnew
     */
                textnew.append(text.charAt(i));
            }
        }

        // call the method myPalindromeHelp recursively with the new string
        return myPalindromeHelp(textnew.toString());
    }
    
    public static void main(String[] args) {
        System.out.println(isTPalindrome("otto"));                      // expected true
        System.out.println(isTPalindrome("al(otto)la"));                // expected true
        System.out.println(isTPalindrome("abc(aha)(u)cba"));            // expected true
        System.out.println(isTPalindrome("abc(ah(otto)v(atta)ha)cba")); // expected true
        System.out.println(isTPalindrome("abc"));                       // expected false
        System.out.println(isTPalindrome("a(b)cca(b)"));                // expected false
        System.out.println(isTPalindrome("abc(ah(otto)h)cba"));         // expected false
        System.out.println(isTPalindrome("abc(lu(lala)l)cba"));         // expected false
    }
}