package midterm.swing;

/*
* STUDENT STUDY GUIDE
* -------------------
* Identify the JFrame, layout, components, listeners, and the event-driven flow from a button click to the UI update.
*
* CHECKPOINT:
* Be able to explain the key Java concept without reading the code line-by-line.
*/
import javax.swing.*;
import java.awt.*;

public class SwingReview {
    public static void main(String[] a) {
        SwingUtilities.invokeLater(()-> {
            JFrame f=new JFrame("Midterm Swing Review"); 
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            f.setLayout(new GridLayout(2, 2)); 
            JTextField t=new JTextField(); 
            JButton b=new JButton("Click"); 
            JLabel l=new JLabel("Ready"); 
            b.addActionListener(e->l.setText(t.getText())); 
            f.add(t); f.add(b); f.add(l); f.pack(); f.setVisible(true);
        });
    }
}
