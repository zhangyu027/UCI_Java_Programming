package instructor.assignments.m1.password;

import java.util.Scanner;

/** Module 1 Assignment: Password Verifier instructor reference solution. */
public class PasswordVerifier {

    // Method to verify if the password meets all required criteria.
    public static boolean isValidPassword(String password) {

        // Check if the password is at least 8 characters long.
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        // Initialize flags for the required criteria.
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;

        // Iterate over each character in the password.
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            }
            if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        // Report any criteria that are not met.
        if (!hasUpperCase) {
            System.out.println("Password must contain at least one uppercase letter.");
        }
        if (!hasLowerCase) {
            System.out.println("Password must contain at least one lowercase letter.");
        }
        if (!hasDigit) {
            System.out.println("Password must contain at least one digit.");
        }

        // The password is valid only if all criteria are met.
        return hasUpperCase && hasLowerCase && hasDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Password Verifier!");
        System.out.print("Please enter a password to verify: ");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("The password is valid.");
        } else {
            System.out.println("The password is invalid.");
        }

        scanner.close();
    }
}
