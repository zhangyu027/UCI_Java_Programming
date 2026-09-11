package midterm.exceptions;

/*
 * STUDENT STUDY GUIDE
 * -------------------
 * Trace the try/catch/finally flow.
 *
 * Think about:
 * 1. Which statement throws the exception?
 * 2. Which catch block handles it?
 * 3. Does the finally block still execute?
 *
 * CHECKPOINT:
 * Be able to explain why ArithmeticException occurs.
 */
public class ExceptionReview {

    public static void main(String[] args) {

        int numerator = 5;
        int denominator = 0;

        try {

            // TODO:
            // Divide numerator by denominator.
            //
            // HINT:
            // int result = __________;

        } catch (ArithmeticException e) {

            // TODO:
            // Print an error message.

        } finally {

            // TODO:
            // Print a message proving finally executes.
        }
    }
}
