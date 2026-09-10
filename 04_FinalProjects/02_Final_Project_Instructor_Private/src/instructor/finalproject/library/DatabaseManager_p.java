package instructor.finalproject.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DatabaseManager_p {
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
    private DatabaseManager_p() {
        // Utility class.
    }
    private static Connection open()
    throws SQLException {
        return DriverManager.getConnection(
        URL,
        USER,
        PASSWORD);
    }
    public static void initialize()
    throws SQLException {
        String sql ="""
        CREATE TABLE IF NOT EXISTS books(
        id INT PRIMARY KEY,
        title VARCHAR(200) NOT NULL,
        author VARCHAR(200) NOT NULL,
        available_copies INT NOT NULL
        CHECK(available_copies >= 0)
)
        """;
        try(Connection connection = open();
        Statement statement =
        connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }
}