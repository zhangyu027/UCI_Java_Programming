package midterm.fundamentals;

import java.util.*;

public class FundamentalsReview {
    public static void main(String[] a) {
        int x=5;
        System.out.println(++x);
        int[] arr=new int[10];
        System.out.println("int bits="+Integer.SIZE+", array length="+arr.length);
        String s1="Hello", s2=new String("Hello");
        System.out.println("s1==s2: "+(s1==s2));
    }
}
