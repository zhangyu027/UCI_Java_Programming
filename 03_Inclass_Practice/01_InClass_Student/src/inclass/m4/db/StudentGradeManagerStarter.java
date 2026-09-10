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
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/** Student starter: calculate and persist midterm/final grades. */
public class StudentGradeManagerStarter extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JTextField midtermField = new JTextField(8);
    private final JTextField finalField = new JTextField(8);
    private final JLabel resultLabel = new JLabel("Average / Grade: -");
    public StudentGradeManagerStarter() {
        super("Student Grade Manager Starter");
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.add(new JLabel("Midterm score:"));
        panel.add(midtermField);
        panel.add(new JLabel("Final score:"));
        panel.add(finalField);
        JButton button = new JButton("Calculate & Save");
        panel.add(button);
        panel.add(resultLabel);
        // TODO 1: Calculate average and letter grade.
        // TODO 2: Validate scores are between 0 and 100.
        // TODO 3: Save the result with Db.open("student_grade_db").
        // HINT SQL:
        // INSERT INTO student_grades
        // (midterm_score, final_score, average_grade)
        // VALUES(?, ?, ?)
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 220);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
        () -> new StudentGradeManagerStarter().setVisible(true));
    }
}
