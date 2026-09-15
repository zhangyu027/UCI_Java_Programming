package assignments.m7.project4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/** Java Project IV - Employee Management, Canvas-aligned student assignment starter. */
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
        // TODO: Create employee, hr, and payroll tables if they do not exist.
    }

    private static void showMenu(Connection connection, Scanner scanner) {
        int choice;
        do {
            System.out.println("\nEmployee Management Program");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View All Employees");
            System.out.println("5. Add HR Information");
            System.out.println("6. Update HR Information");
            System.out.println("7. View HR Information");
            System.out.println("8. Add Payroll Information");
            System.out.println("9. Update Payroll Information");
            System.out.println("10. View Payroll Information");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                choice = -1;
            }

            switch (choice) {
                case 1 -> { /* TODO: addEmployee(connection, scanner); */ }
                case 2 -> { /* TODO: updateEmployee(connection, scanner); */ }
                case 3 -> { /* TODO: deleteEmployee(connection, scanner); */ }
                case 4 -> { /* TODO: viewAllEmployees(connection); */ }
                case 5 -> { /* TODO: addHRInformation(connection, scanner); */ }
                case 6 -> { /* TODO: updateHRInformation(connection, scanner); */ }
                case 7 -> { /* TODO: viewHRInformation(connection, scanner); */ }
                case 8 -> { /* TODO: addPayrollInformation(connection, scanner); */ }
                case 9 -> { /* TODO: updatePayrollInformation(connection, scanner); */ }
                case 10 -> { /* TODO: viewPayrollInformation(connection, scanner); */ }
                case 0 -> System.out.println("Exiting the program. Goodbye!");
                default -> {
                    if (choice != -1) System.out.println("Invalid choice. Please try again.");
                }
            }
        } while (choice != 0);
    }

    // TODO: Implement employee CRUD methods.
    // TODO: Implement add/update/view HR methods.
    // TODO: Implement add/update/view payroll methods.
    // HINT: Use PreparedStatement for values supplied by the user.
}
