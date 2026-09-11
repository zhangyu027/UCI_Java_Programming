package instructor.inclass.m4.db;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/** Instructor reference: calculate grades and save to student_grade_db. */
public class StudentGradeManager extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JTextField midtermField = new JTextField(8);
    private final JTextField finalField = new JTextField(8);
    private final JLabel resultLabel = new JLabel("Average / Grade: -");
    public StudentGradeManager() {
        super("Student Grade Manager");
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.add(new JLabel("Midterm score:"));
        panel.add(midtermField);
        panel.add(new JLabel("Final score:"));
        panel.add(finalField);
        JButton calculateButton = new JButton("Calculate & Save");
        panel.add(calculateButton);
        panel.add(resultLabel);
        calculateButton.addActionListener(e -> calculateAndSave());
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 220);
        setLocationRelativeTo(null);
    }
    private void calculateAndSave() {
        try {
            double midterm = Double.parseDouble(midtermField.getText());
            double finalScore = Double.parseDouble(finalField.getText());
            if (midterm < 0 || midterm > 100
            || finalScore < 0 || finalScore > 100) {
                throw new IllegalArgumentException(
                "Scores must be between 0 and 100.");
            }
            double average = (midterm + finalScore) / 2.0;
            String grade = letterGrade(average);
            resultLabel.setText(
            String.format("Average %.2f / %s", average, grade));
            String sql = """
            INSERT INTO student_grades
            (midterm_score, final_score, average_grade)
            VALUES(?, ?, ?)
            """;
            try(Connection connection = Db.open("student_grade_db");
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setDouble(1, midterm);
                ps.setDouble(2, finalScore);
                ps.setString(3, grade);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private static String letterGrade(double average) {
        if (average >= 90) return "A";
        if (average >= 80) return "B";
        if (average >= 70) return "C";
        if (average >= 60) return "D";
        return "F";
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
        () -> new StudentGradeManager().setVisible(true));
    }
}
