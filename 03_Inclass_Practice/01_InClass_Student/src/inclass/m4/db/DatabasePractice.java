package inclass.m4.db;

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

/** Module 4 practice: SELECT records with JDBC. */
public class DatabasePractice {
    public static void main(String[] args) {
        try (Connection connection = Db.getConnection()) {
            System.out.println("SUCCESS: Connected to MariaDB.");
            // TODO 1: Create a SELECT statement for Students.
            // HINT: String sql = "SELECT * FROM Students";
            // TODO 2: Create a Statement and execute the query.
            // HINT:
            // try (Statement statement = connection.createStatement();
            //      ResultSet resultSet = statement.executeQuery(sql)) {
                //
                //     // TODO 3: Loop through resultSet.next().
                // }
            // ANSWER CHECKPOINT:
            // Print at least student_id, first_name, and last_name.
        } catch (Exception e) {
            System.out.println("ERROR: Database practice failed.");
            e.printStackTrace();
        }
    }
}
