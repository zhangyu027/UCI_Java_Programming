package assignment.m4.studentdb;

/*
* STUDENT HINTS - MODULE 4 DATABASE
* ---------------------------------
* Recommended sequence:
* 1. Run sql/university_setup.sql.
* 2. Add MariaDB Connector/J to Eclipse Classpath.
* 3. Configure UCI_DB_URL, UCI_DB_USER, and UCI_DB_PASSWORD.
* 4. Run DatabaseConnectionTest.
* 5. Implement addStudent(), updateStudent(), deleteStudent(), displayStudents().
*
* KEY TABLE:
* Students(student_id, first_name, last_name, email, major)
*
* JDBC PATTERN:
* try(Connection con = Db.getConnection();
*      PreparedStatement ps = con.prepareStatement(sql)) {
*     // set ? parameters
*     // executeUpdate() or executeQuery()
* }
*
* ANSWER CHECKPOINT:
* Use ? parameters; do not concatenate user-entered values into SQL.
*/
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
* Module 4 Assignment Starter
* Swing + MariaDB Student Database
*
* STUDENT GOAL:
* Implement Add, Update, Delete, and Display using JDBC.
*
* Complete the TODO sections in order.
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
        super("University Students - Module 4");
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
        outputArea.setEditable(false);
        add(fields, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        /*
        * TODO 1:
        * Connect each button to the matching method.
        *
        * HINT:
        * addButton.addActionListener(e -> addStudent());
        *
        * Repeat for update, delete, and display.
        */
        /*
        * ANSWER CHECKPOINT:
        * When finished, each button should call exactly one method:
        * addStudent(), updateStudent(), deleteStudent(), displayStudents().
        */
        pack();
        setLocationRelativeTo(null);
    }
    private void addStudent() {
        /*
        * TODO 2:
        * 1. Read and validate all five input fields.
        * 2. Use INSERT with PreparedStatement.
        * 3. Call displayStudents() after a successful insert.
        *
        * HINT SQL:
        * INSERT INTO Students
        * (student_id, first_name, last_name, email, major)
        * VALUES(?, ?, ?, ?, ?)
        */
        JOptionPane.showMessageDialog(
        this,
        "TODO: Implement Add Student.");
    }
    private void updateStudent() {
        /*
        * TODO 3:
        * Update the selected student ID.
        *
        * HINT SQL:
        * UPDATE Students
        * SET first_name = ?, last_name = ?, email = ?, major = ?
        * WHERE student_id = ?
        *
        * HINT:
        * The ID identifies the existing record.
        * The other fields contain the new values.
        */
        JOptionPane.showMessageDialog(
        this,
        "TODO: Implement Update Student.");
    }
    private void deleteStudent() {
        /*
        * TODO 4:
        * Delete the record identified by student_id.
        *
        * HINT SQL:
        * DELETE FROM Students
        * WHERE student_id = ?
        *
        * ANSWER CHECKPOINT:
        * Use PreparedStatement. Do not concatenate raw user input.
        */
        JOptionPane.showMessageDialog(
        this,
        "TODO: Implement Delete Student.");
    }
    private void displayStudents() {
        /*
        * TODO 5:
        * Run:
        * SELECT * FROM Students ORDER BY student_id
        *
        * Then use:
        * while (resultSet.next()) { ... }
        *
        * Append each row to a StringBuilder and display it
        * in outputArea.
        */
        outputArea.setText(
        "TODO: Implement Display Students.\n");
    }
    /*
    * OPTIONAL HELPER:
    * Students may use this method to validate Student ID.
    *
    * Example:
    * int studentId = readStudentId();
    */
    private int readStudentId() {
        String text = idField.getText().trim();
        if (text.isEmpty()) {
            throw new IllegalArgumentException(
            "Student ID is required.");
        }
        return Integer.parseInt(text);
    }
    /*
    * OPTIONAL HELPER:
    * Use this pattern around database work:
    *
    * try(Connection connection = Db.getConnection();
    *      PreparedStatement ps = connection.prepareStatement(sql)) {
    *
    *     // set parameters
    *     // executeUpdate() or executeQuery()
    *
    * } catch (Exception e) {
    *     JOptionPane.showMessageDialog(
    *             this,
    *             e.getMessage(),
    *             "Database Error",
    *             JOptionPane.ERROR_MESSAGE);
    * }
    */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
        () -> new StudentDatabaseApp().setVisible(true));
    }
}
