package assignment.m4.studentdb;

/*
* PROVIDED SETUP HELPER
* ---------------------
* This file is intentionally complete because it verifies the environment.
* It is not the graded algorithm / CRUD answer.
*/
/*
* STUDENT HINTS - MODULE 4 DATABASE
* ---------------------------------
* Recommended sequence:
* 1. Run sql/university_setup.sql.
* 2. Add MariaDB Connector/J to Eclipse Classpath.
* 3. Configure UCI_DB_URL, UCI_DB_USER, and UCI_DB_PASSWORD.
* 4. Run DatabaseConnectionTest.
* 5. Implement addStudent(), updateStudent(), deleteStudent(), displayStudents().
*
* KEY TABLE:
* Students(student_id, first_name, last_name, email, major)
*
* JDBC PATTERN:
* try(Connection con = Db.getConnection();
*      PreparedStatement ps = con.prepareStatement(sql)) {
*     // set ? parameters
*     // executeUpdate() or executeQuery()
* }
*
* ANSWER CHECKPOINT:
* Use ? parameters; do not concatenate user-entered values into SQL.
*/
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
