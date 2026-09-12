package assignments.m7.project4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/** Java Project IV - Employee Management, student assignment starter. */
public class EmployeeManagementProgram {
    private static final String DB_URL = System.getenv().getOrDefault(
            "UCI_EMPLOYEE_DB_URL", "jdbc:mariadb://127.0.0.1:3306/EmployeeManagement");
    private static final String USER = System.getenv().getOrDefault("UCI_DB_USER", "javauser");
    private static final String PASSWORD = System.getenv().getOrDefault("UCI_DB_PASSWORD", "JavaClass2026");

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {
            createTables(connection);
            showMenu(connection, scanner);
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        // TODO: Create employee, hr, and payroll tables.
    }

    private static void showMenu(Connection connection, Scanner scanner) {
        System.out.println("Employee Management Program");
        System.out.println("TODO: Implement the required employee, HR, and payroll menu operations.");
        // TODO: Add/update/delete/view employees; add/update/view HR; add/update/view payroll.
    }
}
