package assignments.m3.classesobjects;

/** Module 3 Homework: Student class starter. */
public class Student {
    private String name;
    private int rollNumber;
    private int[] marks;

    public Student(String name, int rollNumber, int[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public int getTotalMarks() {
        // TODO: Add all five subject marks and return the total.
        return 0;
    }

    public double getAverageMarks() {
        // TODO: Return the average of the five marks.
        return 0.0;
    }

    public String getGrade() {
        // TODO: Use the Canvas ranges: A >=90, B >=80, C >=70, D >=60, otherwise F.
        return "TODO";
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }
}
