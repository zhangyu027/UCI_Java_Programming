package instructor.inclass.m3.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Canvas-aligned Module 3 calculator reference solution. */
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
        if (command.matches("[0-9]")) {
            if (startNewNumber) {
                display.setText("");
                startNewNumber = false;
            }
            display.setText(display.getText() + command);
            return;
        }

        if (command.equals("C")) {
            display.setText("");
            firstNumber = 0;
            operator = null;
            startNewNumber = true;
            return;
        }

        if (command.equals("=")) {
            calculateResult();
            return;
        }

        if (display.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Enter a number first.");
            return;
        }

        firstNumber = Double.parseDouble(display.getText());
        operator = command;
        startNewNumber = true;
    }

    private void calculateResult() {
        if (operator == null || display.getText().isEmpty()) {
            return;
        }

        double secondNumber = Double.parseDouble(display.getText());
        double result;

        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    JOptionPane.showMessageDialog(frame, "Cannot divide by zero.");
                    return;
                }
                result = firstNumber / secondNumber;
                break;
            default:
                return;
        }

        display.setText(String.valueOf(result));
        startNewNumber = true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorAppV2();
            }
        });
    }
}
