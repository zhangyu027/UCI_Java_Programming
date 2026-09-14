package instructor.inclass.m3.exceptions;

/** Canvas Example 3: Multiple Exceptions. */
public class MultipleExceptionsExample {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception occurred: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception occurred: " + e.getMessage());
        }
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return dividend / divisor;
    }
}
