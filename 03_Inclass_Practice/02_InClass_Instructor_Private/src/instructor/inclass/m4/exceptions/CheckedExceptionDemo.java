package instructor.inclass.m4.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Canvas-aligned checked exception example using SalesData.txt. */
public class CheckedExceptionDemo {
    public static void main(String[] args) {
        File file = new File("data/SalesData.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}
