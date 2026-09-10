package instructor.inclass.m2;

import javax.swing.*;
import java.awt.*;
import java.nio.file.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class PersonalInfoFileApp_p extends JFrame {
    private final JTextField[] fields = {
        new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField()
    };
    private final Path path = Path.of("data", "Personal_info.txt");
    public PersonalInfoFileApp_p() {
        super("Personal Information");
        String[] labels= {
                "Name", "Address", "City", "State", "ZIP"
        };
        JPanel p=new JPanel(new GridLayout(6, 2, 5, 5));
        for (int i=0; i<labels.length; i++) {
            p.add(new JLabel(labels[i]));
            p.add(fields[i]);
        }
        JButton save=new JButton("Save"), load=new JButton("Load");
        save.addActionListener(e->save());
        load.addActionListener(e->load());
        p.add(save);
        p.add(load);
        add(p);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480, 280);
        setLocationRelativeTo(null);
    }
    private void save() {
        for (JTextField x:fields) if (x.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "All fields are required.");
            return;
        }
        try {
            Files.createDirectories(path.getParent());
            Files.writeString(path, String.join("|", Arrays.stream(fields).map(JTextField::getText).toList()) + System.lineSeparator(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            JOptionPane.showMessageDialog(this, "Save.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void load () {
        try {
            java.util.List<String> lines=Files.readAllLines(path);
            if (lines.isEmpty()) return;
            String[] parts=lines.get(lines.size()-1).split("\\|", -1);
            for (int i=0; i<Math.min(parts.length, fields.length); i++) fields[i].setText(parts[i]);
            JOptionPane.showMessageDialog(this, "Latest record loaded.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new PersonalInfoFileApp_p().setVisible(true));
    }
}
