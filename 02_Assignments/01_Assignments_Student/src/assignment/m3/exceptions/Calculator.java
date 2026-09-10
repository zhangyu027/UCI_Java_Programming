package assignment.m3.exceptions;

/*
* STUDENT HINTS
* -------------
* Calculator supports add, subtract, multiply, and divide.
* Exception flow to practice:
* - ArithmeticException for divide-by-zero behavior.
* - NegativeNumberException for disallowed negative input.
* - OutOfRangeException for values outside the required range.
*
* CHECKPOINT:
* Throw exceptions where invalid data is detected; catch them where the program
* can communicate a useful message to the user.
*/
/** M3B calculator logic starter. */
public class Calculator {
    private void validate(double a, double b)
    throws NegativeNumberException, OutOfRangeException {
        // TODO: Define the rules required by your assignment.
        // TODO: Throw NegativeNumberException when appropriate.
        // TODO: Throw OutOfRangeException when appropriate.
        /*
        * HINT:
        * if (a < 0 || b < 0) {
        *     throw new NegativeNumberException("...");
        * }
        */
    }
    public double add(double a, double b)
    throws NegativeNumberException, OutOfRangeException {
        validate(a, b);
        // TODO
        return 0.0;
    }
    public double subtract(double a, double b)
    throws NegativeNumberException, OutOfRangeException {
        validate(a, b);
        // TODO
        return 0.0;
    }
    public double multiply(double a, double b)
    throws NegativeNumberException, OutOfRangeException {
        validate(a, b);
        // TODO
        return 0.0;
    }
    public double divide(double a, double b)
    throws NegativeNumberException, OutOfRangeException {
        validate(a, b);
        // TODO: Throw ArithmeticException when b == 0.
        // TODO: Return a / b when valid.
        return 0.0;
    }
}
