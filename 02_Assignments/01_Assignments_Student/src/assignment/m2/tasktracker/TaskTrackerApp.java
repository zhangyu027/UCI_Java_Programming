package assignment.m2.tasktracker;

/*
 * MODULE 2 HOMEWORK - STUDENT STARTER
 * -----------------------------------
 * This starter follows the Canvas Task Tracker structure.
 * Complete the TODO sections without replacing the whole program.
 *
 * Required features from the homework:
 * - Main Menu: Add Task, View Tasks, Exit
 * - Add Task: title, description, due date, Save
 * - View Tasks: display saved tasks and mark tasks complete
 * - Error handling for invalid input
 * - Persistent task storage between program executions
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TaskTrackerApp {

    private JFrame mainFrame;
    private JPanel mainMenuPanel;
    private JPanel addTaskPanel;
    private JPanel viewTasksPanel;

    private JTextField titleField;
    private JTextField descriptionField;
    private JTextField dueDateField;

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

        addTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.getContentPane().removeAll();
                mainFrame.add(addTaskPanel);
                mainFrame.pack();
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });

        viewTasksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO 1: Refresh the View Tasks panel so it displays
                // all tasks and their completion status.

                mainFrame.getContentPane().removeAll();
                mainFrame.add(viewTasksPanel);
                mainFrame.pack();
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        mainMenuPanel.add(addTaskButton);
        mainMenuPanel.add(viewTasksButton);
        mainMenuPanel.add(exitButton);
    }

    private void createAddTaskPanel() {
        addTaskPanel = new JPanel(new GridLayout(4, 2));

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(20);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionField = new JTextField(20);

        JLabel dueDateLabel = new JLabel("Due Date (MM/dd/yyyy):");
        dueDateField = new JTextField(20);

        JButton saveButton = new JButton("Save");
        JButton backButton = new JButton("Back");

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText().trim();
                String description = descriptionField.getText().trim();
                String dueDateString = dueDateField.getText().trim();

                // TODO 2: Validate that the required fields are not empty.
                // TODO 3: Parse dueDateString with dateFormat.
                //         If parsing fails, show a meaningful error message.
                // TODO 4: Create a Task object and add it to tasks.
                // TODO 5: Save the updated task collection to a file so
                //         tasks can be retrieved after the program restarts.
                // TODO 6: Show the saved task and clear the input fields.

                /*
                 * Canvas pattern for date validation:
                 * try {
                 *     Date dueDate = dateFormat.parse(dueDateString);
                 * } catch (java.text.ParseException ex) {
                 *     JOptionPane.showMessageDialog(
                 *         mainFrame,
                 *         "Invalid date format. Use MM/dd/yyyy."
                 *     );
                 *     return;
                 * }
                 */
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMainMenu();
            }
        });

        addTaskPanel.add(titleLabel);
        addTaskPanel.add(titleField);
        addTaskPanel.add(descriptionLabel);
        addTaskPanel.add(descriptionField);
        addTaskPanel.add(dueDateLabel);
        addTaskPanel.add(dueDateField);
        addTaskPanel.add(saveButton);
        addTaskPanel.add(backButton);
    }

    private void createViewTasksPanel() {
        viewTasksPanel = new JPanel(new BorderLayout());

        JLabel placeholderLabel = new JLabel(
            "TODO: Display saved tasks here."
        );

        JButton markCompleteButton = new JButton("Mark as Complete");
        JButton backButton = new JButton("Back");

        markCompleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO 7: Determine which task the user selected.
                // TODO 8: Mark that Task as completed.
                // TODO 9: Visually differentiate completed tasks.
                // TODO 10: Persist the updated completion status.
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMainMenu();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(markCompleteButton);
        buttonPanel.add(backButton);

        viewTasksPanel.add(placeholderLabel, BorderLayout.CENTER);
        viewTasksPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void showMainMenu() {
        mainFrame.getContentPane().removeAll();
        mainFrame.add(mainMenuPanel);
        mainFrame.pack();
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    // TODO 11: Add methods for loading and saving tasks.
    // HINT: BufferedReader/BufferedWriter are consistent with Module 2 file I/O.

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TaskTrackerApp();
            }
        });
    }
}
