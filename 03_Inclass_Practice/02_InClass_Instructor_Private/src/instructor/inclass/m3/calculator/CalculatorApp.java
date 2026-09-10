package instructor.inclass.m3.calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorApp extends JFrame {
    private final JTextField display=new JTextField();
    private double first=0;
    private String op="";
    private boolean fresh=true;
    public CalculatorApp() {
        super("Calculator");
        display.setEditable(false);
        add(display, BorderLayout.NORTH);
        JPanel grid=new JPanel(new GridLayout(4, 4));
        for (String s:new String[] {
            "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "C", "=", "+"
        }) {
            JButton b=new JButton(s);
            b.addActionListener(e->press(s));
            grid.add(b);
        }
        add(grid);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(320, 360);
        setLocationRelativeTo(null);
    }
    private void press(String s) {
        if (Character.isDigit(s.charAt(0))) {
            if (fresh) {
                display.setText("");
                fresh=false;
            }
            display.setText(display.getText()+s);
            return;
        }
        if (s.equals("C")) {
            display.setText("");
            first=0;
            op="";
            fresh=true;
            return;
        }
        if (s.equals("=")) {
            try {
                double second=Double.parseDouble(display.getText());
                double r=switch (op) {
                    case"+"->first+second;
                    case"-"->first-second;
                    case"*"->first*second;
                    case"/"-> {
                        if (second==0)throw new ArithmeticException("Division by zero");
                        yield first/second;
                    }
                    default->second;
                };
                display.setText(String.valueOf(r));
                fresh=true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            return;
        }
        first=Double.parseDouble(display.getText());
        op=s;
        fresh=true;
    }
    public static void main(String[]a) {
        SwingUtilities.invokeLater(()->new CalculatorApp().setVisible(true));
    }
}
