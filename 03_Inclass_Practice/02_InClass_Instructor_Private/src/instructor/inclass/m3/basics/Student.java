package instructor.inclass.m3.basics;

/** Complete instructor reference based on the Canvas Student starter. */
public class Student {
    private String name;
    private int rollNumber;
    private int[] marks = new int[5];

    public Student(String name, int rollNumber, int[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks.clone();
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public int getTotalMarks() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public double getAverageMarks() {
        return getTotalMarks() / (double) marks.length;
    }

    public String getGrade() {
        double average = getAverageMarks();

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

    public static void main(String[] args) {
        int[] marks = {95, 88, 92, 90, 85};
        Student student = new Student("Alex Chen", 101, marks);

        System.out.println("Name: " + student.getName());
        System.out.println("Roll Number: " + student.getRollNumber());
        System.out.println("Total Marks: " + student.getTotalMarks());
        System.out.println("Average Marks: " + student.getAverageMarks());
        System.out.println("Grade: " + student.getGrade());
    }
}
