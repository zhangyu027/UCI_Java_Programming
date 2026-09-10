package instructor.inclass.m3.exceptions;

public class MultipleExceptions_p {
    public static void main(String[] args) {
    String value=args.length==0?"abc":args[0];
    try {
        int n=Integer.parseInt(value);
        System.out.println(100/n);
    } catch (NumberFormatException e) {
        System.out.println("Input is not a integer.");
    } catch (ArithmeticException e) {
        System.out.println("Integer cannot be zero.");
    }
   }
}