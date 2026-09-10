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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/** Step 1: build the hamburger-order GUI before adding JDBC. */
public class HamburgerOrderStarter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hamburger Order System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(
            new JLabel("TODO: Build order controls"),
            BorderLayout.CENTER);
            frame.add(
            new JButton("Calculate Total"),
            BorderLayout.SOUTH);
            // TODO: Add menu-item controls and quantities.
            // TODO: Calculate and display the order total.
            // HINT: keep price constants separate from GUI code.
            frame.setSize(520, 260);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
