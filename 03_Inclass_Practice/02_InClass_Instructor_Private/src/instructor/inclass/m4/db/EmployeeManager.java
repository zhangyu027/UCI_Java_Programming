package instructor.inclass.m4.db;

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

/**
 * Instructor reference:
 * Swing Employee CRUD application backed by company_db.
 *
 * Database:
 *   company_db
 *
 * Table:
 *   employees
 *
 * Columns:
 *   id   INT AUTO_INCREMENT PRIMARY KEY
 *   name VARCHAR(100) NOT NULL
 */
public class EmployeeManager extends JFrame {

    private static final long serialVersionUID = 1L;

    private static final String DATABASE = "company_db";

    private final JTextField nameField = new JTextField(18);
    private final JTextArea outputArea = new JTextArea();

    /**
     * Creates the Employee Manager GUI.
     */
    public EmployeeManager() {

        super("Employee Manager");

        JPanel top = new JPanel(new FlowLayout());

        top.add(new JLabel("Name:"));
        top.add(nameField);

        String[] buttons = {
                "Add",
                "Update",
                "Delete",
                "Display"
        };

        for (String label : buttons) {

            JButton button = new JButton(label);

            button.addActionListener(
                    e -> runAction(label)
            );

            top.add(button);
        }

        outputArea.setEditable(false);

        add(top, BorderLayout.NORTH);
        add(
                new JScrollPane(outputArea),
                BorderLayout.CENTER
        );

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(680, 420);
        setLocationRelativeTo(null);
    }

    /**
     * Runs the selected CRUD operation.
     */
    private void runAction(String action) {

        try {

            switch (action) {

                case "Add" ->
                    addEmployee();

                case "Update" ->
                    updateEmployee();

                case "Delete" ->
                    deleteEmployee();

                case "Display" ->
                    displayEmployees();

                default ->
                    throw new IllegalArgumentException(
                            "Unknown action: " + action
                    );
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            // Helpful for debugging in Eclipse Console
            e.printStackTrace();
        }
    }

    /**
     * Prompts the user for an employee ID.
     */
    private int askId() {

        String input = JOptionPane.showInputDialog(
                this,
                "Employee ID:"
        );

        if (input == null) {
            throw new IllegalArgumentException(
                    "Operation cancelled."
            );
        }

        input = input.trim();

        if (input.isBlank()) {
            throw new IllegalArgumentException(
                    "Employee ID is required."
            );
        }

        try {

            return Integer.parseInt(input);

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException(
                    "Employee ID must be a number."
            );
        }
    }

    /**
     * Adds a new employee to company_db.employees.
     */
    private void addEmployee() throws SQLException {

        String name = nameField.getText().trim();

        if (name.isBlank()) {
            throw new IllegalArgumentException(
                    "Name is required."
            );
        }

        String sql =
                "INSERT INTO employees(name) VALUES(?)";

        try (
                Connection connection =
                        Db.open(DATABASE);

                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setString(1, name);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Employee added successfully."
                );
            }
        }

        nameField.setText("");

        displayEmployees();
    }

    /**
     * Updates an existing employee.
     */
    private void updateEmployee() throws SQLException {

        int id = askId();

        String name = nameField.getText().trim();

        if (name.isBlank()) {
            throw new IllegalArgumentException(
                    "Name is required."
            );
        }

        String sql =
                "UPDATE employees "
                + "SET name = ? "
                + "WHERE id = ?";

        try (
                Connection connection =
                        Db.open(DATABASE);

                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setString(1, name);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows == 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Employee ID " + id
                                + " was not found."
                );

                return;
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Employee updated successfully."
            );
        }

        nameField.setText("");

        displayEmployees();
    }

    /**
     * Deletes an employee.
     */
    private void deleteEmployee() throws SQLException {

        int id = askId();

        String sql =
                "DELETE FROM employees "
                + "WHERE id = ?";

        try (
                Connection connection =
                        Db.open(DATABASE);

                PreparedStatement ps =
                        connection.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows == 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Employee ID " + id
                                + " was not found."
                );

                return;
            }

            JOptionPane.showMessageDialog(
                    this,
                    "Employee deleted successfully."
            );
        }

        displayEmployees();
    }

    /**
     * Displays all employees from company_db.
     */
    private void displayEmployees() throws SQLException {

        String sql =
                "SELECT id, name "
                + "FROM employees "
                + "ORDER BY id";

        StringBuilder text = new StringBuilder();

        try (
                Connection connection =
                        Db.open(DATABASE);

                Statement statement =
                        connection.createStatement();

                ResultSet rs =
                        statement.executeQuery(sql)
        ) {

            while (rs.next()) {

                text.append(rs.getInt("id"))
                    .append(" | ")
                    .append(rs.getString("name"))
                    .append('\n');
            }
        }

        if (text.length() == 0) {

            outputArea.setText(
                    "No employees found."
            );

        } else {

            outputArea.setText(
                    text.toString()
            );
        }
    }

    /**
     * Application entry point.
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {

                    EmployeeManager manager =
                            new EmployeeManager();

                    manager.setVisible(true);
                }
        );
    }
}