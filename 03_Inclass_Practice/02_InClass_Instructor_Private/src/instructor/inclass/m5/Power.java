package instructor.inclass.m5;

public class Power {
    public static long power(int base, int exponent) {
        if (exponent<0)throw new IllegalArgumentException("Exponent must be non-negative");
        return exponent==0?1:base*power(base, exponent-1);
    }
    public static void main(String[]a) {
        System.out.println("2^10 = "+power(2, 10));
    }
}
