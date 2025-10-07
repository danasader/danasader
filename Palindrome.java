
   // Isabell Karakas and Dana Sader 

import java.util.Stack;

public class Palindrome {

    public static boolean isPalindrome(String text) {

        // remove all spaces, special characters and punctuation from text and convert it to lowercase
        String currentText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // initialize empty stack here
        Stack<Character> stack = new Stack<>();

        // insert the first characters into the stack
        for (int i = 0; i < currentText.length() / 2; i++) {
            stack.push(currentText.charAt(i));
        }

        // check whether the remaining characters of the string match the characters in the stack
        for (int i = (currentText.length() + 1) / 2; i < currentText.length(); i++) {
            if (currentText.charAt(i) != stack.pop()) {
                return false;
            }
        }

        // if all characters match, then the string is a palindrome
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("SiBeL and DANA"));                     // expected false
        System.out.println(isPalindrome("A man, a plan, a canal, Panama!"));    // expected true
        System.out.println(isPalindrome("Was it a car or a cat I saw?"));       // expected true
        System.out.println(isPalindrome("Moi, je suis Isabell!"));              // expected false
        System.out.println(isPalindrome("Reliefpfeiler"));                      // expected true
    }
}
