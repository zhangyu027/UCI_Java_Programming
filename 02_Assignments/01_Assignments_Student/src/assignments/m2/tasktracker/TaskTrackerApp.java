package assignments.m2.tasktracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/** Module 2 Homework student starter aligned with the Canvas Task Tracker. */
public class TaskTrackerApp {
    private JFrame mainFrame;
    private JPanel mainMenuPanel, addTaskPanel, viewTasksPanel;
    private JTextField titleField, descriptionField, dueDateField;
    private final ArrayList<Task> tasks = new ArrayList<>();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    public TaskTrackerApp() {
        mainFrame = new JFrame("Task Tracker");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dateFormat.setLenient(false);
        createMainMenuPanel();
        createAddTaskPanel();
        createViewTasksPanel();
        mainFrame.add(mainMenuPanel);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
    private void createMainMenuPanel() {
        mainMenuPanel = new JPanel(new GridLayout(3, 1));
        JButton addTaskButton = new JButton("Add Task");
        JButton viewTasksButton = new JButton("View Tasks");
        JButton exitButton = new JButton("Exit");
        addTaskButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { showPanel(addTaskPanel); }});
        viewTasksButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { /* TODO: refresh task display */ showPanel(viewTasksPanel); }});
        exitButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { System.exit(0); }});
        mainMenuPanel.add(addTaskButton); mainMenuPanel.add(viewTasksButton); mainMenuPanel.add(exitButton);
    }
    private void createAddTaskPanel() {
        addTaskPanel = new JPanel(new GridLayout(4, 2));
        titleField = new JTextField(20); descriptionField = new JTextField(20); dueDateField = new JTextField(20);
        JButton saveButton = new JButton("Save"); JButton backButton = new JButton("Back");
        saveButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {
            // TODO: validate fields, parse date, create Task, persist it, and clear fields.
        }});
        backButton.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { showPanel(mainMenuPanel); }});
        addTaskPanel.add(new JLabel("Title:")); addTaskPanel.add(titleField);
        addTaskPanel.add(new JLabel("Description:")); addTaskPanel.add(descriptionField);
        addTaskPanel.add(new JLabel("Due Date (MM/dd/yyyy):")); addTaskPanel.add(dueDateField);
        addTaskPanel.add(saveButton); addTaskPanel.add(backButton);
    }
    private void createViewTasksPanel() {
        viewTasksPanel = new JPanel(new BorderLayout());
        viewTasksPanel.add(new JLabel("TODO: Display saved tasks here."), BorderLayout.CENTER);
        JButton complete = new JButton("Mark as Complete"); JButton back = new JButton("Back");
        complete.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { /* TODO: mark selected task complete and persist */ }});
        back.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { showPanel(mainMenuPanel); }});
        JPanel buttons = new JPanel(); buttons.add(complete); buttons.add(back); viewTasksPanel.add(buttons, BorderLayout.SOUTH);
    }
    private void showPanel(JPanel panel) {
        mainFrame.getContentPane().removeAll(); mainFrame.add(panel); mainFrame.pack(); mainFrame.revalidate(); mainFrame.repaint();
    }
    // TODO: Add loading/saving methods using BufferedReader/BufferedWriter.
    public static void main(String[] args) { SwingUtilities.invokeLater(new Runnable() { public void run() { new TaskTrackerApp(); }}); }
}
