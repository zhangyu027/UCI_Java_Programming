package assignments.m4.studentdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Shared database connection helper for Module 4. */
public final class Db {
    private static final String URL = System.getenv().getOrDefault("UCI_DB_URL", "jdbc:mariadb://127.0.0.1:3306/University");
    private static final String USER = System.getenv().getOrDefault("UCI_DB_USER", "javauser");
    private static final String PASSWORD = System.getenv().getOrDefault("UCI_DB_PASSWORD", "");
    private Db() { }
    public static Connection getConnection() throws SQLException { return DriverManager.getConnection(URL, USER, PASSWORD); }
    public static Connection open() throws SQLException { return getConnection(); }
}
