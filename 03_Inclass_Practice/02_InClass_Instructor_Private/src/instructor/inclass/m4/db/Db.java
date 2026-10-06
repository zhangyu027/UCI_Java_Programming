package instructor.inclass.m4.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Central database connection utility.
 *
 * Supports:
 *
 * Db.getConnection()          -> University
 * Db.open()                   -> University
 * Db.open("company_db")       -> company_db
 * Db.open("student_grade_db") -> student_grade_db
 * Db.open("hamburger_db")     -> hamburger_db
 * Db.open("warehouse_db")     -> warehouse_db
 */
public final class Db {

    private Db() {
        // Utility class - do not instantiate.
    }

    /**
     * Opens the default database from UCI_DB_URL.
     *
     * Current default:
     * jdbc:mariadb://127.0.0.1:3306/University
     */
    public static Connection open() throws SQLException {

        String url = getRequiredEnv("UCI_DB_URL");
        String user = getRequiredEnv("UCI_DB_USER");
        String password = getRequiredEnv("UCI_DB_PASSWORD");

        return DriverManager.getConnection(
                url,
                user,
                password
        );
    }

    /**
     * Backward-compatible method for existing course code.
     *
     * Db.getConnection() is equivalent to Db.open().
     */
    public static Connection getConnection() throws SQLException {
        return open();
    }

    /**
     * Opens a specific database while using the same
     * MariaDB server, username, and password.
     *
     * Example:
     * Db.open("company_db")
     */
    public static Connection open(String database)
            throws SQLException {

        if (database == null || database.isBlank()) {
            return open();
        }

        String baseUrl = getRequiredEnv("UCI_DB_URL");
        String user = getRequiredEnv("UCI_DB_USER");
        String password = getRequiredEnv("UCI_DB_PASSWORD");

        String url = replaceDatabase(
                baseUrl,
                database.trim()
        );

        return DriverManager.getConnection(
                url,
                user,
                password
        );
    }

    /**
     * Optional backward-compatible version allowing:
     *
     * Db.getConnection("company_db")
     */
    public static Connection getConnection(String database)
            throws SQLException {

        return open(database);
    }

    /**
     * Reads a required environment variable.
     */
    private static String getRequiredEnv(String name)
            throws SQLException {

        String value = System.getenv(name);

        if (value == null || value.isBlank()) {
            throw new SQLException(
                    name + " is not configured."
            );
        }

        return value;
    }

    /**
     * Changes only the database portion of the JDBC URL.
     *
     * Example:
     *
     * jdbc:mariadb://127.0.0.1:3306/University
     *
     * becomes:
     *
     * jdbc:mariadb://127.0.0.1:3306/company_db
     */
    private static String replaceDatabase(
            String baseUrl,
            String database) {

        int schemeEnd = baseUrl.indexOf("://");

        if (schemeEnd < 0) {
            throw new IllegalArgumentException(
                    "Invalid JDBC URL: " + baseUrl
            );
        }

        int databaseSlash =
                baseUrl.indexOf('/', schemeEnd + 3);

        /*
         * URL contains server but no database.
         */
        if (databaseSlash < 0) {
            return baseUrl + "/" + database;
        }

        /*
         * Preserve JDBC URL parameters if present.
         */
        int queryStart =
                baseUrl.indexOf('?', databaseSlash);

        if (queryStart >= 0) {

            return baseUrl.substring(
                    0,
                    databaseSlash + 1
            )
            + database
            + baseUrl.substring(queryStart);
        }

        return baseUrl.substring(
                0,
                databaseSlash + 1
        ) + database;
    }
}