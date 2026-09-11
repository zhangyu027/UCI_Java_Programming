package instructor.inclass.m4.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/** Run this first to verify Java -> JDBC -> MariaDB. */
public class DatabaseConnectionTest {
    public static void main(String[] args) {
        String sql = "SELECT * FROM Students ORDER BY student_id";
        try(Connection connection = Db.getConnection();
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
