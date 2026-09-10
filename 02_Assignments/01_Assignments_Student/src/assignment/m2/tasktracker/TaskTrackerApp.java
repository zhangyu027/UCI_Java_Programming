package assignment.m2.tasktracker;

/*
* STUDENT HINTS
* -------------
* Build the Swing program in small steps:
* 1. Create the JFrame and layout.
* 2. Add title/description/due-date inputs.
* 3. Add Add, View, and Exit actions.
* 4. Track completion status.
* 5. Add validation and persistence.
*
* KEY IDEA:
* Event listeners should call small helper methods rather than putting all logic
* directly inside one actionPerformed block.
*/
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/** M2 Homework: Swing Task Tracker starter. */
public class TaskTrackerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TaskTrackerApp::createAndShowGui);
    }
    private static void createAndShowGui() {
        JFrame frame = new JFrame("Task Tracker - Student Starter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(8, 8));
        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 8, 8));
        JTextField titleField = new JTextField();
        JTextField dueDateField = new JTextField();
        JTextArea descriptionArea = new JTextArea(4, 30);
        JButton addButton = new JButton("Add Task");
        JButton viewButton = new JButton("View Tasks");
        JButton exitButton = new JButton("Exit");
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Due Date:"));
        inputPanel.add(dueDateField);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(exitButton);
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(descriptionArea, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        // TODO: Store tasks in a collection.
        // TODO: Add title, description, and due date.
        // TODO: View tasks and allow completed status.
        // TODO: Visually differentiate completed tasks.
        // TODO: Add error handling and persistent task storage.
        /*
        * HINT:
        * Start with an ArrayList<Task>.
        * Make the GUI work first, then add file persistence.
        * exitButton.addActionListener(e -> System.exit(0));
        *
        * ANSWER CHECKPOINT:
        * Your finished program should still show tasks after restarting if
        * persistent storage is implemented correctly.
        */
        frame.setSize(600, 360);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
