package Assignment.module01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // TODO 1:
        // Ask the user to enter a student's name.
        String name = "";

        // TODO 2:
        // Create an array that can store 3 student scores.
        double[] scores = new double[3];

        // TODO 3:
        // Use a loop to read all 3 scores.
        //
        // Requirements:
        // - Use Scanner.
        // - Verify that the input is a number.
        // - Accept only scores between 0 and 100.
        // - If the input is invalid, ask the user again.


        // TODO 4:
        // Create a Student object using the student's name
        // and the scores entered above.
        //
        // Example:
        // Student student = ...


        // TODO 5:
        // Print the following report:
        //
        // ----- Student Report -----
        // Student: <student name>
        // Average: <average>
        // Grade: <letter grade>


        sc.close();
    }
}