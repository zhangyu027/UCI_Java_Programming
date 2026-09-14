package instructor.assignments.m3.classesobjects;

/** Complete reference for the Canvas Module 3 Student homework. */
public class Student {
    private String name;
    private int rollNumber;
    private int[] marks;

    public Student(String name, int rollNumber, int[] marks) {
        if (marks == null || marks.length != 5) {
            throw new IllegalArgumentException("Exactly five subject marks are required.");
        }
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks.clone();
    }

    public int getTotalMarks() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public double getAverageMarks() {
        return getTotalMarks() / 5.0;
    }

    public String getGrade() {
        double average = getAverageMarks();
        if (average >= 90) return "A";
        if (average >= 80) return "B";
        if (average >= 70) return "C";
        if (average >= 60) return "D";
        return "F";
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return name + " (#" + rollNumber + ") average="
            + String.format("%.2f", getAverageMarks()) + " grade=" + getGrade();
    }
}
