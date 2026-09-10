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
/** Custom checked exception for the M3B calculator assignment. */
public class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}
