package inclass.m4.exceptions;

class NegativeNumberException extends Exception {
    private static final long serialVersionUID = 1L;
    NegativeNumberException(String message) {
        super(message);
    }
}
/** Demonstrates a custom checked exception. */
public class CustomExceptionDemo {
    static void validate(int number) throws NegativeNumberException {
        if (number <= 0) {
            throw new NegativeNumberException(
            "Number must be positive.");
        }
    }
    public static void main(String[] args) {
        try {
            validate(-3);
        } catch (NegativeNumberException e) {
            System.out.println("Handled: " + e.getMessage());
        }
    }
}
