package instructor.assignments.m2.tasktracker;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class TaskTrackerApp extends JFrame {
    private final DefaultListModel<String> model = new DefaultListModel<>();
    private final Path file = Path.of("data", "tasks.txt");
    public TaskTrackerApp() {
        super("Task Tracker");
        load();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 420);
        showMenu();
        setLocationRelativeTo(null);
    }
    private void showMenu() {
        JPanel p=new JPanel(new GridLayout(3, 1, 10, 10));
        JButton add=new JButton("Add Task"), view=new JButton("View Tasks"), exit=new JButton("Exit");
        add.addActionListener(e->showAdd());
        view.addActionListener(e->showTasks());
        exit.addActionListener(e->dispose());
        p.add(add);
        p.add(view);
        p.add(exit);
        setContentPane(p);
        revalidate();
        repaint();
    }
    private void showAdd() {
        JTextField title=new JTextField(), due=new JTextField();
        JTextArea desc=new JTextArea(5, 20);
        JPanel p=new JPanel(new BorderLayout(8, 8));
        JPanel fields=new JPanel(new GridLayout(3, 2, 5, 5));
        fields.add(new JLabel("Title:"));
        fields.add(title);
        fields.add(new JLabel("Due date:"));
        fields.add(due);
        fields.add(new JLabel("Description:"));
        fields.add(new JScrollPane(desc));
        JButton save=new JButton("Save"), back=new JButton("Back");
        JPanel buttons=new JPanel();
        buttons.add(save);
        buttons.add(back);
        p.add(fields);
        p.add(buttons, BorderLayout.SOUTH);
        save.addActionListener(e-> {
            if (title.getText().isBlank()||due.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "Title and due date are required."); return;
            }
            model.addElement("[] "+title.getText()+" | "+due.getText()+" | "+desc.getText().replace('\n', ' ')); persist(); JOptionPane.showMessageDialog(this, "Task saved.");
        });
        back.addActionListener(e->showMenu());
        setContentPane(p);
        revalidate();
        repaint();
    }
    private void showTasks() {
        JList<String> list=new JList<>(model);
        JButton complete=new JButton("Mark as Complete"), back=new JButton("Back");
        complete.addActionListener(e-> {
            int i=list.getSelectedIndex(); if (i>=0&&!model.get(i).startsWith("[X]")) {
                model.set(i, model.get(i).replaceFirst("\\[ \\]", "[X]")); persist();
            }
        });
        back.addActionListener(e->showMenu());
        JPanel p=new JPanel(new BorderLayout());
        p.add(new JScrollPane(list));
        JPanel b=new JPanel();
        b.add(complete);
        b.add(back);
        p.add(b, BorderLayout.SOUTH);
        setContentPane(p);
        revalidate();
        repaint();
    }
    private void load() {
        try {
            Files.createDirectories(file.getParent());
            if (Files.exists(file))for (String s:Files.readAllLines(file))model.addElement(s);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void persist() {
        try {
            Files.write(file, Collections.list(model.elements()));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new TaskTrackerApp().setVisible(true));
    }
}
