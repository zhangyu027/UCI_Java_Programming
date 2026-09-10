package instructor.assignments.m3.classesobjects;

public class Student {
    private final String name;
    private final int rollNumber;
    private final int[] marks;
    public Student(String name, int rollNumber, int[] marks) {
        this.name=name;
        this.rollNumber=rollNumber;
        this.marks=marks.clone();
    }
    public String getName() {
        return name;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public int getTotalMarks() {
        int s=0;
        for (int m:marks)s+=m;
        return s;
    }
    public double getAverageMarks() {
        return getTotalMarks()/(double)marks.length;
    }
    public String getGrade() {
        double a=getAverageMarks();
        return a>=90?"A":a>=80?"B":a>=70?"C":a>=60?"D":"F";
    }
    public String toString() {
        return name+" (#"+rollNumber+") avg="+String.format("%.2f", getAverageMarks())+" grade="+getGrade();
    }
}
