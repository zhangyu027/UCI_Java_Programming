package instructor.assignments.m4.studentdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* Shared database connection helper for Module 4.
*
* IMPORTANT:
* - Do not place your real password in source code.
* - Configure UCI_DB_PASSWORD in Eclipse Run Configurations.
*/
public final class Db {
    private static final String URL = System.getenv().getOrDefault(
    "UCI_DB_URL",
    "jdbc:mariadb://127.0.0.1:3306/University");
    private static final String USER = System.getenv().getOrDefault(
    "UCI_DB_USER",
    "javauser");
    private static final String PASSWORD = System.getenv().getOrDefault(
    "UCI_DB_PASSWORD",
    "");
    private Db() {
        // Utility class: do not create Db objects.
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    /*
    * HINT:
    * Older classroom examples may use Db.open().
    * This alias is included so both styles work.
    */
    public static Connection open() throws SQLException {
        return getConnection();
    }
}
