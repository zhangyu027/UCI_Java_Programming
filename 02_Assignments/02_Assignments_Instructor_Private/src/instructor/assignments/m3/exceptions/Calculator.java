package instructor.assignments.m3.exceptions;

public class Calculator {
    private void validate(double a, double b) throws NegativeNumberException, OutOfRangeException {
        if (a<0||b<0)throw new NegativeNumberException("Numbers must be non-negative.");
        if (a>1000000||b>1000000)throw new OutOfRangeException("Number is outside the supported range.");
    }
    public double calculate(double a, double b, char op) throws NegativeNumberException, OutOfRangeException {
        validate(a, b);
        return switch (op) {
            case '+'->a+b;
            case '-'->a-b;
            case '*'->a*b;
            case '/'-> {
                if (b==0)throw new ArithmeticException("Division by zero");
                yield a/b;
            }
            default->throw new IllegalArgumentException("Unknown operator");
        };
    }
}
