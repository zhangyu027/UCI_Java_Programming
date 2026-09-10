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
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* Shared database connection helper for Module 4.
*
* IMPORTANT:
* - Do not place your real password in source code.
* - Configure UCI_DB_PASSWORD in Eclipse Run Configurations.
*/
public final class Db {
    private static final String URL = System.getenv().getOrDefault(
    "UCI_DB_URL",
    "jdbc:mariadb://127.0.0.1:3306/University");
    private static final String USER = System.getenv().getOrDefault(
    "UCI_DB_USER",
    "javauser");
    private static final String PASSWORD = System.getenv().getOrDefault(
    "UCI_DB_PASSWORD",
    "");
    private Db() {
        // Utility class: do not create Db objects.
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    /*
    * HINT:
    * Older classroom examples may use Db.open().
    * This alias is included so both styles work.
    */
    public static Connection open() throws SQLException {
        return getConnection();
    }
}
