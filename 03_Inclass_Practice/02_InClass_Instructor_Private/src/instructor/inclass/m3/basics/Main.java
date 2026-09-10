package instructor.inclass.m3.basics;

public class Main {
    public static void main(String[]a) {
        Car c=new Car("Toyota", "Camry", 2024);
        c.drive();
        Book b=new Book("Core Java", "Horstmann");
        b.read();
        Student s=new Student("Ava", new int[] {
            90, 92, 88, 94, 91
        });
        System.out.printf("%s total=%d avg=%.2f grade=%s%n", s.getName(), s.total(), s.average(), s.grade());
    }
}
