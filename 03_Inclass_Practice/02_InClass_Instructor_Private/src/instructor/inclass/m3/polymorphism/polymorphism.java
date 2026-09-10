package instructor.inclass.m3.polymorphism;
interface Shape_p {
    double area();
}
class Circle_p implements Shape_p {
    double r;
    Circle_p(double r) {
        this.r=r;
    }
    public double area() {
        return Math.PI*r*r;
    }
}
class Rectangle_p implements Shape_p {
    double w, h;
    Rectangle_p(double w, double h) {
        this.w=w;
        this.h=h;
    }
    public double area() {
        return w*h;
    }
}
public class polymorphism {
    public static void main(String[]a) {
        Shape_p[] s= {
          new Circle_p(2), new Rectangle_p(3, 4)   
        };
        for (Shape_p x:s)System.out.printf("Area=%.2f%n", x.area());
    }
}


