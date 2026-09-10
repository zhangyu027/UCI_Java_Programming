package instructor.inclass.m3.polymorphism;

interface Shape {
    double area();
}
class Circle implements Shape {
    double r;
    Circle(double r) {
        this.r=r;
    }
    public double area() {
        return Math.PI*r*r;
    }
}
class Rectangle implements Shape {
    double w, h;
    Rectangle(double w, double h) {
        this.w=w;
        this.h=h;
    }
    public double area() {
        return w*h;
    }
}
public class PolymorphismDemo {
    public static void main(String[]a) {
        Shape[] s= {
            new Circle(2), new Rectangle(3, 4)
        };
        for (Shape x:s)System.out.printf("Area=%.2f%n", x.area());
    }
}
