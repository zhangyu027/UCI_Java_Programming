package inclass.m2;

/*
* IN-CLASS STUDENT HINTS
* ----------------------
* Work incrementally. Run after each small change.
* For file I/O, use try-with-resources.
* For Swing, separate component setup from event-handler logic.
*/
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/** Module 2 practice: build a small Swing user-information form. */
public class UserInformationForm {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserInformationForm::createAndShowGui);
    }
    private static void createAndShowGui() {
        JFrame frame = new JFrame("User Information Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JButton submitButton = new JButton("Submit");
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel(""));
        panel.add(submitButton);
        // TODO: Add an ActionListener to the button.
        // TODO: Validate that required fields are not empty.
        // TODO: Display or save the entered information.
        /*
        * HINT:
        * submitButton.addActionListener(event -> {
        *     String name = nameField.getText().trim();
        *     String email = emailField.getText().trim();
        *     // validate and display the values
        * });
        */
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
