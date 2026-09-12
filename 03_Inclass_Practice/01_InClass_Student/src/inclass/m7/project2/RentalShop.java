package inclass.m7.project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Java Project II - Game Title Rental Shop, student starter. */
public class RentalShop {
    private static final String DB_URL = System.getenv().getOrDefault(
            "UCI_RENTAL_DB_URL", "jdbc:mariadb://127.0.0.1:3306/rental_shop");
    private static final String DB_USER = System.getenv().getOrDefault("UCI_DB_USER", "javauser");
    private static final String DB_PASSWORD = System.getenv().getOrDefault("UCI_DB_PASSWORD", "JavaClass2026");

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // TODO: Create games and rentals tables.
            // TODO: Insert sample games.
            // TODO: Display available games.
            // TODO: Rent a game and record customer/rental date.
            // TODO: Display rented games.
            System.out.println("Connected to rental_shop. Complete the Project II TODOs.");
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}
