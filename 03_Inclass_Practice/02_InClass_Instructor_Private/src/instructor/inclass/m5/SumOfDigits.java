package instructor.inclass.m5;

/**
 * Recursive Java program to calculate the sum of digits in a given number.
 */
public class SumOfDigits {

    /**
     * Recursive method to calculate the sum of digits.
     *
     * @param n The input number.
     * @return The sum of digits.
     */
    public static int sumOfDigits(int n) {
        // Base case: if the number is 0, the sum of digits is 0
        if (n == 0) {
            return 0;
        }

        // Recursive case: sum the last digit and recurse on the remaining digits
        return (n % 10) + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {
        // Input: a number to calculate the sum of digits
        int number = 1234;

        // Output: print the sum of digits
        System.out.println("The sum of digits of " + number + " is: " + sumOfDigits(number));
    }
}
