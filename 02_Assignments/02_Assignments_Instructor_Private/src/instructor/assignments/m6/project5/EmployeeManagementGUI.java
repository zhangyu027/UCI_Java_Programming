package instructor.assignments.m6.project5;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/** Java Project V - Employee Management (Swing), instructor reference. */
public class EmployeeManagementGUI {
    private static final String URL = System.getenv().getOrDefault(
            "UCI_EMPLOYEE_DB_URL", "jdbc:mariadb://127.0.0.1:3306/EmployeeManagement");
    private static final String USER = System.getenv().getOrDefault("UCI_DB_USER", "javauser");
    private static final String PASSWORD = System.getenv().getOrDefault("UCI_DB_PASSWORD", "JavaClass2026");

    public static void main(String[] args) {
        createTables();
        SwingUtilities.invokeLater(EmployeeManagementGUI::createAndShowGUI);
    }

    private static Connection open() throws Exception { return DriverManager.getConnection(URL, USER, PASSWORD); }

    private static void createTables() {
        try (Connection c = open()) {
            c.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS employee(id INT PRIMARY KEY, name VARCHAR(255), position VARCHAR(255))");
            c.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS hr(employee_id INT PRIMARY KEY, hr_info VARCHAR(255))");
            c.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS payroll(employee_id INT PRIMARY KEY, salary DECIMAL(10,2))");
        } catch (Exception e) { System.err.println("Database error: " + e.getMessage()); }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Employee Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1, 6, 6));
        JButton add = new JButton("Add Employee");
        JButton update = new JButton("Update Employee");
        JButton delete = new JButton("Delete Employee");
        JButton view = new JButton("View All Employees");
        add.addActionListener(e -> addEmployee(frame));
        update.addActionListener(e -> updateEmployee(frame));
        delete.addActionListener(e -> deleteEmployee(frame));
        view.addActionListener(e -> viewEmployees(frame));
        frame.add(add); frame.add(update); frame.add(delete); frame.add(view);
        frame.setSize(380, 320); frame.setLocationRelativeTo(null); frame.setVisible(true);
    }

    private static void addEmployee(JFrame frame) {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "Employee ID:"));
            String name = JOptionPane.showInputDialog(frame, "Name:");
            String position = JOptionPane.showInputDialog(frame, "Position:");
            try (Connection c = open(); PreparedStatement ps = c.prepareStatement("INSERT INTO employee(id,name,position) VALUES(?,?,?)")) {
                ps.setInt(1, id); ps.setString(2, name); ps.setString(3, position); ps.executeUpdate();
            }
        } catch (Exception e) { JOptionPane.showMessageDialog(frame, e.getMessage()); }
    }

    private static void updateEmployee(JFrame frame) {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "Employee ID:"));
            String position = JOptionPane.showInputDialog(frame, "New position:");
            try (Connection c = open(); PreparedStatement ps = c.prepareStatement("UPDATE employee SET position=? WHERE id=?")) {
                ps.setString(1, position); ps.setInt(2, id); ps.executeUpdate();
            }
        } catch (Exception e) { JOptionPane.showMessageDialog(frame, e.getMessage()); }
    }

    private static void deleteEmployee(JFrame frame) {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog(frame, "Employee ID:"));
            try (Connection c = open(); PreparedStatement ps = c.prepareStatement("DELETE FROM employee WHERE id=?")) {
                ps.setInt(1, id); ps.executeUpdate();
            }
        } catch (Exception e) { JOptionPane.showMessageDialog(frame, e.getMessage()); }
    }

    private static void viewEmployees(JFrame frame) {
        StringBuilder out = new StringBuilder();
        try (Connection c = open(); ResultSet rs = c.createStatement().executeQuery("SELECT id,name,position FROM employee ORDER BY id")) {
            while (rs.next()) out.append(rs.getInt(1)).append(" | ").append(rs.getString(2)).append(" | ").append(rs.getString(3)).append('\n');
            JOptionPane.showMessageDialog(frame, out.length() == 0 ? "No employees." : out.toString());
        } catch (Exception e) { JOptionPane.showMessageDialog(frame, e.getMessage()); }
    }
}
