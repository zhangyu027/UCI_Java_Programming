package inclass.m2;

/*
* IN-CLASS STUDENT HINTS
* ----------------------
* Work incrementally. Run after each small change.
* For file I/O, use try-with-resources.
* For Swing, separate component setup from event-handler logic.
*/
import java.util.Scanner;

/**
* Module 2 practice: collect personal information, save it, and display it.
*
* STUDENT GOAL:
* 1. Ask the user for a few fields.
* 2. Save the information to a text file.
* 3. Read the file back and display it.
*/
public class PersonalInfoFileApp {
    public static void main(String[] args) {
        System.out.println("M2 Personal Information starter ready.");
        try (Scanner scanner = new Scanner(System.in)) {
            // TODO 1: Ask for name, email, and one additional field.
            // TODO 2: Save the values to a text file.
            // TODO 3: Read the text file and print the saved values.
            /*
            * HINT:
            * Path file = Path.of("personal_info.txt");
            * Files.writeString(file, textToSave);
            * String savedText = Files.readString(file);
            */
            System.out.println("TODO: collect, save, and display personal information.");
        }
    }
}
