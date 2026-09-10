package assignment.m1.password;

/*
* STUDENT HINTS
* -------------
* Required password checks:
* - at least 8 characters
* - at least one uppercase letter
* - at least one lowercase letter
* - at least one digit
*
* Suggested approach:
* Loop through password.toCharArray() and update boolean flags.
* Useful methods: Character.isUpperCase(), isLowerCase(), isDigit().
*/
import java.util.Scanner;

/** M1 Assignment: Password Verifier starter. */
public class PasswordVerifier {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a password: ");
            String password = scanner.nextLine();
            boolean hasMinLength = false;
            boolean hasUppercase = false;
            boolean hasLowercase = false;
            boolean hasDigit = false;
            // TODO 1: Check password.length() >= 8.
            // TODO 2: Loop through the password characters.
            // TODO 3: Update the uppercase/lowercase/digit flags.
            // TODO 4: Print whether the password is valid.
            /*
            * HINT:
            * Character.isUpperCase(ch)
            * Character.isLowerCase(ch)
            * Character.isDigit(ch)
            *
            * ANSWER CHECKPOINT:
            * A password is valid only when ALL four boolean conditions are true.
            */
            System.out.println("Minimum length met: " + hasMinLength);
            System.out.println("Uppercase found: " + hasUppercase);
            System.out.println("Lowercase found: " + hasLowercase);
            System.out.println("Digit found: " + hasDigit);
        }
    }
}
