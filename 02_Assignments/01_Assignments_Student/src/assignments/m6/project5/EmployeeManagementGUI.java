package assignments.m6.project5;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/** Java Project V - Employee Management (Swing), student assignment starter. */
public class EmployeeManagementGUI {
    private static final String DB_URL = System.getenv().getOrDefault(
            "UCI_EMPLOYEE_DB_URL", "jdbc:mariadb://127.0.0.1:3306/EmployeeManagement");
    private static final String USER = System.getenv().getOrDefault("UCI_DB_USER", "javauser");
    private static final String PASSWORD = System.getenv().getOrDefault("UCI_DB_PASSWORD", "JavaClass2026");

    public static void main(String[] args) {
        createTables();
        SwingUtilities.invokeLater(EmployeeManagementGUI::createAndShowGUI);
    }

    private static void createTables() {
        try (Connection ignored = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            // TODO: Create employee, hr, and payroll tables if they do not exist.
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Employee Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1, 6, 6));
        JButton add = new JButton("Add Employee");
        JButton update = new JButton("Update Employee");
        JButton delete = new JButton("Delete Employee");
        JButton view = new JButton("View All Employees");
        add.addActionListener(e -> { /* TODO: Add employee. */ });
        update.addActionListener(e -> { /* TODO: Update employee. */ });
        delete.addActionListener(e -> { /* TODO: Delete employee. */ });
        view.addActionListener(e -> { /* TODO: View employees. */ });
        frame.add(add); frame.add(update); frame.add(delete); frame.add(view);
        // TODO: Add the required HR and payroll Swing actions.
        frame.setSize(380, 320);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
