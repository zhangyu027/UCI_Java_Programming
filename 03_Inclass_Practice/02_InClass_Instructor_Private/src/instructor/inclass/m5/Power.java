package instructor.inclass.m5;

/** Recursive Java program to calculate the power of a given base and exponent. */
public class Power {

    public static int power(int base, int exponent) {
        // Base case: any number raised to the power 0 is 1
        if (exponent == 0) {
            return 1;
        }

        // Recursive case
        return base * power(base, exponent - 1);
    }

    public static void main(String[] args) {
        int base = 2;
        int exponent = 4;

        System.out.println(base + " raised to the power of " + exponent + " is: " + power(base, exponent));
    }
}
