package assignments.m1.password;

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
 * Complete the TODO sections instead of replacing the whole program.
 */

import java.util.Scanner;

/** Module 1 Assignment: Password Verifier student starter. */
public class PasswordVerifier {

    public static boolean isValidPassword(String password) {

        // TODO 1: Check whether the password has at least 8 characters.
        // If not, print the same kind of message shown in the Canvas example
        // and return false.

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;

        // TODO 2: Loop through password.toCharArray().
        // TODO 3: Use Character.isUpperCase(ch), isLowerCase(ch), and isDigit(ch)
        // to update the three boolean flags.

        // TODO 4: Print a helpful message for each missing criterion.

        // TODO 5: Replace this temporary return value.
        // The password is valid only when all three flags are true.
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Password Verifier!");
        System.out.print("Please enter a password to verify: ");
        String password = scanner.nextLine();

        // TODO 6: Call isValidPassword(password) and print whether the
        // password is valid or invalid.

        /*
         * HINT:
         * if (isValidPassword(password)) {
         *     // print valid message
         * } else {
         *     // print invalid message
         * }
         */

        scanner.close();
    }
}
