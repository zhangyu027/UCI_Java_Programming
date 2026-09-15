package instructor.inclass.m5;

/** Recursive Java program to check if a given string is a palindrome. */
public class Palindrome {

    public static boolean isPalindrome(String str, int start, int end) {
        // Base case: all characters have matched
        if (start >= end) {
            return true;
        }

        // Recursive case: outside characters must match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String testStr = "racecar";

        if (isPalindrome(testStr, 0, testStr.length() - 1)) {
            System.out.println(testStr + " is a palindrome.");
        } else {
            System.out.println(testStr + " is not a palindrome.");
        }
    }
}
