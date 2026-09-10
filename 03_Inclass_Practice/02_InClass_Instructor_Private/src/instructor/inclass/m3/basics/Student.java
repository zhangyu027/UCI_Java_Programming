package instructor.inclass.m3.basics;

public class Student {
    private String name;
    private int[] marks;
    public Student(String n, int[]m) {
        name=n;
        marks=m.clone();
    }
    public String getName() {
        return name;
    }
    public int total() {
        int s=0;
        for (int x:marks)s+=x;
        return s;
    }
    public double average() {
        return total()/(double)marks.length;
    }
    public String grade() {
        double a=average();
        return a>=90?"A":a>=80?"B":a>=70?"C":a>=60?"D":"F";
    }
}
