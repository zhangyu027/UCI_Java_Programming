package assignment.m3.classesobjects;

/*
* STUDENT HINTS
* -------------
* Student should store name, roll number, and 5 marks.
* Separate responsibilities:
* - Student: total, average, grade.
* - School: compare students and find highest/lowest average.
*
* CHECKPOINT:
* Prefer methods such as calculateTotal() and calculateAverage() instead of
* repeating the same calculation in Main.
*/
/** M3A: Student class starter. */
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
        // TODO: Sum all five marks.
        /* HINT: use a for-each loop over marks. */
        return 0;
    }
    public double getAverageMarks() {
        // TODO: total / number of marks.
        return 0.0;
    }
    public String getGrade() {
        // TODO: Return A-F based on the assignment's grade ranges.
        /* HINT: evaluate ranges from highest to lowest. */
        return "TODO";
    }
    public String getName() {
        return name;
    }
    public int getRollNumber() {
        return rollNumber;
    }
}
