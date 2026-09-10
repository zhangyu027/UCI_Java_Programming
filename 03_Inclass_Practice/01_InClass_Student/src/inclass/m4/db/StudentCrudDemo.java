package inclass.m4.db;

/**
* In-class JDBC CRUD starter.
*
* Goal: practice SELECT, INSERT, UPDATE, and DELETE without receiving
* the completed CRUD answer key.
*/
public class StudentCrudDemo {

    public static void main(String[] args) {

        System.out.println("Student CRUD starter ready.");

        /*
        * Work in this order:
        *
        * 1. Run DatabaseConnectionTest first.
        * 2. Implement displayStudents().
        * 3. Implement insertStudent(...).
        * 4. Implement updateStudent(...).
        * 5. Implement deleteStudent(...).
        *
        * Uncomment one test call at a time after each method works.
        */

        // displayStudents();
        // insertStudent(1002, "Jamie", "Lee", "jamie@uci.edu", "Data Science");
        // updateStudent(1002, "Jamie", "Lee", "jamie.lee@uci.edu", "Computer Science");
        // deleteStudent(1002);
    }

    private static void displayStudents() {

        /*
        * TODO 1:
        * Display all rows from Students ordered by student_id.
        *
        * KEY SQL:
        * SELECT student_id, first_name, last_name, email, major
        * FROM Students
        * ORDER BY student_id
        *
        * JDBC HINT:
        *
        * try (Connection connection = Db.getConnection();
        *      Statement statement = connection.createStatement();
        *      ResultSet resultSet = statement.executeQuery(sql)) {
        *
        *     while (resultSet.next()) {
        *         // read columns with getInt(...) / getString(...)
        *     }
        * }
        */

        System.out.println("TODO: implement displayStudents().");
    }

    private static void insertStudent(
    int studentId,
    String firstName,
    String lastName,
    String email,
    String major) {

        /*
        * TODO 2:
        * INSERT one student.
        *
        * KEY SQL:
        * INSERT INTO Students
        * (student_id, first_name, last_name, email, major)
        * VALUES (?, ?, ?, ?, ?)
        *
        * PARAMETER CHECKPOINT:
        * 1 -> studentId
        * 2 -> firstName
        * 3 -> lastName
        * 4 -> email
        * 5 -> major
        *
        * Use PreparedStatement and executeUpdate().
        */

        System.out.println("TODO: implement insertStudent().");
    }

    private static void updateStudent(
    int studentId,
    String firstName,
    String lastName,
    String email,
    String major) {

        /*
        * TODO 3:
        * UPDATE the row identified by student_id.
        *
        * KEY SQL:
        * UPDATE Students
        * SET first_name = ?, last_name = ?, email = ?, major = ?
        * WHERE student_id = ?
        *
        * ANSWER CHECKPOINT:
        * student_id is parameter 5 in this SQL statement.
        */

        System.out.println("TODO: implement updateStudent().");
    }

    private static void deleteStudent(int studentId) {

        /*
        * TODO 4:
        * DELETE the row identified by student_id.
        *
        * KEY SQL:
        * DELETE FROM Students WHERE student_id = ?
        *
        * Use PreparedStatement.
        */

        System.out.println("TODO: implement deleteStudent().");
    }
}
