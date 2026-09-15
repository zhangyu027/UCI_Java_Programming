package assignments.m6.project5;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/** Java Project V - Employee Management (Swing), Canvas-aligned student starter. */
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
        frame.setLayout(new GridLayout(0, 2, 8, 8));

        JButton addEmployee = new JButton("Add Employee");
        JButton updateEmployee = new JButton("Update Employee");
        JButton deleteEmployee = new JButton("Delete Employee");
        JButton viewEmployees = new JButton("View All Employees");
        JButton addHR = new JButton("Add HR Information");
        JButton updateHR = new JButton("Update HR Information");
        JButton viewHR = new JButton("View HR Information");
        JButton addPayroll = new JButton("Add Payroll Information");
        JButton updatePayroll = new JButton("Update Payroll Information");
        JButton viewPayroll = new JButton("View Payroll Information");

        addEmployee.addActionListener(e -> { /* TODO: Add employee. */ });
        updateEmployee.addActionListener(e -> { /* TODO: Update employee. */ });
        deleteEmployee.addActionListener(e -> { /* TODO: Delete employee. */ });
        viewEmployees.addActionListener(e -> { /* TODO: View all employees. */ });
        addHR.addActionListener(e -> { /* TODO: Add HR information. */ });
        updateHR.addActionListener(e -> { /* TODO: Update HR information. */ });
        viewHR.addActionListener(e -> { /* TODO: View HR information. */ });
        addPayroll.addActionListener(e -> { /* TODO: Add payroll information. */ });
        updatePayroll.addActionListener(e -> { /* TODO: Update payroll information. */ });
        viewPayroll.addActionListener(e -> { /* TODO: View payroll information. */ });

        frame.add(addEmployee);
        frame.add(updateEmployee);
        frame.add(deleteEmployee);
        frame.add(viewEmployees);
        frame.add(addHR);
        frame.add(updateHR);
        frame.add(viewHR);
        frame.add(addPayroll);
        frame.add(updatePayroll);
        frame.add(viewPayroll);

        // TODO: Implement the JDBC methods called by the buttons.
        // HINT: JOptionPane is convenient for employee IDs, names, HR info, and salary.
        frame.setSize(650, 420);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
