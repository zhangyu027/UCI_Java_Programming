package instructor.assignments.m5.recursion;

public class CombinationGenerator {
    public static void generateCombinations(String input, String current, int index) {
        if (index==input.length()) {
            if (!current.isEmpty())System.out.println(current);
            return;
        }
        generateCombinations(input, current, index+1);
        generateCombinations(input, current+input.charAt(index), index+1);
    }
    public static void main(String[] a) {
        generateCombinations("ABC", "", 0);
    }
}
