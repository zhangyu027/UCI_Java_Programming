package assignment.m5.recursion;

/*
* STUDENT HINTS
* -------------
* For recursion, identify:
* 1. Base case: when should recursion stop?
* 2. Recursive case: what smaller version of the same problem is solved next?
* 3. State: what values must be passed into the next call?
*
* CHECKPOINT:
* Test with a very small input first so you can trace every recursive call.
*/
/** M5 Assignment: recursively generate character combinations. */
public class CombinationGenerator {
    public static void generateCombinations(
    String input,
    String current,
    int index) {
        // TODO: Add the base case.
        // TODO: Add recursive calls that include/exclude the current character.
        /*
        * HINT:
        * Base case: when index reaches input.length(), print current.
        * Recursive branch 1: include input.charAt(index).
        * Recursive branch 2: do not include that character.
        */
    }
    public static void main(String[] args) {
        String input = "ABC";
        // TODO: Call generateCombinations(input, "", 0).
        System.out.println("M5 Recursion starter ready for input: " + input);
    }
}
