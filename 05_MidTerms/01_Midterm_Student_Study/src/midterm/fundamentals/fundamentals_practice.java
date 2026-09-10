package midterm.fundamentals;

public class fundamentals_practice{
    public static void main(String[] args) {
        int x = 5;
        System.out.println(++x);
        int[] arr = new int[10];
        System.out.println(
                "int bits=" + Integer.SIZE
                + ", array length=" + arr.length);
        String s1 = "Hello";
        String s2 =new String("Hello");
        System.out.println(
                "s1=s2: " + (s1 == s2));
        System.out.println(
                "s1.equals(s2): " + s1.equals(s2));
    }
}