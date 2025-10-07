
  // Dana Sader

public class HappyNumbers {

    public static boolean isHappy(int n) {

        if (n == 1)
            return true;
        if (n == 4)
            return false;

        return isHappy(n);
    }
    
    public static int nextHappyNumber(int n) {

        int x;  // x is the remainder when the number is divided by 10
        int sum = 0;

        // the sum of the squares of the numbers is calculated
        while(n > 0){

            x = n % 10;
            sum = sum + (x * x);
            n = n / 10;
        }
        return sum;
    }
    
    public static void main(String[] args) {

        int Number  = 11;  /* 11 is not a happy number because the sum is 1^2 + 1^2 = 2 and 2^2 = 4.
	Because 4 is the result for the sum of the squares, it means that 11 is not a happy number.
 */
        int result = Number ;
        while(result != 1 && result != 4){
            result = nextHappyNumber(result);
        }

        // If the result is 1, a happy number is displayed
        if (result == 1)
            System.out.println(Number + " is a happy number");

            // If the result is 4, a sad number is displayed
        else if (result == 4)
            System.out.println(Number + " is not a happy number");
    }
}