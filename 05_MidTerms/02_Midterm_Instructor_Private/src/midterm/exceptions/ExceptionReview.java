package midterm.exceptions;

public class ExceptionReview {
    public static void main(String[]a) {
        try {
            int x=5/0;
        } catch (ArithmeticException e) {
            System.out.println("Error: "+e.getMessage());
        } finally {
            System.out.println("finally runs");
        }
    }
}
