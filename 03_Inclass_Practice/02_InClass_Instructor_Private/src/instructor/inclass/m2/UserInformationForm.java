package instructor.inclass.m2;

import javax.swing.*;
import java.awt.*;

public class UserInformationForm extends JFrame {
    public UserInformationForm() {
        super("User Information");
        JTextField name = new JTextField();
        JTextField email = new JTextField();
        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.add(new JLabel("Name"));
        panel.add(name);
        panel.add(new JLabel("Email"));
        panel.add(email);
        JButton submit = new JButton("Submit");
        JButton clear = new JButton("Clear");
        submit.addActionListener(e -> {
            if (name.getText().isBlank() || email.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "All fields are required.");
            } else {
                JOptionPane.showMessageDialog(this, "Name: " + name.getText() + "\nEmail: " + email.getText());
            }
        });
        clear.addActionListener(e -> {
            name.setText(""); email.setText("");
        });
        panel.add(submit);
        panel.add(clear);
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 180);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserInformationForm().setVisible(true));
    }
}
