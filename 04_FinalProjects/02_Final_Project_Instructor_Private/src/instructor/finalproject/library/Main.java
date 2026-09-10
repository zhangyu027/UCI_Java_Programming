package instructor.finalproject.library;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
* Complete text-menu instructor solution.
*/
public class Main {
    private final Scanner scanner =
    new Scanner(System.in);
    private final LibraryService service =
    new LibraryService();
    public static void main(String[] args) {
        try {
            DatabaseManager.initialize();
            new Main().run();
        } catch (SQLException e) {
            System.err.println(
            "Database setup failed: "
            + e.getMessage());
            System.err.println(
            "Check README_FIRST.md and "
            + "your Eclipse environment variables.");
        }
    }
    private void run() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice =
            scanner.nextLine().trim();
            try {
                switch (choice) {
                    case "1" ->
                    addBookWorkflow();
                    case "2" ->
                    removeBookWorkflow();
                    case "3" ->
                    searchWorkflow();
                    case "4" ->
                    checkoutWorkflow();
                    case "5" ->
                    returnWorkflow();
                    case "6" ->
                    listAllWorkflow();
                    case "0" ->
                    running = false;
                    default ->
                    System.out.println(
                    "Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println(
                "Error: "
                + e.getMessage());
            }
        }
        System.out.println("Goodbye.");
    }
    private void printMenu() {
        System.out.println();
        System.out.println(
        "=== Library Management System ===");
        System.out.println("1. Add book");
        System.out.println("2. Remove book");
        System.out.println(
        "3. Search by title/author");
        System.out.println("4. Check out book");
        System.out.println("5. Return book");
        System.out.println("6. List all books");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }
    private void addBookWorkflow()
    throws SQLException {
        int id =
        intPrompt("Book ID: ");
        System.out.print("Title: ");
        String title =
        scanner.nextLine();
        System.out.print("Author: ");
        String author =
        scanner.nextLine();
        int copies =
        intPrompt(
        "Available copies: ");
        service.addBook(
        new Book(
        id,
        title,
        author,
        copies));
        System.out.println("Book added.");
    }
    private void removeBookWorkflow()
    throws SQLException {
        int id =
        intPrompt("Book ID: ");
        boolean removed =
        service.removeBook(id);
        System.out.println(
        removed
        ? "Book removed."
        : "Book not found.");
    }
    private void searchWorkflow()
    throws SQLException {
        System.out.print(
        "Title or author: ");
        String term =
        scanner.nextLine();
        printBooks(
        service.search(term));
    }
    private void checkoutWorkflow()
    throws SQLException {
        int id =
        intPrompt("Book ID: ");
        boolean checkedOut =
        service.checkout(id);
        System.out.println(
        checkedOut
        ? "Checked out."
        : "Book unavailable or not found.");
    }
    private void returnWorkflow()
    throws SQLException {
        int id =
        intPrompt("Book ID: ");
        boolean returned =
        service.returnBook(id);
        System.out.println(
        returned
        ? "Returned."
        : "Book not found.");
    }
    private void listAllWorkflow()
    throws SQLException {
        printBooks(
        service.all());
    }
    private void printBooks(
    List<Book> books) {
        if (books.isEmpty()) {
            System.out.println(
            "No books found.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }
    private int intPrompt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input =
            scanner.nextLine().trim();
            try {
                return Integer.parseInt(
                input);
            } catch (NumberFormatException e) {
                System.out.println(
                "Enter a whole number.");
            }
        }
    }
}
