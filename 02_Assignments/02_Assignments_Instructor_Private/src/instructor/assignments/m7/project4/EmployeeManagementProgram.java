package instructor.assignments.m7.project4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeManagementProgram {
    private static final String URL = System.getenv().getOrDefault("UCI_EMPLOYEE_DB_URL", "jdbc:mariadb://127.0.0.1:3306/EmployeeManagement");
    private static final String USER = System.getenv().getOrDefault("UCI_DB_USER", "javauser");
    private static final String PASSWORD = System.getenv().getOrDefault("UCI_DB_PASSWORD", "JavaClass2026");

    public static void main(String[] args) {
        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD); Scanner sc = new Scanner(System.in)) {
            createTables(c);
            System.out.println("Employee Management instructor reference");
            viewEmployees(c);
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    private static void createTables(Connection c) throws SQLException {
        c.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS employee(id INT PRIMARY KEY, name VARCHAR(255), position VARCHAR(255))");
        c.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS hr(employee_id INT PRIMARY KEY, hr_info VARCHAR(255))");
        c.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS payroll(employee_id INT PRIMARY KEY, salary DECIMAL(10,2))");
    }

    private static void viewEmployees(Connection c) throws SQLException {
        try (ResultSet rs = c.createStatement().executeQuery("SELECT id,name,position FROM employee ORDER BY id")) {
            while (rs.next()) {
                System.out.printf("%d | %s | %s%n", rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        }
    }
}
