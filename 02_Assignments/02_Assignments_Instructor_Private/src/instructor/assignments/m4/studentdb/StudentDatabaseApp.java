package instructor.assignments.m4.studentdb;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
* Instructor reference solution for Module 4:
* Swing + MariaDB CRUD.
*/
public class StudentDatabaseApp extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JTextField idField = new JTextField();
    private final JTextField firstNameField = new JTextField();
    private final JTextField lastNameField = new JTextField();
    private final JTextField emailField = new JTextField();
    private final JTextField majorField = new JTextField();
    private final JTextArea outputArea = new JTextArea(14, 60);
    public StudentDatabaseApp() {
        super("University Students - Instructor Solution");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel fields = new JPanel(new GridLayout(0, 2, 8, 8));
        fields.add(new JLabel("Student ID:"));
        fields.add(idField);
        fields.add(new JLabel("First Name:"));
        fields.add(firstNameField);
        fields.add(new JLabel("Last Name:"));
        fields.add(lastNameField);
        fields.add(new JLabel("Email:"));
        fields.add(emailField);
        fields.add(new JLabel("Major:"));
        fields.add(majorField);
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton displayButton = new JButton("Display");
        JPanel buttons = new JPanel();
        buttons.add(addButton);
        buttons.add(updateButton);
        buttons.add(deleteButton);
        buttons.add(displayButton);
        addButton.addActionListener(e -> addStudent());
        updateButton.addActionListener(e -> updateStudent());
        deleteButton.addActionListener(e -> deleteStudent());
        displayButton.addActionListener(e -> displayStudents());
        outputArea.setEditable(false);
        add(fields, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
    }
    private void addStudent() {
        String sql = """
        INSERT INTO Students
        (student_id, first_name, last_name, email, major)
        VALUES(?, ?, ?, ?, ?)
        """;
        try(Connection connection = Db.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            int studentId = readStudentId();
            ps.setInt(1, studentId);
            ps.setString(2, required(firstNameField, "First name"));
            ps.setString(3, required(lastNameField, "Last name"));
            ps.setString(4, emailField.getText().trim());
            ps.setString(5, majorField.getText().trim());
            ps.executeUpdate();
            displayStudents();
        } catch (Exception e) {
            showError(e);
        }
    }
    private void updateStudent() {
        String sql = """
        UPDATE Students
        SET first_name = ?,
        last_name = ?,
        email = ?,
        major = ?
        WHERE student_id = ?
        """;
        try(Connection connection = Db.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            int studentId = readStudentId();
            ps.setString(1, required(firstNameField, "First name"));
            ps.setString(2, required(lastNameField, "Last name"));
            ps.setString(3, emailField.getText().trim());
            ps.setString(4, majorField.getText().trim());
            ps.setInt(5, studentId);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new IllegalArgumentException(
                "No student found with ID " + studentId);
            }
            displayStudents();
        } catch (Exception e) {
            showError(e);
        }
    }
    private void deleteStudent() {
        String sql = """
        DELETE FROM Students
        WHERE student_id = ?
        """;
        try(Connection connection = Db.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            int studentId = readStudentId();
            ps.setInt(1, studentId);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new IllegalArgumentException(
                "No student found with ID " + studentId);
            }
            displayStudents();
        } catch (Exception e) {
            showError(e);
        }
    }
    private void displayStudents() {
        String sql = """
        SELECT student_id,
        first_name,
        last_name,
        email,
        major
        FROM Students
        ORDER BY student_id
        """;
        StringBuilder text = new StringBuilder();
        try(Connection connection = Db.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql)) {
            text.append(
            "ID | First Name | Last Name | Email | Major\n");
            text.append(
            "------------------------------------------------------------\n");
            while (rs.next()) {
                text.append(rs.getInt("student_id"))
                .append(" | ")
                .append(rs.getString("first_name"))
                .append(" | ")
                .append(rs.getString("last_name"))
                .append(" | ")
                .append(rs.getString("email"))
                .append(" | ")
                .append(rs.getString("major"))
                .append("\n");
            }
            outputArea.setText(text.toString());
        } catch (Exception e) {
            showError(e);
        }
    }
    private int readStudentId() {
        String text = idField.getText().trim();
        if (text.isEmpty()) {
            throw new IllegalArgumentException(
            "Student ID is required.");
        }
        return Integer.parseInt(text);
    }
    private String required(
    JTextField field,
    String fieldName) {
        String value = field.getText().trim();
        if (value.isEmpty()) {
            throw new IllegalArgumentException(
            fieldName + " is required.");
        }
        return value;
    }
    private void showError(Exception e) {
        JOptionPane.showMessageDialog(
        this,
        e.getMessage(),
        "Database Error",
        JOptionPane.ERROR_MESSAGE);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
        () -> new StudentDatabaseApp().setVisible(true));
    }
}
