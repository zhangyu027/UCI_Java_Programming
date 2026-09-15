package instructor.inclass.m7.project2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Canvas-aligned model for a game in the rental shop. */
class Game {
    private final int gameId;
    private final String title;
    private final String platform;

    Game(int gameId, String title, String platform) {
        this.gameId = gameId;
        this.title = title;
        this.platform = platform;
    }

    int getGameId() { return gameId; }
    String getTitle() { return title; }
    String getPlatform() { return platform; }
}

/** Canvas-aligned model for a rental record. */
class Rental {
    private final int rentalId;
    private final int gameId;
    private final String customerName;
    private final Date rentalDate;
    private final Date returnDate;

    Rental(int rentalId, int gameId, String customerName, Date rentalDate, Date returnDate) {
        this.rentalId = rentalId;
        this.gameId = gameId;
        this.customerName = customerName;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    int getRentalId() { return rentalId; }
    int getGameId() { return gameId; }
    String getCustomerName() { return customerName; }
    Date getRentalDate() { return rentalDate; }
    Date getReturnDate() { return returnDate; }
}

/** Java Project II - Game Title Rental Shop, instructor reference. */
public class RentalShop {
    private static final String URL = System.getenv().getOrDefault(
            "UCI_RENTAL_DB_URL", "jdbc:mariadb://127.0.0.1:3306/rental_shop");
    private static final String USER = System.getenv().getOrDefault("UCI_DB_USER", "javauser");
    private static final String PASSWORD = System.getenv().getOrDefault("UCI_DB_PASSWORD", "JavaClass2026");

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTables(connection);
            insertSampleGames(connection);
            displayAvailableGames(connection);
            rentGame(connection, 1, "John Doe");
            displayRentedGames(connection);
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS games (
                        game_id INT PRIMARY KEY AUTO_INCREMENT,
                        title VARCHAR(255) NOT NULL,
                        platform VARCHAR(100) NOT NULL
                    )
                    """);
            statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS rentals (
                        rental_id INT PRIMARY KEY AUTO_INCREMENT,
                        game_id INT NOT NULL,
                        customer_name VARCHAR(255) NOT NULL,
                        rental_date DATE NOT NULL,
                        return_date DATE,
                        CONSTRAINT fk_rental_game
                            FOREIGN KEY (game_id) REFERENCES games(game_id)
                    )
                    """);
        }
    }

    private static void insertSampleGames(Connection connection) throws SQLException {
        String sql = """
                INSERT IGNORE INTO games(game_id, title, platform) VALUES
                (1, 'The Witcher 3: Wild Hunt', 'PlayStation 4'),
                (2, 'Super Mario Odyssey', 'Nintendo Switch')
                """;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
    }

    private static void displayAvailableGames(Connection connection) throws SQLException {
        String sql = "SELECT game_id, title, platform FROM games ORDER BY game_id";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            System.out.println("Available Games:");
            while (rs.next()) {
                Game game = new Game(
                        rs.getInt("game_id"),
                        rs.getString("title"),
                        rs.getString("platform"));
                System.out.printf("Game ID: %d, Title: %s, Platform: %s%n",
                        game.getGameId(), game.getTitle(), game.getPlatform());
            }
            System.out.println();
        }
    }

    private static void rentGame(Connection connection, int gameId, String customerName)
            throws SQLException {
        String sql = """
                INSERT INTO rentals(game_id, customer_name, rental_date, return_date)
                VALUES(?, ?, CURRENT_DATE, NULL)
                """;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, gameId);
            statement.setString(2, customerName);
            statement.executeUpdate();
        }
    }

    private static void displayRentedGames(Connection connection) throws SQLException {
        String sql = """
                SELECT r.rental_id, r.game_id, g.title, g.platform,
                       r.customer_name, r.rental_date, r.return_date
                FROM rentals r
                JOIN games g ON r.game_id = g.game_id
                ORDER BY r.rental_id
                """;
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            System.out.println("Rented Games:");
            while (rs.next()) {
                Rental rental = new Rental(
                        rs.getInt("rental_id"),
                        rs.getInt("game_id"),
                        rs.getString("customer_name"),
                        rs.getDate("rental_date"),
                        rs.getDate("return_date"));
                System.out.printf(
                        "Rental ID: %d, Game ID: %d, Title: %s, Platform: %s, Customer: %s, Rental Date: %s, Return Date: %s%n",
                        rental.getRentalId(), rental.getGameId(), rs.getString("title"),
                        rs.getString("platform"), rental.getCustomerName(),
                        rental.getRentalDate(), rental.getReturnDate());
            }
        }
    }
}
