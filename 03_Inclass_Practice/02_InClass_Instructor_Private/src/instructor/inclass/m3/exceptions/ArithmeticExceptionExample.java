package instructor.inclass.m3.exceptions;

public class ArithmeticExceptionExample {
    public static void main(String[] args) {
        try {
            System.out.println(10/0);
        } catch (ArithmeticException e) {
            System.out.println("Handled ArithmeticException: division by zero");
        } finally {
            System.out.println("Arithmetic example finished.");
        }
    }
}
