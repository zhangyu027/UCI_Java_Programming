package inclass.m3.exceptions;

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

/** Canvas Example 2 student starter: Custom Exception. */
public class CustomExceptionExample {
    public static void main(String[] args) {
        try {
            validateAge(15);
        } catch (CustomException e) {
            // TODO 1: Print a meaningful custom-exception message.
        }
    }

    public static void validateAge(int age) throws CustomException {
        // TODO 2: If age is below 18, throw CustomException.
        // TODO 3: Otherwise print that the age is valid.
    }
}
