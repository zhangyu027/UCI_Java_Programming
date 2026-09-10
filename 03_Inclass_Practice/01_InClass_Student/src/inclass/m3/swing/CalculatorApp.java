package inclass.m3.swing;

/*
* IN-CLASS STUDENT HINTS
* ----------------------
* Focus on object-oriented structure:
* - fields describe object state;
* - constructors initialize objects;
* - methods describe behavior;
* - inheritance reuses/extends behavior;
* - polymorphism lets a parent reference call overridden child behavior.
*/
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/** Module 3 practice: small Swing calculator. */
public class CalculatorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorApp::createAndShowGui);
    }
    private static void createAndShowGui() {
        JFrame frame = new JFrame("Calculator Starter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField firstField = new JTextField();
        JTextField secondField = new JTextField();
        JLabel resultLabel = new JLabel("Result: ");
        JButton addButton = new JButton("Add");
        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));
        panel.add(new JLabel("First number:"));
        panel.add(firstField);
        panel.add(new JLabel("Second number:"));
        panel.add(secondField);
        panel.add(addButton);
        panel.add(resultLabel);
        // TODO: Add event handling for Add.
        // TODO: Add subtract/multiply/divide if requested by the lab.
        // TODO: Handle invalid numeric input.
        /*
        * HINT:
        * double a = Double.parseDouble(firstField.getText());
        * double b = Double.parseDouble(secondField.getText());
        * resultLabel.setText("Result: " + (a + b));
        */
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
