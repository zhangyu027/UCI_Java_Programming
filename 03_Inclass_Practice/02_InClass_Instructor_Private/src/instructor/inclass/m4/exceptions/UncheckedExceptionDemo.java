package instructor.inclass.m4.exceptions;

/** Demonstrates an unchecked ArithmeticException. */
public class UncheckedExceptionDemo {
    public static void main(String[] args) {
        try {
            int value = 10 / 0;
            System.out.println(value);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }
    }
}
