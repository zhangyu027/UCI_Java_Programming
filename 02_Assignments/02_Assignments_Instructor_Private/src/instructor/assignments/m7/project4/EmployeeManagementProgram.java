package instructor.assignments.m7.project4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/** Java Project IV - Employee Management, Canvas-aligned instructor reference. */
public class EmployeeManagementProgram {
    private static final String URL = System.getenv().getOrDefault(
            "UCI_EMPLOYEE_DB_URL", "jdbc:mariadb://127.0.0.1:3306/EmployeeManagement");
    private static final String USER = System.getenv().getOrDefault("UCI_DB_USER", "javauser");
    private static final String PASSWORD = System.getenv().getOrDefault("UCI_DB_PASSWORD", "JavaClass2026");

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {
            createTables(connection);
            showMenu(connection, scanner);
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    private static void createTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS employee (id INT PRIMARY KEY, name VARCHAR(255), position VARCHAR(255))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS hr (employee_id INT PRIMARY KEY, hr_info VARCHAR(255), FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS payroll (employee_id INT PRIMARY KEY, salary DECIMAL(10,2), FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE)");
        }
    }

    private static void showMenu(Connection connection, Scanner scanner) {
        int choice = -1;
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
                switch (choice) {
                    case 1 -> addEmployee(connection, scanner);
                    case 2 -> updateEmployee(connection, scanner);
                    case 3 -> deleteEmployee(connection, scanner);
                    case 4 -> viewAllEmployees(connection);
                    case 5 -> addHRInformation(connection, scanner);
                    case 6 -> updateHRInformation(connection, scanner);
                    case 7 -> viewHRInformation(connection, scanner);
                    case 8 -> addPayrollInformation(connection, scanner);
                    case 9 -> updatePayrollInformation(connection, scanner);
                    case 10 -> viewPayrollInformation(connection, scanner);
                    case 0 -> System.out.println("Exiting the program. Goodbye!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (SQLException e) {
                System.out.println("Database operation failed: " + e.getMessage());
            }
        } while (choice != 0);
    }

    private static int readId(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private static void addEmployee(Connection connection, Scanner scanner) throws SQLException {
        int id = readId(scanner, "Employee ID: ");
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Position: ");
        String position = scanner.nextLine().trim();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO employee(id,name,position) VALUES(?,?,?)")) {
            ps.setInt(1, id); ps.setString(2, name); ps.setString(3, position);
            ps.executeUpdate();
            System.out.println("Employee added successfully.");
        }
    }

    private static void updateEmployee(Connection connection, Scanner scanner) throws SQLException {
        int id = readId(scanner, "Employee ID to update: ");
        System.out.print("New name: ");
        String name = scanner.nextLine().trim();
        System.out.print("New position: ");
        String position = scanner.nextLine().trim();
        try (PreparedStatement ps = connection.prepareStatement("UPDATE employee SET name=?, position=? WHERE id=?")) {
            ps.setString(1, name); ps.setString(2, position); ps.setInt(3, id);
            System.out.println(ps.executeUpdate() > 0 ? "Employee updated successfully." : "Employee ID not found.");
        }
    }

    private static void deleteEmployee(Connection connection, Scanner scanner) throws SQLException {
        int id = readId(scanner, "Employee ID to delete: ");
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM employee WHERE id=?")) {
            ps.setInt(1, id);
            System.out.println(ps.executeUpdate() > 0 ? "Employee deleted successfully." : "Employee ID not found.");
        }
    }

    private static void viewAllEmployees(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT id,name,position FROM employee ORDER BY id")) {
            System.out.println("\nEmployees:");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf("%d | %s | %s%n", rs.getInt("id"), rs.getString("name"), rs.getString("position"));
            }
            if (!found) System.out.println("No employees found.");
        }
    }

    private static void addHRInformation(Connection connection, Scanner scanner) throws SQLException {
        int id = readId(scanner, "Employee ID: ");
        System.out.print("HR information: ");
        String info = scanner.nextLine().trim();
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO hr(employee_id,hr_info) VALUES(?,?)")) {
            ps.setInt(1, id); ps.setString(2, info); ps.executeUpdate();
            System.out.println("HR information added successfully.");
        }
    }

    private static void updateHRInformation(Connection connection, Scanner scanner) throws SQLException {
        int id = readId(scanner, "Employee ID: ");
        System.out.print("New HR information: ");
        String info = scanner.nextLine().trim();
        try (PreparedStatement ps = connection.prepareStatement("UPDATE hr SET hr_info=? WHERE employee_id=?")) {
            ps.setString(1, info); ps.setInt(2, id);
            System.out.println(ps.executeUpdate() > 0 ? "HR information updated." : "HR record not found.");
        }
    }

    private static void viewHRInformation(Connection connection, Scanner scanner) throws SQLException {
        int id = readId(scanner, "Employee ID: ");
        try (PreparedStatement ps = connection.prepareStatement("SELECT e.name,h.hr_info FROM employee e JOIN hr h ON e.id=h.employee_id WHERE e.id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) System.out.printf("%s | HR: %s%n", rs.getString("name"), rs.getString("hr_info"));
                else System.out.println("HR record not found.");
            }
        }
    }

    private static void addPayrollInformation(Connection connection, Scanner scanner) throws SQLException {
        int id = readId(scanner, "Employee ID: ");
        System.out.print("Salary: ");
        double salary = Double.parseDouble(scanner.nextLine().trim());
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO payroll(employee_id,salary) VALUES(?,?)")) {
            ps.setInt(1, id); ps.setDouble(2, salary); ps.executeUpdate();
            System.out.println("Payroll information added successfully.");
        }
    }

    private static void updatePayrollInformation(Connection connection, Scanner scanner) throws SQLException {
        int id = readId(scanner, "Employee ID: ");
        System.out.print("New salary: ");
        double salary = Double.parseDouble(scanner.nextLine().trim());
        try (PreparedStatement ps = connection.prepareStatement("UPDATE payroll SET salary=? WHERE employee_id=?")) {
            ps.setDouble(1, salary); ps.setInt(2, id);
            System.out.println(ps.executeUpdate() > 0 ? "Payroll information updated." : "Payroll record not found.");
        }
    }

    private static void viewPayrollInformation(Connection connection, Scanner scanner) throws SQLException {
        int id = readId(scanner, "Employee ID: ");
        try (PreparedStatement ps = connection.prepareStatement("SELECT e.name,p.salary FROM employee e JOIN payroll p ON e.id=p.employee_id WHERE e.id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) System.out.printf("%s | Salary: %.2f%n", rs.getString("name"), rs.getDouble("salary"));
                else System.out.println("Payroll record not found.");
            }
        }
    }
}
