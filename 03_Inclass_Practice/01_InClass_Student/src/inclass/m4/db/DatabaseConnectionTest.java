package inclass.m4.db;

/*
* PROVIDED SETUP HELPER
* ---------------------
* This file is intentionally complete because it verifies the environment.
* It is not the graded algorithm / CRUD answer.
*/
/*
* IN-CLASS STUDENT HINTS - JDBC
* -----------------------------
* First checkpoint: DatabaseConnectionTest must connect successfully.
*
* Shared helper:
* - Db.getConnection() opens the default University database connection.
* - Db.open() is a compatibility alias.
* - Some examples may use Db.open(databaseName) for another practice database.
*
* JDBC STEPS:
* Connection -> PreparedStatement -> set parameters -> execute -> ResultSet
*
* Keep SQL values parameterized with ? placeholders.
*/
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/** Run this first to verify Java -> JDBC -> MariaDB. */
public class DatabaseConnectionTest {
    public static void main(String[] args) {
        String sql = "SELECT * FROM Students ORDER BY student_id";
        try (Connection connection = Db.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("SUCCESS: Connected to MariaDB!");
            System.out.println("Students in University:");
            System.out.println("-----------------------------------------------");
            while (resultSet.next()) {
                System.out.println(
                resultSet.getInt("student_id") + " | "
                + resultSet.getString("first_name") + " | "
                + resultSet.getString("last_name") + " | "
                + resultSet.getString("email") + " | "
                + resultSet.getString("major"));
            }
        } catch (Exception e) {
            System.out.println("ERROR: Database connection failed.");
            e.printStackTrace();
        }
    }
}
