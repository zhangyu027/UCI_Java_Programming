package assignments.m3.exceptions;

public class Calculator {
    private void validate(double a, double b) throws NegativeNumberException, OutOfRangeException {
        // TODO: Validate inputs and throw required custom exceptions.
    }
    public double add(double a, double b) throws NegativeNumberException, OutOfRangeException { validate(a,b); return 0.0; }
    public double subtract(double a, double b) throws NegativeNumberException, OutOfRangeException { validate(a,b); return 0.0; }
    public double multiply(double a, double b) throws NegativeNumberException, OutOfRangeException { validate(a,b); return 0.0; }
    public double divide(double a, double b) throws NegativeNumberException, OutOfRangeException { validate(a,b); /* TODO: handle divide by zero and return a/b. */ return 0.0; }
}
