package inclass.m4.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/** Demonstrates handling a checked IOException. */
public class CheckedExceptionDemo {
    public static void main(String[] args) {
        try {
            String text = Files.readString(
            Path.of("data", "SalesData.txt"));
            System.out.println(text);
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}
