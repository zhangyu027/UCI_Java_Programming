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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
* Central JDBC helper for the final project.
*
* Do not hard-code your real password in this file.
* Configure UCI_DB_PASSWORD in Eclipse Run Configurations.
*/
public final class DatabaseManager {
    private static final String URL =
    System.getenv().getOrDefault(
    "UCI_LIBRARY_DB_URL",
    "jdbc:mariadb://127.0.0.1:3306/library_db");
    private static final String USER =
    System.getenv().getOrDefault(
    "UCI_DB_USER",
    "javauser");
    private static final String PASSWORD =
    System.getenv().getOrDefault(
    "UCI_DB_PASSWORD",
    "");
    private DatabaseManager() {
        // Utility class.
    }
    public static Connection open()
    throws SQLException {
        return DriverManager.getConnection(
        URL,
        USER,
        PASSWORD);
    }
    public static void initialize()
    throws SQLException {
        /*
        * TODO 1:
        * Create the books table if it does not already exist.
        *
        * HINT SQL:
        *
        * CREATE TABLE IF NOT EXISTS books(
        *     id INT PRIMARY KEY,
        *     title VARCHAR(200) NOT NULL,
        *     author VARCHAR(200) NOT NULL,
        *     available_copies INT NOT NULL
        *)
        *
        * HINT JAVA:
        *
        * try(Connection connection = open();
        *      Statement statement = connection.createStatement()) {
        *
        *     statement.executeUpdate(sql);
        * }
        */
        // Starter line keeps this class compile-ready.
        // Remove it after implementing TODO 1.
    }
}
