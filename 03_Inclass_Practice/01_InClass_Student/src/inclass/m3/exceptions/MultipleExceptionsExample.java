package inclass.m3.exceptions;

/** Canvas Example 3 student starter: Multiple Exceptions. */
public class MultipleExceptionsExample {
    public static void main(String[] args) {
        try {
            // TODO 1: Call divide(10, 0) and print the result.
        } catch (ArithmeticException e) {
            // TODO 2: Handle ArithmeticException.
        } catch (NullPointerException e) {
            // TODO 3: Handle NullPointerException.
        }
    }

    public static int divide(int dividend, int divisor) {
        // TODO 4: Throw ArithmeticException("Division by zero") when divisor is zero.
        // TODO 5: Otherwise return the division result.
        return 0;
    }
}
