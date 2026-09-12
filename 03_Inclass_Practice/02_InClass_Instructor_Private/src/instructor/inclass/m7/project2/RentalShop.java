package instructor.inclass.m7.project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RentalShop {
    private static final String URL = System.getenv().getOrDefault("UCI_RENTAL_DB_URL", "jdbc:mariadb://127.0.0.1:3306/rental_shop");
    private static final String USER = System.getenv().getOrDefault("UCI_DB_USER", "javauser");
    private static final String PASSWORD = System.getenv().getOrDefault("UCI_DB_PASSWORD", "JavaClass2026");

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            createTables(connection);
            insertSampleGames(connection);
            displayGames(connection);
            rentGame(connection, 1, "Sample Customer");
            displayRentals(connection);
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    private static void createTables(Connection c) throws SQLException {
        c.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS games (game_id INT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(255) NOT NULL, platform VARCHAR(100) NOT NULL)");
        c.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS rentals (rental_id INT PRIMARY KEY AUTO_INCREMENT, game_id INT, customer_name VARCHAR(255), rental_date DATE, return_date DATE)");
    }

    private static void insertSampleGames(Connection c) throws SQLException {
        c.createStatement().executeUpdate("INSERT IGNORE INTO games(game_id,title,platform) VALUES (1,'Sample Adventure','PC'),(2,'Sample Racing','Nintendo Switch')");
    }

    private static void displayGames(Connection c) throws SQLException {
        try (ResultSet rs = c.createStatement().executeQuery("SELECT game_id,title,platform FROM games ORDER BY game_id")) {
            while (rs.next()) System.out.printf("%d | %s | %s%n", rs.getInt(1), rs.getString(2), rs.getString(3));
        }
    }

    private static void rentGame(Connection c, int gameId, String customer) throws SQLException {
        try (PreparedStatement ps = c.prepareStatement("INSERT INTO rentals(game_id,customer_name,rental_date) VALUES(?,?,CURRENT_DATE)")) {
            ps.setInt(1, gameId);
            ps.setString(2, customer);
            ps.executeUpdate();
        }
    }

    private static void displayRentals(Connection c) throws SQLException {
        try (ResultSet rs = c.createStatement().executeQuery("SELECT rental_id,game_id,customer_name,rental_date FROM rentals ORDER BY rental_id")) {
            while (rs.next()) System.out.printf("%d | game %d | %s | %s%n", rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4));
        }
    }
}
