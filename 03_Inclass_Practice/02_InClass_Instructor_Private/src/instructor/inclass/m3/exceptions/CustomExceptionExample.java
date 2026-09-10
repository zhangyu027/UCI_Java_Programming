package instructor.inclass.m3.exceptions;

class AgeException extends Exception {
    AgeException(String m) {
        super(m);
    }
}
public class CustomExceptionExample {
    static void validate(int age)throws AgeException {
        if (age<0||age>130)throw new AgeException("Age must be between 0 and 130.");
    }
    public static void main(String[] args) {
        try {
            validate(150);
        } catch (AgeException e) {
            System.out.println("Handled custom exception: "+e.getMessage());
        }
    }
}
