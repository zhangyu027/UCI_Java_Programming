package instructor.inclass.m4.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Shared JDBC helper for all Module 4 database practices. */
public final class Db {
    private static final String SERVER_URL = System.getenv().getOrDefault(
    "UCI_DB_SERVER_URL",
    "jdbc:mariadb://127.0.0.1:3306");
    private static final String UNIVERSITY_URL = System.getenv().getOrDefault(
    "UCI_DB_URL",
    SERVER_URL + "/University");
    private static final String USER = System.getenv().getOrDefault(
    "UCI_DB_USER",
    "javauser");
    private static final String PASSWORD = System.getenv().getOrDefault(
    "UCI_DB_PASSWORD",
    "");
    private Db() {
        // Utility class.
    }
    /** Default Module 4 connection: University database. */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
        UNIVERSITY_URL,
        USER,
        PASSWORD);
    }
    /** Compatibility alias for older examples that use Db.open(). */
    public static Connection open() throws SQLException {
        return getConnection();
    }
    /** Opens one of the named Module 4 practice databases. */
    public static Connection open(String database) throws SQLException {
        if (database == null || !database.matches("[A-Za-z0-9_]+")) {
            throw new IllegalArgumentException(
            "Invalid database name: " + database);
        }
        return DriverManager.getConnection(
        SERVER_URL + "/" + database,
        USER,
        PASSWORD);
    }
}
