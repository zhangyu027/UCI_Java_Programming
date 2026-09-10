package instructor.finalproject.library;

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
        try(Connection connection = DatabaseManager.open();
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
