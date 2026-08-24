package Assignment.module01;
public class Student {

    private String name;
    private double[] scores;

    public Student(String name, double[] scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public double calculateAverage() {
        double total = 0;

        for (double score : scores) {
            total += score;
        }

        return total / scores.length;
    }

    public String getLetterGrade() {
        double average = calculateAverage();

        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}