package inclass.m2;

/*
 * IN-CLASS STUDENT HINTS
 * ----------------------
 * This starter follows the Canvas User Information Form structure.
 * Work incrementally and run after each small change.
 * Practice JFrame, JPanel, GridLayout, JTextField, JTextArea,
 * JButton, and traditional ActionListener event handling.
 * Complete the TODO sections instead of replacing the whole program.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** Module 2 practice: build a Swing user-information form. */
public class UserInformationForm {

    private JFrame frame;
    private JTextField nameField;
    private JTextField emailField;
    private JTextArea resultArea;

    public UserInformationForm() {

        frame = new JFrame("User Information Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(3, 2));

        nameField = new JTextField(20);
        emailField = new JTextField(20);

        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");

        resultArea = new JTextArea(5, 40);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(submitButton);
        formPanel.add(clearButton);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // TODO 1: Get the name from nameField.
                // TODO 2: Get the email from emailField.
                // TODO 3: Build a result String containing both values.
                // TODO 4: Display the result in resultArea.

                /*
                 * HINT / CODE PATTERN:
                 * String name = nameField.getText();
                 * String email = emailField.getText();
                 * String result = "Name: " + name + "\nEmail: " + email;
                 * resultArea.setText(result);
                 */
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // TODO 5: Clear nameField.
                // TODO 6: Clear emailField.
                // TODO 7: Clear resultArea.

                /*
                 * HINT:
                 * component.setText("");
                 */
            }
        });

        frame.add(formPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UserInformationForm();
            }
        });
    }
}
