package instructor.assignments.m3.exceptions;

import java.util.*;

public class Main {
    public static void main(String[] a) {
        try(Scanner sc=new Scanner(System.in)) {
            try {
                System.out.print("First number: ");
                double x=sc.nextDouble();
                System.out.print("Operator(+, -, *, /): ");
                char op=sc.next().charAt(0);
                System.out.print("Second number: ");
                double y=sc.nextDouble();
                System.out.println("Result="+new Calculator().calculate(x, y, op));
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid numeric input.");
            } catch (NegativeNumberException|OutOfRangeException|ArithmeticException|IllegalArgumentException e) {
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
}
