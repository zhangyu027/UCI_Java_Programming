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
import java.util.Scanner;

/** M3B: Calculator + exception-control driver. */
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try (Scanner scanner = new Scanner(System.in)) {
            // TODO: Prompt for two numbers and an operator.
            // TODO: Call the correct Calculator method.
            // TODO: Catch ArithmeticException and both custom exceptions.
            /*
            * HINT:
            * try {
            *     // call calculator method
            * } catch (ArithmeticException e) {
            *     ...
            * } catch (NegativeNumberException | OutOfRangeException e) {
            *     ...
            * }
            */
            System.out.println("M3 Exception Control starter ready.");
        }
    }
}
