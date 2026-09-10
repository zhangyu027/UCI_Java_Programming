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
/** M3A: School class starter. */
public class School {
    private Student[] students;
    public School(Student[] students) {
        this.students = students;
    }
    public Student getStudentWithHighestAverage() {
        // TODO: Compare getAverageMarks() for each student.
        // HINT: start with students[0] as the current best.
        return null;
    }
    public Student getStudentWithLowestAverage() {
        // TODO: Similar to highest, but keep the smallest average.
        return null;
    }
}
