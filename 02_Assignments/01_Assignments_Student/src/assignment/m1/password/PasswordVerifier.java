package assignment.m1.password;

/*
 * STUDENT HINTS
 * -------------
 * This starter follows the Canvas Password Verifier structure.
 * Required password checks:
 * - at least 8 characters
 * - at least one uppercase letter
 * - at least one lowercase letter
 * - at least one digit
 *
 * Complete the TODO sections. Do not replace the whole program.
 */

import java.util.Scanner;

/** Module 1 Assignment: Password Verifier student starter. */
public class PasswordVerifier {

    public static boolean isValidPassword(String password) {

        // TODO 1: Check whether the password has at least 8 characters.
        // If it does not, print the Canvas-style message and return false.

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;

        // TODO 2: Loop through password.toCharArray().
        // TODO 3: Use Character.isUpperCase(ch), isLowerCase(ch), and isDigit(ch)
        //         to update the three boolean flags above.

        /*
         * HINT:
         * for (char ch : password.toCharArray()) {
         *     if (Character.isUpperCase(ch)) {
         *         // update hasUpperCase
         *     }
         *     // repeat for lowercase and digit
         * }
         */

        // TODO 4: Print a helpful message for each missing requirement.

        // TODO 5: Replace this temporary return with an expression that is true
        // only when uppercase, lowercase, and digit requirements are all met.
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Password Verifier!");
        System.out.print("Please enter a password to verify: ");
        String password = scanner.nextLine();

        // TODO 6: Call isValidPassword(password) and print either
        // "The password is valid." or "The password is invalid."

        scanner.close();
    }
}
