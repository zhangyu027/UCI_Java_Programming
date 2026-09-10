package instructor.assignments.m3.classesobjects;

public class Main {
    public static void main(String[] a) {
        Student[] s= {
            new Student("Ava", 1, new int[] {
                95, 92, 88, 91, 94
            }), new Student("Ben", 2, new int[] {
                75, 72, 78, 80, 74
            }), new Student("Cara", 3, new int[] {
                84, 86, 82, 85, 87
            })
        };
        School school=new School(s);
        for (Student x:s)System.out.println(x);
        System.out.println("Highest: "+school.getStudentWithHighestAverage());
        System.out.println("Lowest: "+school.getStudentWithLowestAverage());
    }
}
