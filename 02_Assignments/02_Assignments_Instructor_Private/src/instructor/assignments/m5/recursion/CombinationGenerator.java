package instructor.assignments.m5.recursion;

/** Recursive Java program to generate all combinations of characters in a string. */
public class CombinationGenerator {

    public static void generateCombinations(String input, String current, int index) {
        // Base case
        if (index == input.length()) {
            if (!current.isEmpty()) {
                System.out.println(current);
            }
            return;
        }

        // Exclude the current character
        generateCombinations(input, current, index + 1);

        // Include the current character
        generateCombinations(input, current + input.charAt(index), index + 1);
    }

    public static void main(String[] args) {
        String input = "xyz";

        System.out.println("Combinations of string \"" + input + "\":");
        generateCombinations(input, "", 0);
    }
}
