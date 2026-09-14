package assignments.m4.studentdb;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

/** Module 4 Assignment Starter: Swing + MariaDB Student Database. */
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
        fields.add(new JLabel("Student ID:")); fields.add(idField);
        fields.add(new JLabel("First Name:")); fields.add(firstNameField);
        fields.add(new JLabel("Last Name:")); fields.add(lastNameField);
        fields.add(new JLabel("Email:")); fields.add(emailField);
        fields.add(new JLabel("Major:")); fields.add(majorField);
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton displayButton = new JButton("Display");
        JPanel buttons = new JPanel();
        buttons.add(addButton); buttons.add(updateButton); buttons.add(deleteButton); buttons.add(displayButton);
        outputArea.setEditable(false);
        add(fields, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        // TODO 1: Connect each button to its matching method.
        // TODO 2: Implement Add with PreparedStatement.
        // TODO 3: Implement Update with PreparedStatement.
        // TODO 4: Implement Delete with PreparedStatement.
        // TODO 5: Implement Display using SELECT * FROM Students ORDER BY student_id.
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentDatabaseApp().setVisible(true));
    }
}
