package instructor.inclass.m3.exceptions;

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

/** Canvas Example 2: Custom Exception. */
public class CustomExceptionExample {
    public static void main(String[] args) {
        try {
            validateAge(15);
        } catch (CustomException e) {
            System.out.println("Custom exception occurred: " + e.getMessage());
        }
    }

    public static void validateAge(int age) throws CustomException {
        if (age < 18) {
            throw new CustomException("Age must be at least 18.");
        } else {
            System.out.println("Age is valid.");
        }
    }
}
