package instructor.inclass.m5;
public class palindrome_p {
    public static boolean isPalindrome(String s, int start, int end) {
        if (start>=end)return true;
        if (s.charAt(start)!=s.charAt(end))return false;
        return isPalindrome(s, start+1, end-1);
    }
    public static void main(String[]a) {
        String s="racecar";
        System.out.println(s+" palindrome ="+isPalindrome(s, 0, s.length()-1));
    }
}