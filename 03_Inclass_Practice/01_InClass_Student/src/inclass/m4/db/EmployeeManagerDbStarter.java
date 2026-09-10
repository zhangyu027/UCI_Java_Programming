package inclass.m4.db;

/*
* IN-CLASS STUDENT HINTS - JDBC
* -----------------------------
* First checkpoint: DatabaseConnectionTest must connect successfully.
*
* Shared helper:
* - Db.getConnection() opens the default University database connection.
* - Db.open() is a compatibility alias.
* - Some examples may use Db.open(databaseName) for another practice database.
*
* JDBC STEPS:
* Connection -> PreparedStatement -> set parameters -> execute -> ResultSet
*
* Keep SQL values parameterized with ? placeholders.
*/
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/** Step 2: connect Employee Manager to company_db. */
public class EmployeeManagerDbStarter extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JTextField nameField = new JTextField(18);
    private final JTextArea outputArea = new JTextArea();
    public EmployeeManagerDbStarter() {
        super("Employee Manager - JDBC Starter");
        JPanel top = new JPanel(new FlowLayout());
        top.add(new JLabel("Name:"));
        top.add(nameField);
        for (String label : new String[] {
            "Add", "Update", "Delete", "Display"
        }) {
            JButton button = new JButton(label);
            top.add(button);
            // TODO: Attach an ActionListener to each button.
            // HINT: route the label to a method such as addEmployee().
        }
        outputArea.setEditable(false);
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
        // TODO: Implement CRUD methods with Db.open("company_db").
        // HINT INSERT: INSERT INTO employees(name) VALUES(?)
        // HINT UPDATE: UPDATE employees SET name = ? WHERE id = ?
        // HINT DELETE: DELETE FROM employees WHERE id = ?
        // HINT SELECT: SELECT id, name FROM employees ORDER BY id
        // ANSWER CHECKPOINT: use PreparedStatement for user input.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(680, 420);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
        () -> new EmployeeManagerDbStarter().setVisible(true));
    }
}
