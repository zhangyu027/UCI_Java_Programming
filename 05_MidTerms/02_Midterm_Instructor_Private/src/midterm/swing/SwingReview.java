package midterm.swing;

import javax.swing.*;
import java.awt.*;

public class SwingReview {
    public static void main(String[] a) {
        SwingUtilities.invokeLater(()-> {
            JFrame f=new JFrame("Midterm Swing Review"); f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); f.setLayout(new GridLayout(2, 2)); JTextField t=new JTextField(); JButton b=new JButton("Click"); JLabel l=new JLabel("Ready"); b.addActionListener(e->l.setText(t.getText())); f.add(t); f.add(b); f.add(l); f.pack(); f.setVisible(true);
        });
    }
}
