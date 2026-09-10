package inclass.m2;

/*
* IN-CLASS STUDENT HINTS
* ----------------------
* Work incrementally. Run after each small change.
* For file I/O, use try-with-resources.
* For Swing, separate component setup from event-handler logic.
*/
import java.nio.file.Files;
import java.nio.file.Path;

/** Module 2 practice: basic text-file writing and reading. */
public class TextFileReaderWriter {
    public static void main(String[] args) throws Exception {
        System.out.println("M2 File I/O starter ready.");
        Path file = Path.of("practice.txt");
        // TODO 1: Write at least two lines to the file.
        // TODO 2: Read the file back.
        // TODO 3: Print what you read.
        /*
        * HINT / CODE PATTERN:
        * Files.writeString(file, "Line 1\nLine 2\n");
        * String content = Files.readString(file);
        * System.out.println(content);
        */
        System.out.println("Practice file location: " + file.toAbsolutePath());
    }
}
