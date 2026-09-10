package inclass.m5;

/*
* IN-CLASS STUDENT HINTS - RECURSION
* ----------------------------------
* Write the base case first.
* Then make the recursive call solve a smaller input.
* Trace a small example by hand before testing a larger one.
*/
/** Module 5 recursion practice: b^e for a non-negative exponent. */
public class Power {
    static long power(long base, int exponent) {
        // TODO: Implement recursively.
        /*
        * HINT:
        * power(base, 0) = 1
        * power(base, exponent) = base * power(base, exponent - 1)
        */
        return 0;
    }
    public static void main(String[] args) {
        System.out.println("TODO: test recursive power.");
    }
}
