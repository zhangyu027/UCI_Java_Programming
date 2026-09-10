package student.finalproject.library;

/*
* PROVIDED SETUP HELPER
* ---------------------
* This file is intentionally complete because it verifies the environment.
* It is not the graded algorithm / CRUD answer.
*/
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
import java.sql.ResultSet;
import java.sql.Statement;

/**
* Database setup checkpoint.
*
* Run this BEFORE implementing the complete project.
*/
public class DatabaseConnectionTest {
    public static void main(String[] args) {
        String sql =
        "SELECT id, title, author, available_copies "
        + "FROM books ORDER BY id";
        try (Connection connection = DatabaseManager.open();
        Statement statement = connection.createStatement();
        ResultSet resultSet =
        statement.executeQuery(sql)) {
            System.out.println(
            "SUCCESS: Connected to library_db!");
            System.out.println(
            "Books currently stored:");
            while (resultSet.next()) {
                System.out.println(
                resultSet.getInt("id")
                + " | "
                + resultSet.getString("title")
                + " | "
                + resultSet.getString("author")
                + " | copies="
                + resultSet.getInt(
                "available_copies"));
            }
        } catch (Exception e) {
            System.out.println(
            "ERROR: Final Project database "
            + "connection failed.");
            e.printStackTrace();
        }
    }
}
