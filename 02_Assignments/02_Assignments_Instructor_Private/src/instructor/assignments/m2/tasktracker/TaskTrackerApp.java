package instructor.assignments.m2.tasktracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Module 2 Homework instructor reference solution.
 *
 * This version intentionally follows the Canvas structure:
 * JFrame + multiple JPanels, traditional ActionListener objects,
 * SimpleDateFormat, and a separate Task class.
 *
 * It also completes the requirements that the Canvas sample leaves unfinished:
 * task collection, View Tasks, Mark as Complete, and persistence between runs.
 */
public class TaskTrackerApp {

    private JFrame mainFrame;
    private JPanel mainMenuPanel;
    private JPanel addTaskPanel;
    private JPanel viewTasksPanel;

    private JTextField titleField;
    private JTextField descriptionField;
    private JTextField dueDateField;

    private JList<String> taskList;
    private DefaultListModel<String> taskListModel;

    private final ArrayList<Task> tasks = new ArrayList<>();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private final Path dataFile = Path.of("data", "tasks.txt");

    public TaskTrackerApp() {
        mainFrame = new JFrame("Task Tracker");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dateFormat.setLenient(false);

        loadTasks();
        createMainMenuPanel();
        createAddTaskPanel();
        createViewTasksPanel();

        showPanel(mainMenuPanel);
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
                showPanel(addTaskPanel);
            }
        });

        viewTasksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTaskList();
                showPanel(viewTasksPanel);
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
                saveTask();
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPanel(mainMenuPanel);
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

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);

        JButton completeButton = new JButton("Mark as Complete");
        JButton backButton = new JButton("Back");

        completeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();

                if (selectedIndex < 0) {
                    JOptionPane.showMessageDialog(
                        mainFrame,
                        "Please select a task first."
                    );
                    return;
                }

                tasks.get(selectedIndex).setCompleted(true);
                persistTasks();
                refreshTaskList();
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPanel(mainMenuPanel);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(completeButton);
        buttonPanel.add(backButton);

        viewTasksPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        viewTasksPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void saveTask() {
        String title = titleField.getText().trim();
        String description = descriptionField.getText().trim();
        String dueDateString = dueDateField.getText().trim();

        if (title.isEmpty() || description.isEmpty() || dueDateString.isEmpty()) {
            JOptionPane.showMessageDialog(
                mainFrame,
                "Title, description, and due date are required."
            );
            return;
        }

        Date dueDate;

        try {
            dueDate = dateFormat.parse(dueDateString);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(
                mainFrame,
                "Invalid date format. Use MM/dd/yyyy."
            );
            return;
        }

        Task task = new Task(title, description, dueDate);
        tasks.add(task);
        persistTasks();

        JOptionPane.showMessageDialog(
            mainFrame,
            "Title: " + title
                + "\nDescription: " + description
                + "\nDue Date: " + dueDateString
        );

        titleField.setText("");
        descriptionField.setText("");
        dueDateField.setText("");
    }

    private void refreshTaskList() {
        taskListModel.clear();

        for (Task task : tasks) {
            String status = task.isCompleted() ? "[Completed] " : "[ ] ";
            taskListModel.addElement(
                status
                    + task.getTitle()
                    + " | " + task.getDescription()
                    + " | Due: " + dateFormat.format(task.getDueDate())
            );
        }
    }

    private void loadTasks() {
        File file = dataFile.toFile();

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\t", -1);

                if (parts.length != 4) {
                    continue;
                }

                try {
                    boolean completed = Boolean.parseBoolean(parts[0]);
                    String title = parts[1];
                    String description = parts[2];
                    Date dueDate = dateFormat.parse(parts[3]);

                    Task task = new Task(title, description, dueDate);
                    task.setCompleted(completed);
                    tasks.add(task);
                } catch (ParseException ignored) {
                    // Skip a malformed saved record and continue loading others.
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                mainFrame,
                "Unable to load tasks: " + ex.getMessage()
            );
        }
    }

    private void persistTasks() {
        File file = dataFile.toFile();
        File parent = file.getParentFile();

        if (parent != null) {
            parent.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Task task : tasks) {
                writer.write(Boolean.toString(task.isCompleted()));
                writer.write("\t");
                writer.write(cleanForStorage(task.getTitle()));
                writer.write("\t");
                writer.write(cleanForStorage(task.getDescription()));
                writer.write("\t");
                writer.write(dateFormat.format(task.getDueDate()));
                writer.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                mainFrame,
                "Unable to save tasks: " + ex.getMessage()
            );
        }
    }

    private String cleanForStorage(String text) {
        return text.replace('\t', ' ').replace('\n', ' ').replace('\r', ' ');
    }

    private void showPanel(JPanel panel) {
        mainFrame.getContentPane().removeAll();
        mainFrame.add(panel);
        mainFrame.pack();
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TaskTrackerApp();
            }
        });
    }
}
