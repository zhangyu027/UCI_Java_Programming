package instructor.assignments.m3.classesobjects;

/** Complete reference for the Canvas Module 3 School homework. */
public class School {
    private Student[] students;

    public School(Student[] students) {
        this.students = students.clone();
    }

    public Student getStudentWithHighestAverage() {
        if (students.length == 0) return null;
        Student highest = students[0];
        for (Student student : students) {
            if (student.getAverageMarks() > highest.getAverageMarks()) {
                highest = student;
            }
        }
        return highest;
    }

    public Student getStudentWithLowestAverage() {
        if (students.length == 0) return null;
        Student lowest = students[0];
        for (Student student : students) {
            if (student.getAverageMarks() < lowest.getAverageMarks()) {
                lowest = student;
            }
        }
        return lowest;
    }
}
