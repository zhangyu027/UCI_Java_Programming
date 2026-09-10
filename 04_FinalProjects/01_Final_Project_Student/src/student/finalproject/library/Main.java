package student.finalproject.library;

/*
* STUDENT PROJECT GUIDE
* ---------------------
* Work in this order:
* 1. Run SetupCheck.
* 2. Create library_db with sql/library_setup.sql.
* 3. Add MariaDB Connector/J to this Eclipse project's Classpath.
* 4. Set UCI_LIBRARY_DB_URL, UCI_DB_USER, and UCI_DB_PASSWORD.
* 5. Run DatabaseConnectionTest until it prints SUCCESS.
* 6. Complete TODOs in DatabaseManager, LibraryService, and Main.
*
* KEY PARAMETERS:
* - JDBC URL: jdbc:mariadb://127.0.0.1:3306/library_db
* - Table: books(id, title, author, available_copies)
* - Use PreparedStatement for values entered by the user.
*
* ANSWER CHECKPOINT:
* Checkout must never reduce available_copies below 0.
*/
import java.sql.SQLException;
import java.util.Scanner;

/**
* Text-menu entry point for the Library Management System.
*/
public class Main {
    private final Scanner scanner =
    new Scanner(System.in);
    private final LibraryService service =
    new LibraryService();
    public static void main(String[] args) {
        System.out.println(
        "Library Management System starter ready.");
        try {
            /*
            * TODO 8:
            * After DatabaseManager.initialize()
            * is complete, uncomment:
            *
            * DatabaseManager.initialize();
            */
            /*
            * TODO 9:
            * After the menu workflow is complete,
            * uncomment:
            *
            * new Main().run();
            */
            System.out.println(
            "Complete the TODOs in "
            + "DatabaseManager, LibraryService, "
            + "and Main.");
        } catch (Exception e) {
            System.out.println(
            "Application could not start: "
            + e.getMessage());
            e.printStackTrace();
        }
    }
    private void run() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice =
            scanner.nextLine().trim();
            try {
                /*
                * TODO 10:
                * Implement choices 1-6 and 0.
                *
                * HINT / MENU MAP:
                *
                * 1 -> addBookWorkflow()
                * 2 -> removeBookWorkflow()
                * 3 -> searchWorkflow()
                * 4 -> checkoutWorkflow()
                * 5 -> returnWorkflow()
                * 6 -> listAllWorkflow()
                * 0 -> running = false
                *
                * ANSWER CHECKPOINT:
                * Keep SQL in LibraryService.
                * Keep input/menu logic in Main.
                */
                if ("0".equals(choice)) {
                    running = false;
                } else {
                    System.out.println(
                    "TODO: implement menu choice "
                    + choice);
                }
            } catch (Exception e) {
                System.out.println(
                "Error: " + e.getMessage());
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
    /*
    * OPTIONAL HINT:
    *
    * Create small helper methods:
    *
    * private void addBookWorkflow()
    *         throws SQLException { ... }
    *
    * private void removeBookWorkflow()
    *         throws SQLException { ... }
    *
    * private void searchWorkflow()
    *         throws SQLException { ... }
    *
    * private int intPrompt(String prompt) { ... }
    *
    * This keeps Main readable and makes your
    * team presentation easier to explain.
    */
}
