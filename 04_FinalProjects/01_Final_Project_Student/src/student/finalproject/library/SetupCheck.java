package student.finalproject.library;

/*
* PROVIDED SETUP HELPER
* ---------------------
* This file is intentionally complete because it verifies the environment.
* It is not the graded algorithm / CRUD answer.
*/
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
/**
* Run this class immediately after importing the Eclipse project.
*/
public class SetupCheck {
    public static void main(String[] args) {
        System.out.println(
        "SUCCESS: Final Project Eclipse starter is ready.");
        System.out.println(
        "Next: add MariaDB Connector/J and "
        + "run DatabaseConnectionTest.");
    }
}
