package midterm.fundamentals;
/*
* STUDENT STUDY GUIDE
* -------------------
* Review variables, conditionals, loops, arrays, and method calls. Trace each statement by hand before running it.
*
* CHECKPOINT:
* Be able to explain the key Java concept without reading the code line-by-line.
*/

public class FundamentalsReview {

    public static void main(String[] args) {

        int x = 5;

        System.out.println(++x);

        int[] arr = new int[10];

        System.out.println(
                "int bits=" + Integer.SIZE
                + ", array length=" + arr.length);

        String s1 = "Hello";
        String s2 = new String("Hello");

        System.out.println(
                "s1==s2: " + (s1 == s2));

        System.out.println(
                "s1.equals(s2): " + s1.equals(s2));
    }
}

