package assignments.m3.classesobjects;

/** M3A: Student class starter. */
public class Student {
    private String name; private int rollNumber; private int[] marks;
    public Student(String name, int rollNumber, int[] marks) { this.name=name; this.rollNumber=rollNumber; this.marks=marks; }
    public int getTotalMarks() { /* TODO: Sum all marks. */ return 0; }
    public double getAverageMarks() { /* TODO: Calculate average. */ return 0.0; }
    public String getGrade() { /* TODO: Return A-F based on assignment ranges. */ return "TODO"; }
    public String getName() { return name; }
    public int getRollNumber() { return rollNumber; }
}
