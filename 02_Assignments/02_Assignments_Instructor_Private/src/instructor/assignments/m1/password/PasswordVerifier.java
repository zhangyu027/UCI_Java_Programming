package instructor.assignments.m1.password;

import java.util.Scanner;

public class PasswordVerifier {
    public static boolean isValid(String password) {
        if (password == null || password.length() < 8) return false;
        boolean upper=false, lower=false, digit=false;
        for (char c: password.toCharArray()) {
            upper |= Character.isUpperCase(c);
            lower |= Character.isLowerCase(c);
            digit |= Character.isDigit(c);
        }
        return upper && lower && digit;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a password: ");
            String p = sc.nextLine();
            System.out.println(isValid(p) ? "Valid password." : "Invalid password. Use 8+ chars with uppercase, lowercase, and a digit.");
        }
    }
}
