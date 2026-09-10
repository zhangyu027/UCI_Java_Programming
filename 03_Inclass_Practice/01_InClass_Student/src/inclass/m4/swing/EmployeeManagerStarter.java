package inclass.m4.swing;

/*
* IN-CLASS STUDENT HINTS - SWING
* ------------------------------
* Build the screen first, then wire the buttons.
* Keep component creation, validation, and button actions in small methods.
*
* CHECKPOINT:
* A button click should trigger one clear task and give the user visible feedback.
*/
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/** Step 1: build the Employee Manager GUI before adding JDBC. */
public class EmployeeManagerStarter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Employee Manager Starter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTextField nameField = new JTextField(18);
            JButton addButton = new JButton("Add Employee");
            JPanel top = new JPanel(new FlowLayout());
            top.add(new JLabel("Name:"));
            top.add(nameField);
            top.add(addButton);
            frame.add(top, BorderLayout.NORTH);
            frame.add(
            new JLabel("TODO: Add Update, Delete, and Display."),
            BorderLayout.CENTER);
            // TODO: Add Update, Delete, and Display buttons.
            // TODO: Add an output JTextArea.
            // TODO: Add event handlers.
            // HINT: finish the GUI before connecting JDBC.
            frame.setSize(620, 280);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
