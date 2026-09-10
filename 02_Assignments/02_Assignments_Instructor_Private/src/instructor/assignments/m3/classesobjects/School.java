package instructor.assignments.m3.classesobjects;

public class School {
    private final Student[] students;
    public School(Student[] s) {
        students=s.clone();
    }
    public Student getStudentWithHighestAverage() {
        Student best=students[0];
        for (Student s:students)if (s.getAverageMarks()>best.getAverageMarks())best=s;
        return best;
    }
    public Student getStudentWithLowestAverage() {
        Student low=students[0];
        for (Student s:students)if (s.getAverageMarks()<low.getAverageMarks())low=s;
        return low;
    }
}
