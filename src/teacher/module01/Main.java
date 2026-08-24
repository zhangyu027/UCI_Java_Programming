package teacher.module01;
import java.util.*;
interface Describable { String description(); }
class Student implements Describable {
    private final String name;
    Student(String name){ this.name=name; }
    public String description(){ return "Student: " + name; }
}
public class Main {
    static double average(List<Double> xs){ return xs.stream().mapToDouble(Double::doubleValue).average().orElse(0); }
    static String grade(double a){ return a>=90?"A":a>=80?"B":a>=70?"C":a>=60?"D":"F"; }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in); System.out.print("Name: "); Student s=new Student(sc.nextLine());
        List<Double> scores=new ArrayList<>();
        while(scores.size()<3){ System.out.print("Score 0-100: "); if(sc.hasNextDouble()){ double v=sc.nextDouble(); if(v>=0&&v<=100) scores.add(v); else System.out.println("Out of range."); } else { System.out.println("Enter a number."); sc.next(); }}
        double a=average(scores); System.out.printf("%s%nAverage: %.2f Grade: %s%n",s.description(),a,grade(a)); sc.close();
    }
}
