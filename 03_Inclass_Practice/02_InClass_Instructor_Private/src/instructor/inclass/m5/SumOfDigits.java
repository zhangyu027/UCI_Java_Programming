package instructor.inclass.m5;

public class SumOfDigits {
    public static int sumOfDigits(int n) {
        n=Math.abs(n);
        return n<10?n:n%10+sumOfDigits(n/10);
    }
    public static void main(String[]a) {
        System.out.println("Sum of digits of 12345 = "+sumOfDigits(12345));
    }
}
