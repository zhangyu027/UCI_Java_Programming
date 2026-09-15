package instructor.assignments.m6.project5;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/** Java Project V - Employee Management (Swing), Canvas-aligned instructor reference. */
public class EmployeeManagementGUI {
    private static final String URL = System.getenv().getOrDefault(
            "UCI_EMPLOYEE_DB_URL", "jdbc:mariadb://127.0.0.1:3306/EmployeeManagement");
    private static final String USER = System.getenv().getOrDefault("UCI_DB_USER", "javauser");
    private static final String PASSWORD = System.getenv().getOrDefault("UCI_DB_PASSWORD", "JavaClass2026");

    public static void main(String[] args) {
        createTables();
        SwingUtilities.invokeLater(EmployeeManagementGUI::createAndShowGUI);
    }

    private static Connection open() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void createTables() {
        try (Connection c = open(); Statement statement = c.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS employee(id INT PRIMARY KEY, name VARCHAR(255), position VARCHAR(255))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS hr(employee_id INT PRIMARY KEY, hr_info VARCHAR(255), FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS payroll(employee_id INT PRIMARY KEY, salary DECIMAL(10,2), FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE)");
        } catch (Exception e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Employee Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 2, 8, 8));

        addButton(frame, "Add Employee", () -> addEmployee(frame));
        addButton(frame, "Update Employee", () -> updateEmployee(frame));
        addButton(frame, "Delete Employee", () -> deleteEmployee(frame));
        addButton(frame, "View All Employees", () -> viewEmployees(frame));
        addButton(frame, "Add HR Information", () -> addHR(frame));
        addButton(frame, "Update HR Information", () -> updateHR(frame));
        addButton(frame, "View HR Information", () -> viewHR(frame));
        addButton(frame, "Add Payroll Information", () -> addPayroll(frame));
        addButton(frame, "Update Payroll Information", () -> updatePayroll(frame));
        addButton(frame, "View Payroll Information", () -> viewPayroll(frame));

        frame.setSize(650, 420);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void addButton(JFrame frame, String text, Runnable action) {
        JButton button = new JButton(text);
        button.addActionListener(e -> action.run());
        frame.add(button);
    }

    private static Integer askId(JFrame frame, String prompt) {
        String value = JOptionPane.showInputDialog(frame, prompt);
        if (value == null || value.isBlank()) return null;
        return Integer.parseInt(value.trim());
    }

    private static void addEmployee(JFrame frame) {
        try {
            Integer id = askId(frame, "Employee ID:");
            if (id == null) return;
            String name = JOptionPane.showInputDialog(frame, "Name:");
            String position = JOptionPane.showInputDialog(frame, "Position:");
            if (name == null || position == null) return;
            try (Connection c = open(); PreparedStatement ps = c.prepareStatement("INSERT INTO employee(id,name,position) VALUES(?,?,?)")) {
                ps.setInt(1, id); ps.setString(2, name.trim()); ps.setString(3, position.trim()); ps.executeUpdate();
            }
            JOptionPane.showMessageDialog(frame, "Employee added successfully.");
        } catch (Exception e) { showError(frame, e); }
    }

    private static void updateEmployee(JFrame frame) {
        try {
            Integer id = askId(frame, "Employee ID to update:");
            if (id == null) return;
            String name = JOptionPane.showInputDialog(frame, "New name:");
            String position = JOptionPane.showInputDialog(frame, "New position:");
            if (name == null || position == null) return;
            try (Connection c = open(); PreparedStatement ps = c.prepareStatement("UPDATE employee SET name=?,position=? WHERE id=?")) {
                ps.setString(1, name.trim()); ps.setString(2, position.trim()); ps.setInt(3, id);
                JOptionPane.showMessageDialog(frame, ps.executeUpdate() > 0 ? "Employee updated successfully." : "Employee ID not found.");
            }
        } catch (Exception e) { showError(frame, e); }
    }

    private static void deleteEmployee(JFrame frame) {
        try {
            Integer id = askId(frame, "Employee ID to delete:");
            if (id == null) return;
            try (Connection c = open(); PreparedStatement ps = c.prepareStatement("DELETE FROM employee WHERE id=?")) {
                ps.setInt(1, id);
                JOptionPane.showMessageDialog(frame, ps.executeUpdate() > 0 ? "Employee deleted successfully." : "Employee ID not found.");
            }
        } catch (Exception e) { showError(frame, e); }
    }

    private static void viewEmployees(JFrame frame) {
        StringBuilder out = new StringBuilder("Employees:\n");
        try (Connection c = open(); ResultSet rs = c.createStatement().executeQuery("SELECT id,name,position FROM employee ORDER BY id")) {
            while (rs.next()) out.append(rs.getInt("id")).append(" | ").append(rs.getString("name")).append(" | ").append(rs.getString("position")).append('\n');
            JOptionPane.showMessageDialog(frame, out.length() == 11 ? "No employees." : out.toString());
        } catch (Exception e) { showError(frame, e); }
    }

    private static void addHR(JFrame frame) {
        try {
            Integer id = askId(frame, "Employee ID:");
            if (id == null) return;
            String info = JOptionPane.showInputDialog(frame, "HR information:");
            if (info == null) return;
            try (Connection c = open(); PreparedStatement ps = c.prepareStatement("INSERT INTO hr(employee_id,hr_info) VALUES(?,?)")) {
                ps.setInt(1, id); ps.setString(2, info.trim()); ps.executeUpdate();
            }
            JOptionPane.showMessageDialog(frame, "HR information added.");
        } catch (Exception e) { showError(frame, e); }
    }

    private static void updateHR(JFrame frame) {
        try {
            Integer id = askId(frame, "Employee ID:");
            if (id == null) return;
            String info = JOptionPane.showInputDialog(frame, "New HR information:");
            if (info == null) return;
            try (Connection c = open(); PreparedStatement ps = c.prepareStatement("UPDATE hr SET hr_info=? WHERE employee_id=?")) {
                ps.setString(1, info.trim()); ps.setInt(2, id);
                JOptionPane.showMessageDialog(frame, ps.executeUpdate() > 0 ? "HR information updated." : "HR record not found.");
            }
        } catch (Exception e) { showError(frame, e); }
    }

    private static void viewHR(JFrame frame) {
        try {
            Integer id = askId(frame, "Employee ID:");
            if (id == null) return;
            try (Connection c = open(); PreparedStatement ps = c.prepareStatement("SELECT e.name,h.hr_info FROM employee e JOIN hr h ON e.id=h.employee_id WHERE e.id=?")) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    JOptionPane.showMessageDialog(frame, rs.next() ? rs.getString("name") + " | HR: " + rs.getString("hr_info") : "HR record not found.");
                }
            }
        } catch (Exception e) { showError(frame, e); }
    }

    private static void addPayroll(JFrame frame) {
        try {
            Integer id = askId(frame, "Employee ID:");
            if (id == null) return;
            String value = JOptionPane.showInputDialog(frame, "Salary:");
            if (value == null) return;
            try (Connection c = open(); PreparedStatement ps = c.prepareStatement("INSERT INTO payroll(employee_id,salary) VALUES(?,?)")) {
                ps.setInt(1, id); ps.setDouble(2, Double.parseDouble(value.trim())); ps.executeUpdate();
            }
            JOptionPane.showMessageDialog(frame, "Payroll information added.");
        } catch (Exception e) { showError(frame, e); }
    }

    private static void updatePayroll(JFrame frame) {
        try {
            Integer id = askId(frame, "Employee ID:");
            if (id == null) return;
            String value = JOptionPane.showInputDialog(frame, "New salary:");
            if (value == null) return;
            try (Connection c = open(); PreparedStatement ps = c.prepareStatement("UPDATE payroll SET salary=? WHERE employee_id=?")) {
                ps.setDouble(1, Double.parseDouble(value.trim())); ps.setInt(2, id);
                JOptionPane.showMessageDialog(frame, ps.executeUpdate() > 0 ? "Payroll information updated." : "Payroll record not found.");
            }
        } catch (Exception e) { showError(frame, e); }
    }

    private static void viewPayroll(JFrame frame) {
        try {
            Integer id = askId(frame, "Employee ID:");
            if (id == null) return;
            try (Connection c = open(); PreparedStatement ps = c.prepareStatement("SELECT e.name,p.salary FROM employee e JOIN payroll p ON e.id=p.employee_id WHERE e.id=?")) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    JOptionPane.showMessageDialog(frame, rs.next() ? rs.getString("name") + " | Salary: " + rs.getBigDecimal("salary") : "Payroll record not found.");
                }
            }
        } catch (Exception e) { showError(frame, e); }
    }

    private static void showError(JFrame frame, Exception e) {
        JOptionPane.showMessageDialog(frame, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
