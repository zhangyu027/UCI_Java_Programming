package Assignment.module05;

import java.util.*;

public class GenericUtils {

    // TODO:
    // Study why <T> appears before the return type.
    //
    // Modify or expand this method as directed
    // by the assignment.
    public static <T> void printItem(T item) {

        System.out.println(item);
    }


    public static void printCollection(List<?> items) {

        // TODO:
        // Use a loop to print every item
        // in the collection.

    }
}