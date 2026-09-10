package instructor.assignments.m4.studentdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
* STEP 1: Run this before starting the Swing CRUD assignment.
*
* Expected result:
* SUCCESS: Connected to MariaDB!
* 1001 | Alex | Chen | alex@uci.edu | Computer Science
*/
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
