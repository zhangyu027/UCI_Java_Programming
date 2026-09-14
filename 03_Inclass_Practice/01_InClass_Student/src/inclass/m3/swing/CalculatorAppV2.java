package inclass.m3.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Canvas-aligned Module 3 calculator student starter. */
public class CalculatorAppV2 {
    private JFrame frame;
    private JTextField display;
    private double firstNumber;
    private String operator;
    private boolean startNewNumber = true;

    public CalculatorAppV2() {
        frame = new JFrame("Calculator - Canvas Version");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        frame.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleButton(e.getActionCommand());
            }
        };

        for (String label : buttons) {
            JButton button = new JButton(label);
            button.addActionListener(listener);
            buttonPanel.add(button);
        }

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setSize(320, 360);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void handleButton(String command) {
        // TODO 1: If command is a digit, display it.
        // TODO 2: If command is C, reset the calculator.
        // TODO 3: If command is +, -, *, or /, save the first number and operator.
        // TODO 4: If command is =, calculate and display the result.
        // TODO 5: Handle division by zero with a meaningful message.
        /*
         * HINT:
         * Use Double.parseDouble(display.getText()) to read a number.
         * Use JOptionPane.showMessageDialog(...) for an error message.
         */
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorAppV2();
            }
        });
    }
}
