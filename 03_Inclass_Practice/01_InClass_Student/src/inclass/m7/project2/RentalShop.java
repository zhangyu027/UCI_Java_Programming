package inclass.m7.project2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Canvas-aligned model class. Complete the TODOs as part of Project II. */
class Game {
    private int gameId;
    private String title;
    private String platform;

    public Game(int gameId, String title, String platform) {
        // TODO: Initialize all Game fields.
    }

    public int getGameId() { return gameId; }
    public String getTitle() { return title; }
    public String getPlatform() { return platform; }
}

/** Canvas-aligned rental model class. */
class Rental {
    private int rentalId;
    private int gameId;
    private String customerName;
    private Date rentalDate;
    private Date returnDate;

    public Rental(int rentalId, int gameId, String customerName, Date rentalDate, Date returnDate) {
        // TODO: Initialize all Rental fields.
    }

    public int getRentalId() { return rentalId; }
    public int getGameId() { return gameId; }
    public String getCustomerName() { return customerName; }
    public Date getRentalDate() { return rentalDate; }
    public Date getReturnDate() { return returnDate; }
}

/** Java Project II - Game Title Rental Shop, student starter. */
public class RentalShop {
    private static final String DB_URL = System.getenv().getOrDefault(
            "UCI_RENTAL_DB_URL", "jdbc:mariadb://127.0.0.1:3306/rental_shop");
    private static final String DB_USER = System.getenv().getOrDefault("UCI_DB_USER", "javauser");
    private static final String DB_PASSWORD = System.getenv().getOrDefault("UCI_DB_PASSWORD", "JavaClass2026");

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // TODO 1: Create games and rentals tables.
            // TODO 2: Insert sample games.
            // TODO 3: Display available games by creating Game objects from ResultSet rows.
            // TODO 4: Rent a game and record customer name/rental date.
            // TODO 5: Display rented games by creating Rental objects from ResultSet rows.
            System.out.println("Connected to rental_shop. Complete the Project II TODOs.");
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    // TODO: Add createTables(Connection connection).
    // TODO: Add insertGame(...) or insertSampleGames(...).
    // TODO: Add displayAvailableGames(Connection connection).
    // TODO: Add rentGame(Connection connection, int gameId, String customerName).
    // TODO: Add displayRentedGames(Connection connection).
}
