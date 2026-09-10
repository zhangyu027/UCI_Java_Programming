package inclass.m4.db;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/** Instructor reference: Swing employee CRUD backed by company_db. */
public class EmployeeManager extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JTextField nameField = new JTextField(18);
    private final JTextArea outputArea = new JTextArea();
    public EmployeeManager() {
        super("Employee Manager");
        JPanel top = new JPanel(new FlowLayout());
        top.add(new JLabel("Name:"));
        top.add(nameField);
        for (String label : new String[] {
            "Add", "Update", "Delete", "Display"
        }) {
            JButton button = new JButton(label);
            button.addActionListener(e -> runAction(label));
            top.add(button);
        }
        outputArea.setEditable(false);
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(680, 420);
        setLocationRelativeTo(null);
    }
    private void runAction(String action) {
        try {
            switch (action) {
                case "Add" -> addEmployee();
                case "Update" -> updateEmployee();
                case "Delete" -> deleteEmployee();
                default -> displayEmployees();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private int askId() {
        String input = JOptionPane.showInputDialog(this, "Employee ID:");
        return Integer.parseInt(input);
    }
    private void addEmployee() throws SQLException {
        String name = nameField.getText().trim();
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name is required.");
        }
        String sql = "INSERT INTO employees(name) VALUES(?)";
        try(Connection connection = Db.open("company_db");
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.executeUpdate();
        }
        displayEmployees();
    }
    private void updateEmployee() throws SQLException {
        int id = askId();
        String name = nameField.getText().trim();
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name is required.");
        }
        String sql = "UPDATE employees SET name = ? WHERE id = ?";
        try(Connection connection = Db.open("company_db");
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
        displayEmployees();
    }
    private void deleteEmployee() throws SQLException {
        int id = askId();
        String sql = "DELETE FROM employees WHERE id = ?";
        try(Connection connection = Db.open("company_db");
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        displayEmployees();
    }
    private void displayEmployees() throws SQLException {
        String sql = "SELECT id, name FROM employees ORDER BY id";
        StringBuilder text = new StringBuilder();
        try(Connection connection = Db.open("company_db");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                text.append(rs.getInt("id"))
                .append(" | ")
                .append(rs.getString("name"))
                .append('\n');
            }
        }
        outputArea.setText(text.toString());
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
        () -> new EmployeeManager().setVisible(true));
    }
}
