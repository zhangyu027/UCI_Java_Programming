package instructor.inclass.m2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
                String name = nameField.getText();
                String email = emailField.getText();
                String result = "Name: " + name + "\nEmail: " + email;
                resultArea.setText(result);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                emailField.setText("");
                resultArea.setText("");
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
